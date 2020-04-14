package com.auto.radioservice;

import android.os.RemoteException;
import android.util.Log;
import com.auto.constant.McuConstant;
import com.dgl.auto.constant.CallbackConstant;
import java.util.ArrayList;
import java.util.Iterator;
import com.auto.mcuservice.McuService;
import com.auto.mcuservice.Utility;

public class RadioService extends IRadioPlayer.Stub implements McuConstant.McuCmd, McuConstant.HostCmd, McuConstant.TsEvents, CallbackConstant.RadioCallbackConstant {
    public static final String TAG = "RadioSevice";
    public static final String TAG_RDS = "RDS";

    public static interface TunerCmdToHost {
        public static final int TCTH_SET_BAND =             0;
        public static final int TCTH_SEEK_UP =              1;
        public static final int TCTH_SEEK_DOWN =            2;
        public static final int TCTH_TURN_UP =              3;
        public static final int TCTH_TURN_DOWN =            4;
        public static final int TCTH_PRESET_SAVE =          5;
        public static final int TCTH_PRESET_LOAD =          6;
        public static final int TCTH_GET_TUNER_INFO =       7;
        public static final int TCTH_GET_PRESET_LIST =      8;
        public static final int TCTH_AS =                   9;
        public static final int TCTH_PS =                   10;
        public static final int TCTH_SCAN =                 11;
        public static final int TCTH_DX_LOCAL =             12;
        public static final int TCTH_RDS_CMD =              13;
        public static final int TCTH_GET_RDS_INFO =         14;
        public static final int TCTH_SET_FREQ =             15;
        public static final int TCTH_SET_RETURN =           16;
        public static final int TCTH_SET_PTY =              17;
        public static final int TCTH_SET_REGMode =          18;
        public static final int TCTH_SET_AFMode =           19;
        public static final int TCTH_SET_TAMode =           20;
        public static final int TCTH_SET_EONMode =          21;
        public static final int TCTH_MAX =                  22;
    }

    private static RadioService sInstance = null;
    private final ArrayList<IRadioCallback> mCallBacks = new ArrayList<IRadioCallback>();

    McuService mMcuService = null;

    public RadioService() {
        sInstance = this;
        mMcuService = McuService.getMcuService();
    }

    public boolean init() {
        return true;
    }
    public static RadioService getInstance() {
        if (sInstance == null) { sInstance = new RadioService(); }
        return sInstance;
    }

    private void callManager(int paramInt, String paramString) {
        synchronized (mCallBacks) {
            Iterator<IRadioCallback> iterator = mCallBacks.iterator();
            while (iterator.hasNext()) {
                IRadioCallback radioCallback = iterator.next();
                if (radioCallback != null) {
                    try {
                        radioCallback.onEvent(paramInt, paramString);
                    } catch (RemoteException remoteException) {
                        Log.i(TAG, "callManager localIRadioCallback lost");
                        iterator.remove();
                    } catch (Exception exception) {
                        Log.e(TAG, "callManager erre --->" + exception);
                    }
                    continue;
                }
                Log.e(TAG, "callManager localIRadioCallback null");
            }
        }
    }
    public void setcallback(IRadioCallback radioCallback) throws RemoteException {
        synchronized (mCallBacks) {
            if (!mCallBacks.contains(radioCallback)) {
                mCallBacks.add(radioCallback);
            }
        }
    }
    public void removecallback(IRadioCallback radioCallback) throws RemoteException {
        synchronized (mCallBacks) {
            mCallBacks.remove(radioCallback);
        }
    }

    public void onMessage(int paramInt, String paramString) {
        Log.i(TAG, "onMessage[" + paramInt + "]---->" + paramString);
        switch (paramInt) {
            case UPDATE_TUNER_INFO:
                callManager(paramInt, paramString);
                break;
            case UPDATE_PRESET_LIST_INFO:
                callManager(paramInt, paramString);
                break;
            case UPDATE_TUNER_RANGE:
                callManager(paramInt, paramString);
                break;
            case UPDATE_TUNER_RDSINFO:
                callManager(paramInt, paramString);
                break;
        }
    }

