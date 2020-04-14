package com.auto.mcuservice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.os.SystemProperties;
import com.auto.constant.McuConstant;
import com.dgl.auto.constant.CallbackConstant;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import com.auto.serialport.SerialPort;
import com.auto.setting.SettingService;

public class McuService extends IMcuManager.Stub implements McuConstant, McuConstant.McuCmd, McuConstant.HostCmd, McuConstant.PacketExtraMsg, McuConstant.PowerUpStatus, McuMsgQueueManager.MainInternalMsgIndex, CallbackConstant {
    private final String[] MySystemService = new String[] { "opandoraservice", "com/auto/mcuservice", "com/auto/radioservice", "settingservice", "autoeventservice", "canbusservice", "swcservice", "opandoraservice" };
    private final String[] userServcies = new String[] { "com.dgl.assist.act.AsService", "android.dgl.act.backcar.service", "android.dgl.act.source.service", "android.dgl.act.service.adapter" };
    private final String[] userServciesClass = new String[] { "com.dgl.assist.AsService", "android.dgl.backcar.BackCarService", "android.dgl.source.AutoSourceService", "android.dgl.btservice.adapter.AdapterService" };
    private final String[] userServciesPackageName = new String[] { "com.dgl.assist", "android.dgl.backcar", "android.dgl.source", "android.dgl.btservice" };

    public static final String TAG = "McuSevice";
    public static final String MCU_SERVICE = "McuService";

    public static final String ACTION_PREQB_POWERON = "android.intent.action.SCREEN_ON";
    public static final String ACTION_QB_POWEROFF = "android.intent.action.SCREEN_OFF";
    public static final String ACTION_SAVE_MCU_REST_STATUS = "autochips.intent.action.ACTION_SAVE_MCU_REST_STATUS";
    public static final String kEY_MCU_REST_STATUS = "autochips.intent.action.kEY_MCU_REST_STATUS";

    private static final int MCU_SHAKE_SUCCESS =            1;
    private static final int MCU_WAIT_ARM2_FIN_SUCCESS =    2;
    private static final int ARM_HEART_BEAT =               6;
    private static final int ARM_RESUME =                   5;
    private static final int ARM_RUN_MODE =                 3;
    private static final int ARM_SUSPEND =                  4;
    private static final int ARM_TEST_MODE =                7;

    public static final int DISC_MANNUL_PLUGIN = 2;
    public static final int DISC_PLUGIN = 1;
    public static final int DISC_REMOVE = 0;

    public class ResendTimerTask extends TimerTask {
        public void run() {
            synchronized (McuService.sMcuRequestsLock) {
                McuService.this.CheckMcuRequests();
            }
        }
    }
    public class ResendTimerTaskWShake extends TimerTask {
        public void run() {
            McuService.this.EnterPowerUpNextState(true);
        }
    }
    public class McuPacket {
        private byte[] mData;

        McuPacket() {}
        McuPacket(byte[] data) { mData = data; }

        void SetData(byte[] data) { mData = data; }