    void OnEventTunerCmd(int cmd) {
        OnEventTunerCmd(cmd, (char)0x0000);
    }
    void OnEventTunerCmd(int cmd, char param) {
        switch (cmd) {
            case TunerCmdToHost.TCTH_SET_BAND:
                mMcuService.SndCmd(CMD_SND_TS_EVENTS, TS_EVENT_INDEX_BAND);
                break;
            case TunerCmdToHost.TCTH_SEEK_UP:
                mMcuService.SndCmd(CMD_SND_TS_EVENTS, TS_EVENT_INDEX_SEEK_UP);
                break;
            case TunerCmdToHost.TCTH_SEEK_DOWN:
                mMcuService.SndCmd(CMD_SND_TS_EVENTS, TS_EVENT_INDEX_SEEK_DOWN);
                break;
            case TunerCmdToHost.TCTH_TURN_UP:
                mMcuService.SndCmd(CMD_SND_TS_EVENTS, TS_EVENT_INDEX_MANUAL_UP);
                break;
            case TunerCmdToHost.TCTH_TURN_DOWN:
                mMcuService.SndCmd(CMD_SND_TS_EVENTS, TS_EVENT_INDEX_MANUAL_DOWN);
                break;
            case TunerCmdToHost.TCTH_PRESET_SAVE:
                mMcuService.SndCmd(CMD_SAVE_PRESET_FREQ, param);
                break;
            case TunerCmdToHost.TCTH_PRESET_LOAD:
                mMcuService.SndCmd(CMD_LOAD_PRESET_FREQ, param);
                break;
            case TunerCmdToHost.TCTH_GET_TUNER_INFO:
                mMcuService.SndCmd(CMD_GET_TUNER_INFO);
                break;
            case TunerCmdToHost.TCTH_GET_PRESET_LIST:
                mMcuService.SndCmd(CMD_GET_TUNER_PRESET_LIST_INFO);
                break;
            case TunerCmdToHost.TCTH_AS:
                mMcuService.SndCmd(CMD_SND_TS_EVENTS, TS_EVENT_INDEX_AS);
                break;
            case TunerCmdToHost.TCTH_PS:
                mMcuService.SndCmd(CMD_SND_TS_EVENTS, TS_EVENT_INDEX_PS);
                break;
            case TunerCmdToHost.TCTH_SCAN:
                mMcuService.SndCmd(CMD_SND_TS_EVENTS, TS_EVENT_INDEX_SCAN);
                break;
            case TunerCmdToHost.TCTH_DX_LOCAL:
                mMcuService.SndCmd(CMD_SND_TS_EVENTS, TS_EVENT_INDEX_DX_LOC);
                break;
            case TunerCmdToHost.TCTH_RDS_CMD:
                mMcuService.SndCmd(CMD_SND_RDS_SETTING, new byte[]{ Utility.HiByte(param), Utility.LoByte(param) }, 2);
                break;
            case TunerCmdToHost.TCTH_GET_RDS_INFO:
                mMcuService.SndCmd(CMD_SND_GET_RDS_SETTING);
                break;
            case TunerCmdToHost.TCTH_SET_FREQ:
                mMcuService.SndCmd(CMD_SND_TUNER_FREQ_SET, new byte[]{Utility.HiByte(param), Utility.LoByte(param)}, 2);
                break;
            case TunerCmdToHost.TCTH_SET_RETURN:
                mMcuService.SndCmd(CMD_SND_TS_EVENTS, TS_EVENT_INDEX_RETURN);
                break;
            case TunerCmdToHost.TCTH_SET_PTY:
                mMcuService.SndCmd(CMD_SND_RDS_SETTING, new byte[]{ 4, (byte)param }, 2);
                break;
            case TunerCmdToHost.TCTH_SET_REGMode:
                mMcuService.SndCmd(CMD_SND_RDS_SETTING, new byte[]{ 2, (byte)param }, 2);
                break;
            case TunerCmdToHost.TCTH_SET_AFMode:
                mMcuService.SndCmd(CMD_SND_RDS_SETTING, new byte[]{ 0, (byte)param }, 2);
                break;
            case TunerCmdToHost.TCTH_SET_TAMode:
                mMcuService.SndCmd(CMD_SND_RDS_SETTING, new byte[]{ 1, (byte)param }, 2);
                break;
            case TunerCmdToHost.TCTH_SET_EONMode:
                mMcuService.SndCmd(CMD_SND_RDS_SETTING, new byte[]{ 3, (byte)param }, 2);
                break;
        }
    }
    public void AS() throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_AS);
    }
    public void DX_LOC() throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_DX_LOCAL);
    }
    public void PS() throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_PS);
    }
    public void band() throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_SET_BAND);
    }
    public void loadFreq(int freq) throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_PRESET_LOAD, (char)freq);
    }
    public void manulDown() throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_TURN_DOWN);
    }
    public void manulUp() throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_TURN_UP);
    }
    public void queryRadioFreqsList() throws RemoteException {
        mMcuService.SndCmd(CMD_GET_TUNER_PRESET_LIST_INFO);
    }
    public void queryRadioInfo() throws RemoteException {
        mMcuService.SndCmd(CMD_GET_TUNER_INFO);
    }
    public void queryRadioRange() throws RemoteException {
        mMcuService.SndCmd(CMD_GET_TUNER_RANGE);
    }
    public void queryRdsInfo() throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_GET_RDS_INFO);
    }
    public void saveFreq(int freq) throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_PRESET_SAVE, (char)freq);
    }
    public void scan() throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_SCAN);
    }
    public void seekDown() throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_SEEK_DOWN);
    }
    public void seekUp() throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_SEEK_UP);
    }
    public void setFreq(char freq) throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_SET_FREQ, freq);
    }
    public void setPtyType(byte type) throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_SET_PTY, (char)type);
        Log.i(TAG_RDS, "setPtyType" + type);
    }
    public void turnAFMode(boolean turnOn) throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_SET_AFMode, (char)((turnOn) ? 0x0001 : 0x0000));
        Log.i(TAG_RDS, "turnAFMode" + turnOn);
    }
    public void turnEONMode(boolean turnOn) throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_SET_EONMode, (char)((turnOn) ? 0x0001 : 0x0000));
        Log.i(TAG_RDS, "turnEONMode" + turnOn);
    }
    public void turnREGMode(boolean turnOn) throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_SET_REGMode, (char)((turnOn) ? 0x0001 : 0x0000));
        Log.i(TAG_RDS, "turnREGMode" + turnOn);
    }
    public void turnTAMode(boolean turnOn) throws RemoteException {
        OnEventTunerCmd(TunerCmdToHost.TCTH_SET_TAMode, (char)((turnOn) ? 0x0001 : 0x0000));
        Log.i(TAG_RDS, "turnTAMode" + turnOn);
    }

    public int getAMStep() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmRadioRangeInfo().getmAMStep();
    }
    public boolean getASStatus() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmCurrentTunerInfo().isMbInAS();
    }
    public int getBand() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmCurrentTunerInfo().getmBand();
    }
    public int getCurrFreq() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmCurrentTunerInfo().getmCurrFreq();
    }
    public int getFMStep() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmRadioRangeInfo().getmFMStep();
    }
    public char[] getFreqList() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmRadioListInfo().getmPresets();
    }
    public boolean getLocalDx() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmCurrentTunerInfo().isMbInLocalDx();
    }
    public int getMaxAMFreq() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmRadioRangeInfo().getmMaxAMFreq();
    }
    public int getMaxFMFreq() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmRadioRangeInfo().getmMaxFMFreq();
    }
    public int getMinAMFreq() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmRadioRangeInfo().getmMinAMFreq();
    }
    public int getMinFMFreq() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmRadioRangeInfo().getmMinFMFreq();
    }
    public boolean getPSStatus() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmCurrentTunerInfo().isMbInPS();
    }
    public int getPresetIndex() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmCurrentTunerInfo().getmPresetIndex();
    }
    public int getRDSArm2McuPtyType() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmRadioRDS().getRDSPty().getnArm2McuPtyType();
    }
    public int getRDSCT_Hour() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmRadioRDS().getRDSCT().getHour();
    }
    public int getRDSCT_Minute() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmRadioRDS().getRDSCT().getMinute();
    }
    public int getRDSPtyType() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmRadioRDS().getRDSPty().getnPtyType();
    }
    public char[] getRDSRDSPS() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmRadioRDS().getRDSPS().getaPsName();
    }
    public char[] getRDSRDSRT() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmRadioRDS().getRDSRT().getaRtName();
    }
    public int getRdsInfo() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmRadioRDS().getRDSInfo().getnInfo();
    }
    public int getRdsSeting() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmRadioRDS().getRDSSetting().getnSetting();
    }
    public boolean getScanSatus() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmCurrentTunerInfo().isMbInScan();
    }
    public boolean getSeekStatus() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmCurrentTunerInfo().isMbInSeek();
    }
    public boolean getStMonoStatus() throws RemoteException {
        return mMcuService.getMcuInfo().getmRadioInfo().getmCurrentTunerInfo().isMbInStMono();
    }
}