        byte syn() { return mData[0]; }
        byte start() { return mData[1]; }
        byte tranID() { return mData[2]; }
        public int packetLen() { return mData[3]; }
        byte cmd() { return mData[4]; }
        public byte param(int index) { return mData[index + 5]; }
        byte highCRC() { return mData[packetLen() + 4]; }
        byte lowCRC() { return mData[packetLen() + 5]; }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Received MCU McuPacket: ");
            Locale locale = Locale.ENGLISH;
            stringBuffer.append(String.format(locale, "%02x %02x %02x %02x %02x ", new Object[] { Byte.valueOf(syn()), Byte.valueOf(start()), Byte.valueOf(tranID()), Integer.valueOf(packetLen()), Byte.valueOf(cmd()) }));
            for (int i = 0; i < packetLen() - 1; i++) {
                stringBuffer.append(String.format("%02x ", new Object[] { Integer.valueOf(param(i) & 0xFF) }));
            }
            stringBuffer.append(String.format(locale, "%02x %02x", new Object[] { Byte.valueOf(highCRC()), Byte.valueOf(lowCRC()) }));
            stringBuffer.append("\n");
            return stringBuffer.toString();
        }
    }
    class McuOpHandler extends Handler {
        private int countHeartBeat = 0;

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    McuService.this.systemReady();
                    McuService.this.initSystemConfig();
                    McuService.this.startUserServices();
                    McuService.this.ResumeMode();
                    McuService.this.mMcuOpHandler.sendEmptyMessageDelayed(6, 3000L);
                    break;
                case 2:
                    try {
                        McuService.this.m_SerialPort.openSerialPort(new File("/dev/ttyMT3"), 115200);
                        Log.i("McuService", "MCU_WAIT_ARM2_FIN_SUCCESS---->getIO Stream");
                        McuService.this.mInputStream = McuService.this.m_SerialPort.getInputStream();
                        McuService.this.mOutputStream = McuService.this.m_SerialPort.getOutputStream();
                    } catch (SecurityException securityException) {
                        securityException.printStackTrace();
                    }
                    McuService.this.mMcuReceiver = new McuService.MCUReceiver();
                    McuService.this.mMcuReceiver.start();
                    McuService.this.mSendProcessTimer = null;
                    McuService.this.mSendTask = null;
                    McuService.this.mResendTimerWShake = null;
                    McuService.this.mSendTaskWShake = null;
                    McuMsgQueueManager.getInstance().init();
                    McuService.this.EnterPowerUpNextState(true);
                    break;
                case 3:
                    McuService.this.ResumeMode();
                    break;
                case 5:
                    McuService.this.Resume();
                    break;
                case 6:
                    McuService.this.mMcuOpHandler.sendEmptyMessageDelayed(6, 3000L);
                    McuService.this.SndCmd(CMD_GET_DEVICE_DETECTION_INFO);
                    if (McuService.this.mMcuInfo.getmMcuVersion().getmStrMcuVersion() == null) {
                        McuService.this.SndCmd(CMD_GET_VERSION);
                        Log.e(TAG, "ReGetmMcuVersion");
                    }
                    if (countHeartBeat < 4) {
                        SystemProperties.set("ctl.start", "dglsecret");
                        this.countHeartBeat++;
                    }
                    break;
            }
        }
    }
    class MCUReceiver extends Thread implements McuConstant.McuPacketStatus, McuConstant.McuCmd, McuConstant.PacketExtraMsg {
        private static final int MAX_BUFFER_SIZE = PacketExtraMsg.MAX_BUFFER_SIZE;

        boolean bExit = false;
        int mMcuPacketStatus = 0;
        int mPackDataIndex = 0;
        byte[] recvBuffer = new byte[MAX_BUFFER_SIZE];

        private void AnalyzeDataInBuffer() throws IOException {
            while (McuService.this.mInputStream.available() > 0 && !McuService.this.mBValidCmd) {
                if (mPackDataIndex >= MAX_BUFFER_SIZE) {
                    mPackDataIndex = 0;
                    mMcuPacketStatus = PACKET_INDEX_SYNC;
                }
                byte[] data = new byte[1];
                McuService.this.mInputStream.read(data, 0, 1);
                recvBuffer[mPackDataIndex] = data[0];
                mPackDataIndex = mPackDataIndex + 1;
                switch (mMcuPacketStatus) {
                    case PACKET_INDEX_SYNC:
                        if (mPackDataIndex == 1) {
                            if (Utility.byteToInt(recvBuffer[0]) == SYNC) {
                                mMcuPacketStatus = PACKET_INDEX_START;
                                continue;
                            } else {
                                ClsSerial();
                            }
                        }
                        mPackDataIndex = 0;
                        mMcuPacketStatus = PACKET_INDEX_SYNC;
                        break;
                    case PACKET_INDEX_START:
                        if (mPackDataIndex == 2) {
                            if (Utility.byteToInt(recvBuffer[1]) == HEADER) {
                                mMcuPacketStatus = PACKET_INDEX_TRANSACTION_ID;
                                continue;
                            } else {
                                ClsSerial();
                            }
                        }
                        mPackDataIndex = 0;
                        mMcuPacketStatus = PACKET_INDEX_SYNC;
                        break;
                    case PACKET_INDEX_TRANSACTION_ID:
                        if (mPackDataIndex == 3) {
                            mMcuPacketStatus = PACKET_INDEX_LENGTH;
                            continue;
                        }
                        mPackDataIndex = 0;
                        mMcuPacketStatus = PACKET_INDEX_SYNC;
                        break;
                    case PACKET_INDEX_LENGTH:
                        if (mPackDataIndex == 4) {
                            mMcuPacketStatus = PACKET_INDEX_CMD;
                            if (Utility.byteToInt(recvBuffer[3]) <= MAX_RX_COMMAND_LENGTH) {
                                continue;
                            }
                        }
                        mPackDataIndex = 0;
                        mMcuPacketStatus = PACKET_INDEX_SYNC;
                        break;
                    case PACKET_INDEX_CMD:
                    case PACKET_INDEX_PAYLOAD:
                        if (mPackDataIndex - 4 >= Utility.byteToInt(recvBuffer[3]))
                            mMcuPacketStatus = PACKET_INDEX_CRC_H;
                        break;
                    case PACKET_INDEX_CRC_H:
                        mMcuPacketStatus = PACKET_INDEX_CRC_L;
                        break;
                    case PACKET_INDEX_CRC_L:
                        byte[] ackData = new byte[2];
                        ackData[0] = recvBuffer[4];
                        int crc = Utility.MakeWord(recvBuffer[mPackDataIndex - 1], recvBuffer[mPackDataIndex - 2]);
                        int length = Utility.byteToInt(recvBuffer[3]) + 1;
                        byte[] crcBuff = new byte[length];
                        System.arraycopy(recvBuffer, 3, crcBuff, 0, length);
                        if (crc == Utility.CalculateCRC(crcBuff, length)) {
                            if (McuService.this.mRxTransactionID != recvBuffer[2] || McuService.this.mPreTransationCmd != recvBuffer[4]) {
                                McuService.this.mBValidCmd = true;
                                McuService.this.mMcuPacket.SetData(recvBuffer);
                                McuService.this.mRxTransactionID = recvBuffer[2];
                                McuService.this.mPreTransationCmd = recvBuffer[4];
                                if (McuService.this.debug) {
                                    Log.i(TAG, "a new frame ok: CRC" + String.format("[%02x %02x]", new Object[] { Byte.valueOf(Utility.LoByte((char)crc)), Byte.valueOf(Utility.HiByte((char)crc)) }));
                                    Log.v(TAG, McuService.this.mMcuPacket.toString());
                                }
                            }
                            ackData[1] = 0;
                        } else {
                            ackData[1] = 1;
                        }
                        if (Utility.byteToInt(ackData[0]) != 0) {
                            Log.i(TAG, "reply ACK");
                            McuService.this.SndACK(McuService.this.mRxTransactionID, ackData, 2);
                        }
                        mPackDataIndex = 0;
                        mMcuPacketStatus = PACKET_INDEX_SYNC;
                        break;
                }
            }
        }
        private void ClsSerial() throws IOException {
            byte[] arrayOfByte = new byte[1];
            do { } while (-1 == McuService.this.mInputStream.read(arrayOfByte, 0, 1));
        }

        public void run() {
            while (true) {
                try {
                    if (McuService.this.mInputStream != null) {
                        AnalyzeDataInBuffer();
                        if (McuService.this.mBValidCmd) {
                            McuService.this.processMCUCommand(McuService.this.mMcuPacket);
                            Thread.sleep(10L);
                            McuService.this.mBValidCmd = false;
                        } else {
                            Thread.sleep(1L);
                        }
                    }
                    if (McuService.this.m_bInSleep) {
                        if (McuService.this.m_SerialPort != null) {
                            McuService.this.m_SerialPort.close();
                            McuService.this.m_SerialPort = null;
                            McuService.this.mInputStream = null;
                            McuService.this.mOutputStream = null;
                            McuService.this.m_SerialPort = null;
                        }
                        continue;
                    }
                } catch (IOException iOException) {
                    iOException.printStackTrace();
                    continue;
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    continue;
                }

                if (McuService.this.m_SerialPort == null) {
                    McuService.this.m_SerialPort = new SerialPort();
                    McuService.this.m_SerialPort.openSerialPort(new File("/dev/ttyMT3"), 115200);
                    McuService.this.mInputStream = McuService.this.m_SerialPort.getInputStream();
                    McuService.this.mOutputStream = McuService.this.m_SerialPort.getOutputStream();
                }
            }
        }
    }

    boolean debug = true;
    boolean m_bInSleep = false;
    byte mTxTransactionID = 0x66;
    McuInfo mMcuInfo = null;
    SerialPort m_SerialPort = null;
    InputStream mInputStream = null;
    OutputStream mOutputStream = null;
    MCUReceiver mMcuReceiver = null;
    McuPacket mMcuPacket = new McuPacket();
    byte mPreTransationCmd = 0;
    byte mRxTransactionID = Byte.MIN_VALUE;

    private static McuService mMcuService;
    private static Object sMcuRequestsLock = new Object();
    private ArrayDeque<McuRequest> mMcuRequests = new ArrayDeque<McuRequest>();
    private int mResendCnt = 0;
    private Timer mSendProcessTimer;
    private ResendTimerTask mSendTask;
    private Timer mResendTimerWShake;
    private ResendTimerTaskWShake mSendTaskWShake;
    private int mPowerUpState = 0;
    private McuOpHandler mMcuOpHandler = null;
    private Context mContext = null;

    public boolean mBValidCmd = false;

    public static McuService getMcuService() {
        if (mMcuService == null)
            mMcuService = new McuService();
        return mMcuService;
    }

    boolean isMCUServiceReady() {
        return (m_SerialPort != null && !m_bInSleep);
    }
    void CheckMcuRequests() {
        if (mMcuRequests.isEmpty()) { return; }

        if (mResendCnt >= RESEND_CNT_MAX) {
            mResendCnt = 0;
            mMcuRequests.removeFirst();
            return;
        }

        SndCmd(mMcuRequests.getFirst());
        mResendCnt++;
    }

    private void SndCmd(McuRequest request) {
        byte[] buffer = new byte[MAX_TX_COMMAND_LENGTH];
        if (request.mLength > 500) { request.release(); }
        buffer[McuPacketStatus.PACKET_INDEX_SYNC] = request.mSync;
        buffer[McuPacketStatus.PACKET_INDEX_START] = request.mHeader;
        buffer[McuPacketStatus.PACKET_INDEX_TRANSACTION_ID] = request.mTransactionId;
        buffer[McuPacketStatus.PACKET_INDEX_LENGTH] = request.mLength;
        buffer[McuPacketStatus.PACKET_INDEX_CMD] = request.mCmd;
        int length = request.mLength - 1;
        System.arraycopy(request.mParam, 0, buffer, McuPacketStatus.PACKET_INDEX_PAYLOAD, length);
        buffer[length + 5] = request.mHiCRCByte;
        buffer[length + 6] = request.mLoCRCByte;
        if (debug) {
            String str = String.format("Send Data To MCU: %02x %02x %02x %02x %02x ", new Object[] { Byte.valueOf(buffer[0]), Byte.valueOf(buffer[1]), Byte.valueOf(buffer[2]), Byte.valueOf(buffer[3]), Byte.valueOf(buffer[4]) });
            for (int j = 0; j < length; j++) {
                String str1 = Integer.toHexString(buffer[j + 5] & 0xFF);
                str = str + "0x" + (str1.length() == 1 ? "0" + str1 : str1) + " ";
            }
            for (int j = 0; j < 2; j++) {
                String str1 = Integer.toHexString(buffer[length + 5 + j] & 0xFF);
                str = str + "0x" + (str1.length() == 1 ? "0" + str1 : str1) + " ";
            }
            Log.i(TAG, str);
        }
        if (mOutputStream != null)
            try {
                mOutputStream.write(buffer, 0, length + 7);
                request.release();
            } catch (IOException iOException) {
                iOException.printStackTrace();
                return;
            }
    }
    void SndCmd(McuRequest request, boolean bNeedACK) {
        if (!isMCUServiceReady()) { return; }

        if (bNeedACK) {
            synchronized (sMcuRequestsLock) {
                boolean bTxNow = mMcuRequests.isEmpty();
                mMcuRequests.addLast(request);
                if (bTxNow) {
                    SndCmd(request);
                    DelaySomeCmd(request);
                    mResendCnt = 0;
                    stopTimer();
                    startTimer();
                }
            }
        } else {
            SndCmd(request);
            DelaySomeCmd(request);
        }
    }
    public void SndCmd(int cmd) {
        mTxTransactionID = (byte)(mTxTransactionID + 1);
        SndCmd(McuRequest.obtain(mTxTransactionID, (byte)cmd, (byte)0x00, null), true);
    }
    public void SndCmd(int cmd, int param) {
        mTxTransactionID = (byte)(mTxTransactionID + 1);
        SndCmd(McuRequest.obtain(mTxTransactionID, (byte)cmd, (byte)0x01, new byte[]{ (byte)param }), true);
    }
    public void SndCmd(int cmd, int param1, int param2) {
        mTxTransactionID = (byte)(mTxTransactionID + 1);
        SndCmd(McuRequest.obtain(mTxTransactionID, (byte)cmd, (byte)0x02, new byte[]{ (byte)param1, (byte)param2 }), true);
    }
    public void SndCmd(int cmd, byte[] bBuff, int nLength) {
        mTxTransactionID = (byte)(mTxTransactionID + 1);
        SndCmd(McuRequest.obtain(mTxTransactionID, (byte)cmd, (byte)nLength, bBuff), true);
    }
    public void SndCmd1(int cmd) throws RemoteException {
        SndCmd(cmd);
    }
    public void SndCmd2(int cmd, int param) throws RemoteException {
        SndCmd(cmd, param);
    }
    public void SndCmd3(int cmd, int param1, int param2) throws RemoteException {
        SndCmd(cmd, param1, param2);
    }
    public void SndCmd4(int cmd, byte[] bBuff, int nLength) throws RemoteException {
        SndCmd(cmd, bBuff, nLength);
    }

    private void processMCUCommand(McuPacket mcuPacket) {
        int cmd = mcuPacket.cmd();
        if (cmd == CMD_MCU_ACK) {
            if (mcuPacket.packetLen() != 3) { return; }
            byte nACKStatus = mcuPacket.param(1);
            synchronized (sMcuRequestsLock) {
                if (!mMcuRequests.isEmpty()) {
                    McuRequest mcuRequest = mMcuRequests.getFirst();
                    if (mcuRequest.mCmd == mcuPacket.param(0) && mcuRequest.mTransactionId == mcuPacket.tranID()) {
                        mMcuRequests.removeFirst();
                        mResendCnt = 0;
                        CheckMcuRequests();
                    } else if (mcuRequest.mCmd == 0) {
                        mMcuRequests.removeFirst();
                        mResendCnt = 0;
                    }
                }
            }
            return;
        }

        boolean bDone = false;
        if (mPowerUpState != POWER_UP_SUCCESS) {
            bDone = true;

            switch (cmd) {
                case CMD_RESP_POWER_ON: {
                    if (mPowerUpState == WAITING_POWER_ON_RESP) {
                        mMcuInfo.getmPowerUpStatus().ParseCmd(mcuPacket);
                        EnterPowerUpNextState(false);
                    }
                    if (bDone) { return; }
                }
                case CMD_RET_MODE_FRONT: {
                    if (mPowerUpState == WAITING_RETURN_FRONT_SOURCE) {
                        mMcuInfo.getmFrontModeFromMcu().ParseCmd(mcuPacket);
                        EnterPowerUpNextState(false);
                    }
                }
                case CMD_RET_AUDIO_SETTING: {
                    if (mPowerUpState == WAITING_RETURN_AUDIO_SETTING) {
                        mMcuInfo.getmAudioInfo().ParseCmd(mcuPacket);
                        EnterPowerUpNextState(false);
                    }
                }
                case CMD_RET_GENERAL_SETTING: {
                    if (mPowerUpState == WAITING_RETURN_GEN_SETTING) {
                        mMcuInfo.getmGenralSetting().ParseCmd(mcuPacket);
                        EnterPowerUpNextState(false);
                    }
                }
                case CMD_RET_DEVICE_DETECTION_INFO: {
                    if (mPowerUpState == WAITING_RETURN_DEVICE_DETECTION_INFO) {
                        mMcuInfo.getmDetectionInfo().ParseCmd(mcuPacket);
                        EnterPowerUpNextState(false);
                    }
                    if (mPowerUpState == POWER_UP_SUCCESS) {
                        SndCmd(CMD_GET_VERSION);
                    }
                }
                case CMD_RET_CAR_TYPE: {
                    if (mPowerUpState == WAITING_RETURN_CAR_TYPE) {
                        EnterPowerUpNextState(false);
                    }
                }
            }

            bDone = false;
        }
        if (bDone) { return; }

        // sparse-switch v1, :sswitch_data_1

        return;
    }

    void startTimer() {
        if (mSendProcessTimer == null) { mSendProcessTimer = new Timer(); }
        if (mSendTask == null) { mSendTask = new ResendTimerTask(); }
        mSendProcessTimer.schedule(mSendTask, RESEND_TIME_OUT, RESEND_TIME_OUT);
    }
    void startTimerWShake() {
        if (mResendTimerWShake == null) { mResendTimerWShake = new Timer(); }
        if (mSendTaskWShake == null) { mSendTaskWShake = new ResendTimerTaskWShake(); }
        mResendTimerWShake.schedule(mSendTaskWShake, RESEND_TIME_OUT, RESEND_TIME_OUT);
    }
    void stopTimer() {
        if (mSendProcessTimer != null) {
            mSendProcessTimer.cancel();
            mSendProcessTimer = null;
        }
        if (mSendTask != null) { this.mSendTask = null; }
    }
    void stopTimerWShake() {
        if (mResendTimerWShake != null) {
            mResendTimerWShake.cancel();
            mResendTimerWShake = null;
        }
        if (mSendTask != null) { this.mSendTaskWShake = null; }
    }
    void EnterPowerUpNextState(boolean bTimeout) {
        switch (mPowerUpState) {
            case POWER_UP_IDLE:
                mPowerUpState = SEND_POWER_ON;
            case SEND_POWER_ON:
                mPowerUpState = WAITING_POWER_ON_RESP;
                SndCmd(CMD_POWER_ON);
                stopTimerWShake();
                startTimerWShake();
                break;
            case WAITING_POWER_ON_RESP:
                if (bTimeout) {
                    SndCmd(CMD_POWER_ON);
                } else {
                    mPowerUpState = GET_FRONT_SOURCE;
                }
                stopTimerWShake();
                startTimerWShake();
                break;
            case GET_FRONT_SOURCE:
                mPowerUpState = WAITING_RETURN_FRONT_SOURCE;
                SndCmd(CMD_GET_MODE_FRONT);
            case WAITING_RETURN_FRONT_SOURCE:
                if (bTimeout) {
                    SndCmd(CMD_GET_MODE_FRONT);
                } else {
                    mPowerUpState = GET_CAR_TYPE;
                }
                stopTimerWShake();
                startTimerWShake();
                break;
            case GET_CAR_TYPE:
                mPowerUpState = WAITING_RETURN_CAR_TYPE;
                SndCmd(CMD_GET_CAR_TYPE);
            case WAITING_RETURN_CAR_TYPE:
                if (bTimeout) {
                    SndCmd(CMD_GET_CAR_TYPE);
                } else {
                    mPowerUpState = GET_AUDIO_SETTING;
                }
                stopTimerWShake();
                startTimerWShake();
                break;
            case GET_AUDIO_SETTING:
                mPowerUpState = WAITING_RETURN_AUDIO_SETTING;
                SndCmd(CMD_GET_AUDIO_SETTING);
            case WAITING_RETURN_AUDIO_SETTING:
                if (bTimeout) {
                    SndCmd(CMD_GET_AUDIO_SETTING);
                } else {
                    mPowerUpState = GET_GEN_SETTING;
                }
                stopTimerWShake();
                startTimerWShake();
                break;
            case GET_GEN_SETTING:
                mPowerUpState = WAITING_RETURN_GEN_SETTING;
                SndCmd(CMD_GET_GENERAL_SETTING);
            case WAITING_RETURN_GEN_SETTING:
                if (bTimeout) {
                    SndCmd(CMD_GET_GENERAL_SETTING);
                } else {
                    mPowerUpState = GET_DEVICE_DETECTION_INFO;
                }
                stopTimerWShake();
                startTimerWShake();
                break;
            case GET_DEVICE_DETECTION_INFO:
                SndCmd(CMD_GET_DEVICE_DETECTION_INFO);
                mPowerUpState = WAITING_RETURN_DEVICE_DETECTION_INFO;
            case WAITING_RETURN_DEVICE_DETECTION_INFO:
                if (bTimeout) {
                    SndCmd(CMD_GET_DEVICE_DETECTION_INFO);
                } else {
                    mPowerUpState = POWER_UP_SUCCESS;
                    mMcuOpHandler.sendEmptyMessage(1);
                    return;
                }
                stopTimerWShake();
                startTimerWShake();
        }
    }
    boolean initSystemConfig() {
        if (this.mMcuInfo.getmPowerUpStatus().getmMcuPowerUpStatus() == 1) {
            SettingService.getInstance().initSystemConfig(true);
        } else {
            SettingService.getInstance().initSystemConfig(false);
        }
        mMcuInfo.getmPowerUpStatus().setmMcuPowerUpStatus((byte)0x00);
        return true;
    }


    private void DelaySomeCmd(McuRequest request) {
        if (request.mCmd == CMD_SND_MODE_FRONT || request.mCmd == CMD_SND_MODE_REAR)
            try {
                Thread.sleep(20L);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
    }
    private boolean WaitMySystemServiceStart() {
        int i = 0;
        for (i = 0; i < MySystemService.length; i++) {
            for (int j = 0; j < 50; j++) {
                if (ServiceManager.getService(MySystemService[i]) == null) {
                    Log.e(TAG, "WaitMySystemServiceStart ---null>" + MySystemService[i]);
                    try {
                        Thread.sleep(100L);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } else {
                    Log.e(TAG, "WaitMySystemServiceStart --ok->" + MySystemService[i]);
                    break;
                }
            }
        }
        return true;
    }
    private void systemReady() {}
    private void startuserservice(String action, String packageName) {
        if (!Utility.isPkgInstalled(packageName)) {
            Log.i("McuService", packageName + "is not installed");
            return;
        }
        if (action != null && action.equals("com.dgl.autocan.CanService") && !SettingService.getInstance().getCanBusStatus()) {
            Log.i("McuService", "---------->not have Canbus");
            return;
        }
        try {
            mContext.getPackageManager().getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            Intent intent = new Intent();
            intent.setAction(action);
            intent.setPackage(packageName);
            mContext.startService(intent);
            Log.i(TAG, "out startService->" + action);
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
            Log.e(TAG, "can not find ->" + packageName);
            nameNotFoundException.printStackTrace();
        }
    }
    private void startUserServices() {
        WaitMySystemServiceStart();
        for (int i = 0; i < userServcies.length; i++) {
            if (!Utility.isServiceRunning(userServciesClass[i]))
                startuserservice(userServcies[i], userServciesPackageName[i]);
        }
    }
    private int getCurAppMode() {
        return Utility.mapMcuModeToAppMode(McuInfo.getInstance().getmFrontModeFromMcu().getmMode());
    }
    private void ResumeMode() {
        Utility.turnMode(getCurAppMode());
    }

    public McuInfo getMcuInfo() {
        return this.mMcuInfo;
    }
    public boolean Resume() {
        McuMsgQueueManager.getInstance().pushNode(30, true);
        return true;
    }
    public void SndACK(int transactionId, byte[] bBuff, int nLength) {
        SndCmd(McuRequest.obtain((byte)transactionId, (byte)CMD_HOST_ACK, (byte)nLength, bBuff));
    }
}
