package com.auto.mcuservice;

import android.os.IBinder;
import android.util.Log;

import java.util.Locale;

public class McuInfo {
    public static final int ATV_PRESET_INDEX_MAX = 20;
    public static final String MCU_SERVICE = "McuService";
    public static final int MCU_VERSION_LENGTH = 40;
    public static final String TAG = "McuService";
    public static final String TAG_RDS = "RDS";
    public static final int TUNER_PRESET_INDEX_MAX = 18;
    public static final int TUNER_PS_NAME_LENGTH = 8;
    public static final int TUNER_RT_NAME_LENGTH = 64;
    public static final int VOL_OFFSET_INDEX_MAX = 6;

    public class ATVInfo {
        McuInfo.ATVPresetList mATVPresetList;
        McuInfo.CurATVInfo mCurATVInfo;

        public McuInfo.ATVPresetList getmATVPresetList() {
            return mATVPresetList;
        }
        public McuInfo.CurATVInfo getmCurATVInfo() {
            return mCurATVInfo;
        }
    }

    public class ATVPresetList {
        byte[] Preset = new byte[20];
        byte nPresetNum;

        public void ParseCmd(McuService.McuPacket mcuPacket) {}
    }

    public class AudioInfo {
        private static final int paramCount = 16;

        byte mBalance;
        byte mBass;
        byte mBassFreq;
        byte mBassQ;
        byte mEQ;
        byte mFade;
        byte mLoud;
        byte mMiddle;
        byte mMiddleFreq;
        byte mMiddleQ;
        byte mSubFilterFreq;
        byte mSubPhase;
        byte mSubwoofer;
        byte mTreble;
        byte mTrebleFreq;
        byte mTrebleQ;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            if (mcuPacket.packetLen() != 16) {};
            
            mEQ = mcuPacket.param(0);
            mBalance = mcuPacket.param(1);
            mFade = mcuPacket.param(2);
            mLoud = mcuPacket.param(3);
            mSubwoofer = mcuPacket.param(4);
            mSubFilterFreq = mcuPacket.param(5);
            mSubPhase = mcuPacket.param(6);
            mBass = mcuPacket.param(7);
            mMiddle = mcuPacket.param(8);
            mTreble = mcuPacket.param(9);
            mBassFreq = mcuPacket.param(10);
            mMiddleFreq = mcuPacket.param(11);
            mTrebleFreq = mcuPacket.param(12);
            mBassQ = mcuPacket.param(13);
            mMiddleQ = mcuPacket.param(14);
            mTrebleQ = mcuPacket.param(15);
        }

        public byte getmBalance() {
            return mBalance;
        }
        public byte getmBass() {
            return mBass;
        }
        public byte getmBassFreq() {
            return mBassFreq;
        }
        public byte getmBassQ() {
            return mBassQ;
        }
        public byte getmEQ() {
            return mEQ;
        }
        public byte getmFade() {
            return mFade;
        }
        public byte getmLoud() {
            return mLoud;
        }
        public byte getmMiddle() {
            return mMiddle;
        }
        public byte getmMiddleFreq() {
            return mMiddleFreq;
        }
        public byte getmMiddleQ() {
            return mMiddleQ;
        }
        public byte getmSubFilterFreq() {
            return mSubFilterFreq;
        }
        public byte getmSubPhase() {
            return mSubPhase;
        }
        public byte getmSubwoofer() {
            return mSubwoofer;
        }
        public byte getmTreble() {
            return mTreble;
        }
        public byte getmTrebleFreq() {
            return mTrebleFreq;
        }
        public byte getmTrebleQ() {
            return mTrebleQ;
        }
    }

    public class CurATVInfo {
        byte ATVStatus;
        int curFreq;
        byte currCH;
        byte currPreset;

        public void ParseCmd(McuService.McuPacket mcuPacket) {}
    }

    public class CanBusInfo {
        public static final int CAN_DATA_SIZE = 512;

        byte[] mCanData = null;
        int mDataLen = 0;

        CanBusInfo() {
            mCanData = new byte[512];
        }

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            mDataLen = mcuPacket.packetLen() - 1;
            for (int i = 0; i < mDataLen; i++)
                this.mCanData[i] = mcuPacket.param(i);
        }

        public byte[] getmCanData() {
            return mCanData;
        }
        public int getmDataLen() {
            return mDataLen;
        }
    }

    public class CurrentBKStatus {
        int mBKStatus;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            mBKStatus = mcuPacket.param(0);
        }

        public int getmBKStatus() {
            return mBKStatus;
        }
        public void setmBKStatus(int status) {
            mBKStatus = status;
        }
    }

    public class CurrentFrontModeFromMcu {
        int mMode;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            mMode = mcuPacket.param(0);
        }

        public int getmMode() {
            return mMode;
        }
        public void setmMode(int mode) {
            mMode = mode;
        }
    }

    public class CurrentRearModeFromMcu {
        int mMode;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            mMode = mcuPacket.param(0);
        }

        public int getmMode() {
            return mMode;
        }
        public void setmMode(int mode) {
            mMode = mode;
        }
    }

    public class CurrentTunerInfo {
        byte mBand;
        char mCurrFreq;
        byte mPresetIndex;
        byte mRadioStatus;
        boolean mbInAS;
        boolean mbInLocalDx;
        boolean mbInPS;
        boolean mbInScan;
        boolean mbInSeek;
        boolean mbInStMono;
        boolean mbReserved1;
        boolean mbReserved2;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            mCurrFreq = Utility.MakeWord(mcuPacket.param(1), mcuPacket.param(0));
            mBand = mcuPacket.param(2);
            mPresetIndex = mcuPacket.param(3);
            mRadioStatus = mcuPacket.param(4);
            mbInAS = (Utility.getData(mRadioStatus, 0, 0) == 1);
            mbInPS = (Utility.getData(mRadioStatus, 1, 1) == 1);
            mbInScan = (Utility.getData(mRadioStatus, 2, 2) == 1);
            mbInSeek = (Utility.getData(mRadioStatus, 3, 3) == 1);
            mbInStMono = (Utility.getData(mRadioStatus, 4, 4) == 1);
            mbInLocalDx = (Utility.getData(mRadioStatus, 5, 5) == 1);
            mbReserved1 = (Utility.getData(mRadioStatus, 6, 6) == 1);
            mbReserved2 = (Utility.getData(mRadioStatus, 7, 7) == 1);
        }

        public byte getmBand() {
            return mBand;
        }
        public char getmCurrFreq() {
            return mCurrFreq;
        }
        public byte getmPresetIndex() {
            return mPresetIndex;
        }
        public boolean isMbInAS() {
            return mbInAS;
        }
        public boolean isMbInLocalDx() {
            return mbInLocalDx;
        }
        public boolean isMbInPS() {
            return mbInPS;
        }
        public boolean isMbInScan() {
            return mbInScan;
        }
        public boolean isMbInSeek() {
            return mbInSeek;
        }
        public boolean isMbInStMono() {
            return mbInStMono;
        }
        public boolean isMbReserved1() {
            return mbReserved1;
        }
        public boolean isMbReserved2() {
            return mbReserved2;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("CurrentTunerInfo: ");
            stringBuffer.append(String.format(Locale.ENGLISH, "Freq %d %d %b %b %b %b %b %b %b %b",
                    new Object[] {
                            Integer.valueOf(mCurrFreq),
                            Integer.valueOf(mBand),
                            Byte.valueOf(mPresetIndex),
                            Boolean.valueOf(mbInAS),
                            Boolean.valueOf(mbInPS),
                            Boolean.valueOf(mbInScan),
                            Boolean.valueOf(mbInSeek),
                            Boolean.valueOf(mbInStMono),
                            Boolean.valueOf(mbInLocalDx),
                            Boolean.valueOf(mbReserved1),
                            Boolean.valueOf(mbReserved1)
                    }));
            stringBuffer.append("\n");
            return stringBuffer.toString();
        }
    }

    public class CurrentVolStatus {
        public boolean mMute;
        public int mVol;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            mMute = (mcuPacket.param(0) == 1);
            mVol = mcuPacket.param(1);
        }

        public int getmVol() {
            return mVol;
        }
        public boolean ismMute() {
            return mMute;
        }
    }

    public class DeviceDetectionInfo {
        boolean mbAccState;
        boolean mbAgingMode;
        boolean mbAvinStatus;
        boolean mbBrakeState;
        boolean mbCarBTState;
        boolean mbCarUSBStatus;
        boolean mbDTVState;
        boolean mbDiscManualInsert;
        boolean mbDiscState;
        boolean mbIIumeState;
        boolean mbReserve13;
        boolean mbReserve14;
        boolean mbReserve15;
        boolean mbReserve16;
        boolean mbReserve17;
        boolean mbReserve18;
        boolean mbReserve19;
        boolean mbReserve20;
        boolean mbReserve21;
        boolean mbReserve22;
        boolean mbReserve23;
        boolean mbReserve24;
        boolean mbReserve25;
        boolean mbReserve26;
        boolean mbReserve27;
        boolean mbReserve28;
        boolean mbReserve29;
        boolean mbReserve3;
        boolean mbReserve30;
        boolean mbReserve31;
        boolean mbReverseState;
        boolean mbtestMode;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            mbReverseState = (Utility.getData(mcuPacket.param(0), 0, 0) == 1);
            mbBrakeState = (Utility.getData(mcuPacket.param(0), 1, 1) == 1);
            mbIIumeState = (Utility.getData(mcuPacket.param(0), 2, 2) == 1);
            mbReserve3 = (Utility.getData(mcuPacket.param(0), 3, 3) == 1);
            mbDTVState = (Utility.getData(mcuPacket.param(0), 4, 4) == 1);
            mbtestMode = (Utility.getData(mcuPacket.param(0), 5, 5) == 1);
            mbAccState = (Utility.getData(mcuPacket.param(0), 6, 6) == 1);
            mbCarBTState = (Utility.getData(mcuPacket.param(0), 7, 7) == 1);
            mbDiscState = (Utility.getData(mcuPacket.param(1), 0, 0) == 1);
            mbDiscManualInsert = (Utility.getData(mcuPacket.param(1), 1, 1) == 1);
            mbAgingMode = (Utility.getData(mcuPacket.param(1), 2, 2) == 1);
            mbCarUSBStatus = (Utility.getData(mcuPacket.param(1), 3, 3) == 1);
            mbAvinStatus = (Utility.getData(mcuPacket.param(1), 4, 4) == 1);
            mbReserve13 = (Utility.getData(mcuPacket.param(1), 5, 5) == 1);
            mbReserve14 = (Utility.getData(mcuPacket.param(1), 6, 6) == 1);
            mbReserve15 = (Utility.getData(mcuPacket.param(1), 7, 7) == 1);
            mbReserve16 = (Utility.getData(mcuPacket.param(2), 0, 0) == 1);
            mbReserve17 = (Utility.getData(mcuPacket.param(2), 1, 1) == 1);
            mbReserve18 = (Utility.getData(mcuPacket.param(2), 2, 2) == 1);
            mbReserve19 = (Utility.getData(mcuPacket.param(2), 3, 3) == 1);
            mbReserve20 = (Utility.getData(mcuPacket.param(2), 4, 4) == 1);
            mbReserve21 = (Utility.getData(mcuPacket.param(2), 5, 5) == 1);
            mbReserve22 = (Utility.getData(mcuPacket.param(2), 6, 6) == 1);
            mbReserve23 = (Utility.getData(mcuPacket.param(2), 7, 7) == 1);
            mbReserve24 = (Utility.getData(mcuPacket.param(3), 0, 0) == 1);
            mbReserve25 = (Utility.getData(mcuPacket.param(3), 1, 1) == 1);
            mbReserve26 = (Utility.getData(mcuPacket.param(3), 2, 2) == 1);
            mbReserve27 = (Utility.getData(mcuPacket.param(3), 3, 3) == 1);
            mbReserve28 = (Utility.getData(mcuPacket.param(3), 4, 4) == 1);
            mbReserve29 = (Utility.getData(mcuPacket.param(3), 5, 5) == 1);
            mbReserve30 = (Utility.getData(mcuPacket.param(3), 6, 6) == 1);
            mbReserve31 = (Utility.getData(mcuPacket.param(3), 7, 7) == 1);
        }

        public void copyValue(DeviceDetectionInfo deviceDetectionInfo) {
            mbReverseState = deviceDetectionInfo.mbReverseState;
            mbBrakeState = deviceDetectionInfo.mbBrakeState;
            mbIIumeState = deviceDetectionInfo.mbIIumeState;
            mbReserve3 = deviceDetectionInfo.mbReserve3;
            mbDTVState = deviceDetectionInfo.mbtestMode;
            mbtestMode = deviceDetectionInfo.mbtestMode;
            mbAccState = deviceDetectionInfo.mbAccState;
            mbCarBTState = deviceDetectionInfo.mbCarBTState;
            mbDiscState = deviceDetectionInfo.mbDiscState;
            mbDiscManualInsert = deviceDetectionInfo.mbDiscManualInsert;
            mbAgingMode = deviceDetectionInfo.mbAgingMode;
            mbCarUSBStatus = deviceDetectionInfo.mbCarUSBStatus;
            mbAvinStatus = deviceDetectionInfo.mbAvinStatus;
            mbReserve13 = deviceDetectionInfo.mbReserve13;
            mbReserve14 = deviceDetectionInfo.mbReserve14;
            mbReserve15 = deviceDetectionInfo.mbReserve15;
            mbReserve16 = deviceDetectionInfo.mbReserve16;
            mbReserve17 = deviceDetectionInfo.mbReserve17;
            mbReserve18 = deviceDetectionInfo.mbReserve18;
            mbReserve19 = deviceDetectionInfo.mbReserve19;
            mbReserve20 = deviceDetectionInfo.mbReserve20;
            mbReserve21 = deviceDetectionInfo.mbReserve21;
            mbReserve22 = deviceDetectionInfo.mbReserve22;
            mbReserve23 = deviceDetectionInfo.mbReserve23;
            mbReserve24 = deviceDetectionInfo.mbReserve24;
            mbReserve25 = deviceDetectionInfo.mbReserve25;
            mbReserve26 = deviceDetectionInfo.mbReserve26;
            mbReserve27 = deviceDetectionInfo.mbReserve27;
            mbReserve28 = deviceDetectionInfo.mbReserve28;
            mbReserve29 = deviceDetectionInfo.mbReserve29;
            mbReserve30 = deviceDetectionInfo.mbReserve30;
            mbReserve31 = deviceDetectionInfo.mbReserve31;
        }

        public boolean isMbAccState() {
            return mbAccState;
        }
        public boolean isMbAgingMode() {
            return mbAgingMode;
        }
        public boolean isMbAvinStatus() {
            return mbAvinStatus;
        }
        public boolean isMbBrakeState() {
            return mbBrakeState;
        }
        public boolean isMbCarBTState() {
            return mbCarBTState;
        }
        public boolean isMbCarUSBStatus() {
            return mbCarUSBStatus;
        }
        public boolean isMbDTVState() {
            return mbDTVState;
        }
        public boolean isMbDiscManualInsert() {
            return mbDiscManualInsert;
        }
        public boolean isMbDiscState() {
            return mbDiscState;
        }
        public boolean isMbIIumeState() {
            return mbIIumeState;
        }
        public boolean isMbReverseState() {
            return mbReverseState;
        }
        public boolean isMbtestMode() {
            return mbtestMode;
        }
    }

    public class ExDvdMode {
        byte n8ExMode;
        byte n8ExType;

        public void ParseCmd(McuService.McuPacket param1McuPacket) {}
    }

    public class GenralSetting {
        private static final int paramCount = 12;

        byte NaviMode;
        byte auxLine;
        byte bootTime;
        byte bright;
        byte contrast;
        byte flag1;
        byte flag2;
        byte flag3;
        byte hour;
        byte hue;
        byte illumeDetection;
        byte min;
        byte mirror;
        byte radioField;
        byte saturation;
        byte second;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            if (mcuPacket.packetLen() != 12) {};
            bright = mcuPacket.param(0);
            contrast = mcuPacket.param(1);
            hour = mcuPacket.param(2);
            min = mcuPacket.param(3);
            second = mcuPacket.param(4);
            radioField = mcuPacket.param(5);
            flag1 = mcuPacket.param(6);
            flag2 = mcuPacket.param(7);
            flag3 = mcuPacket.param(8);
            hue = mcuPacket.param(9);
            saturation = mcuPacket.param(10);
            mirror = mcuPacket.param(11);
            bootTime = mcuPacket.param(12);
            auxLine = Utility.getData(flag1, 7, 7);
            illumeDetection = Utility.getData(flag2, 0, 0);
            NaviMode = 1;
        }

        public byte getAuxLine() {
            return auxLine;
        }
        public byte getBootTime() {
            return bootTime;
        }
        public byte getBright() {
            return bright;
        }
        public byte getContrast() {
            return contrast;
        }
        public byte getFlag1() {
            return flag1;
        }
        public byte getFlag2() {
            return flag2;
        }
        public byte getFlag3() {
            return flag3;
        }
        public byte getHour() {
            return hour;
        }
        public byte getHue() {
            return hue;
        }
        public byte getIllumeDetection() {
            return illumeDetection;
        }
        public byte getMin() {
            return min;
        }
        public byte getMirror() {
            return mirror;
        }
        public byte getNaviMode() {
            return NaviMode;
        }
        public byte getRadioField() {
            return radioField;
        }
        public byte getSaturation() {
            return saturation;
        }
        public byte getSecond() {
            return second;
        }
    }

    public class IlluminPWM {
        byte n8DutyCycle;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            this.n8DutyCycle = mcuPacket.param(0);
        }

        public int getDutyCycle() {
            return n8DutyCycle;
        }
    }

    public class KeyCode {
        byte mKeyCode;
        byte mKeySrc;
        byte mKeyStatus;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            mKeyCode = mcuPacket.param(0);
            mKeyStatus = mcuPacket.param(1);
            mKeySrc = mcuPacket.param(2);
        }

        public byte getKeyCode() {
            return mKeyCode;
        }
        public byte getKeySrc() {
            return mKeySrc;
        }
        public byte getKeyStatus() {
            return mKeyStatus;
        }
    }

    public class McuVersion {
        int mDataLen = 0;
        String mStrMcuVersion;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            int j = mcuPacket.packetLen() - 1;
            byte[] arrayOfByte = new byte[j];
            for (int i = 0; i < j; i++)
                arrayOfByte[i] = mcuPacket.param(i);
            mStrMcuVersion = new String(arrayOfByte);
            if (!mStrMcuVersion.contains("dgl") && !mStrMcuVersion.contains("DGL")) {
                McuInfo.this.shutdown();
            }
        }

        public String getmStrMcuVersion() {
            return mStrMcuVersion;
        }
    }

    public class PowerStatus {
        byte nPowerStatus;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            nPowerStatus = mcuPacket.param(0);
        }
    }

    public class PowerUpStatus {
        byte mMcuPowerUpStatus;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            mMcuPowerUpStatus = mcuPacket.param(0);
        }

        public byte getmMcuPowerUpStatus() {
            return mMcuPowerUpStatus;
        }
        public void setmMcuPowerUpStatus(byte status) {
            mMcuPowerUpStatus = status;
        }
    }

    public class RDSCT {
        byte hour;
        byte minute;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            hour = mcuPacket.param(0);
            minute = mcuPacket.param(1);
            Log.i("RDS", "RDS hour=" + hour);
            Log.i("RDS", "RDS minute=" + minute);
        }

        public byte getHour() {
            return hour;
        }
        public byte getMinute() {
            return minute;
        }
    }

    public class RDSInfo {
        byte nInfo;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            nInfo = mcuPacket.param(0);
            Log.i("RDS", "RDS nInfo=" + nInfo);
        }

        public byte getnInfo() {
            return nInfo;
        }
    }

    public class RDSPS {
        char[] aPsName = new char[8];

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            Log.i("RDS", "-------------------RDSPS--------------");
            for (int i = 0; i < 8; i++) {
                aPsName[i] = (char)mcuPacket.param(i);
                Log.i("RDS", "nPtyType[" + i + "]=" + this.aPsName[i]);
            }
            Log.i("RDS", "-------------------RDSPS--------------");
        }

        public char[] getaPsName() {
            return aPsName;
        }
    }

    public class RDSPty {
        byte nArm2McuPtyType;
        byte nPtyType;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            nPtyType = mcuPacket.param(1);
            nArm2McuPtyType = mcuPacket.param(0);
            Log.i("RDS", "RDS nPtyType=" + nPtyType);
        }

        public byte getnArm2McuPtyType() {
            return nArm2McuPtyType;
        }
        public byte getnPtyType() {
            return nPtyType;
        }
    }

    public class RDSRT {
        char[] aRtName = new char[64];

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            Log.i("RDS", "-------------------RDSRT--------------");
            for (int i = 0; i < 64; i++) {
                aRtName[i] = (char)mcuPacket.param(i);
                Log.i("RDS", "RTName[" + i + "]=" + this.aRtName[i]);
            }
            Log.i("RDS", "-------------------RDSRT--------------");
        }

        public char[] getaRtName() {
            return aRtName;
        }
    }

    public class RDSSetting {
        byte nSetting;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            nSetting = mcuPacket.param(0);
            Log.i("RDS", "RDS nSetting=" + nSetting);
        }

        public byte getnSetting() {
            return nSetting;
        }
    }

    public class RadioInfo {
        McuInfo.CurrentTunerInfo mCurrentTunerInfo = new McuInfo.CurrentTunerInfo();
        McuInfo.RadioListInfo mRadioListInfo = new McuInfo.RadioListInfo();
        McuInfo.RadioRDS mRadioRDS = new McuInfo.RadioRDS();
        McuInfo.RadioRangeInfo mRadioRangeInfo = new McuInfo.RadioRangeInfo();

        public McuInfo.CurrentTunerInfo getmCurrentTunerInfo() {
            return mCurrentTunerInfo;
        }
        public McuInfo.RadioListInfo getmRadioListInfo() {
            return mRadioListInfo;
        }
        public McuInfo.RadioRDS getmRadioRDS() {
            return mRadioRDS;
        }
        public McuInfo.RadioRangeInfo getmRadioRangeInfo() {
            return mRadioRangeInfo;
        }
    }

    public class RadioListInfo {
        int mPresetNum;
        char[] mPresets = new char[18];

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            mPresetNum = mcuPacket.param(0);
            int j = 1;
            int i;
            for (i = 0; j < 37; i++) {
                mPresets[i] = Utility.MakeWord(mcuPacket.param(j + 1), mcuPacket.param(j));
                j += 2;
            }
            Object[] arrayOfObject = new Object[18];
            for (i = 0; i < mPresets.length; i++)
                arrayOfObject[i] = Integer.valueOf(mPresets[i]);
            String.format("freqs: %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d", arrayOfObject);
        }

        public int getPresetNum() {
            return mPresetNum;
        }
        public char[] getmPresets() {
            return mPresets;
        }
    }

    public class RadioRDS {
        McuInfo.RDSCT mRDSCT = new McuInfo.RDSCT();
        McuInfo.RDSInfo mRDSInfo = new McuInfo.RDSInfo();
        McuInfo.RDSPS mRDSPS = new McuInfo.RDSPS();
        McuInfo.RDSPty mRDSPty = new McuInfo.RDSPty();
        McuInfo.RDSRT mRDSRT = new McuInfo.RDSRT();
        McuInfo.RDSSetting mRDSetting = new McuInfo.RDSSetting();

        public McuInfo.RDSCT getRDSCT() {
            return mRDSCT;
        }
        public McuInfo.RDSInfo getRDSInfo() {
            return mRDSInfo;
        }
        public McuInfo.RDSPS getRDSPS() {
            return mRDSPS;
        }
        public McuInfo.RDSPty getRDSPty() {
            return mRDSPty;
        }
        public McuInfo.RDSRT getRDSRT() {
            return mRDSRT;
        }
        public McuInfo.RDSSetting getRDSSetting() {
            return mRDSetting;
        }
    }

    public class RadioRangeInfo {
        byte mAMStep;
        byte mFMStep;
        char mMaxAMFreq;
        char mMaxFMFreq;
        char mMinAMFreq;
        char mMinFMFreq;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            mMinFMFreq = Utility.MakeWord(mcuPacket.param(1), mcuPacket.param(0));
            mMaxFMFreq = Utility.MakeWord(mcuPacket.param(3), mcuPacket.param(2));
            mMinAMFreq = Utility.MakeWord(mcuPacket.param(5), mcuPacket.param(4));
            mMaxAMFreq = Utility.MakeWord(mcuPacket.param(7), mcuPacket.param(6));
            mFMStep = mcuPacket.param(8);
            mAMStep = mcuPacket.param(9);
            String.format("REFRESH_TUNER_RANGE: %d %d %d %d %d %d",
                    new Object[] {
                            Integer.valueOf(mMinFMFreq),
                            Integer.valueOf(mMaxFMFreq),
                            Integer.valueOf(mMinAMFreq),
                            Integer.valueOf(mMaxAMFreq),
                            Integer.valueOf(mFMStep),
                            Integer.valueOf(mAMStep)
                    });
        }

        public byte getmAMStep() {
            return mAMStep;
        }
        public byte getmFMStep() {
            return mFMStep;
        }
        public char getmMaxAMFreq() {
            return mMaxAMFreq;
        }
        public char getmMaxFMFreq() {
            return mMaxFMFreq;
        }
        public char getmMinAMFreq() {
            return mMinAMFreq;
        }
        public char getmMinFMFreq() {
            return mMinFMFreq;
        }
    }

    public class SWCKeyStatus {
        boolean bStudyed;
        byte u8KeyId;

        public byte getU8KeyId() {
            return u8KeyId;
        }
        public boolean isbStudyed() {
            return bStudyed;
        }
    }

    public class SWCStatus {
        private McuInfo.SWCKeyStatus curKeyStatus = new McuInfo.SWCKeyStatus();

        private byte[] keyStatusTable = new byte[21];
        private byte u8ResistanceValue;
        private byte u8SWVerfifyEnd;

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            McuInfo.SWCKeyStatus sWCKeyStatus;
            boolean bool = true;
            switch (mcuPacket.param(0)) {
                case 0:
                    u8SWVerfifyEnd = 0;
                    break;
                case 1:
                    curKeyStatus.u8KeyId = mcuPacket.param(1);
                    curKeyStatus.bStudyed = (mcuPacket.param(2) == 1);
                    break;
                case 2:
                    u8ResistanceValue = mcuPacket.param(1);
                    break;
                case 3:
                    for (int i = 0; i < 21; i++) {
                        keyStatusTable[i] = mcuPacket.param(i + 1);
                    }
                    break;
            }
        }

        public McuInfo.SWCKeyStatus getCurKeyStatus() {
            return curKeyStatus;
        }
        public byte[] getKeyStatusTable() {
            return keyStatusTable;
        }
        public byte getSWVerfifyEnd() {
            return u8SWVerfifyEnd;
        }
        public byte getU8ResistanceValue() {
            return u8ResistanceValue;
        }
    }

    public class VolumeOffset {
        byte[] mVolumeOffsetVol = new byte[6];

        public void ParseCmd(McuService.McuPacket mcuPacket) {
            for (int i = 0; i < 6; i++) {
                mVolumeOffsetVol[i] = mcuPacket.param(i);
                Log.i("McuService", "mVolumeOffset---->" + mVolumeOffsetVol[i]);
            }
        }

        public byte[] getVolumeOffsetVol() {
            return mVolumeOffsetVol;
        }
    }

    static McuInfo mMcuInfo = null;

    private ATVInfo mATVInfo = new ATVInfo();
    private AudioInfo mAudioInfo = new AudioInfo();
    private CanBusInfo mCanBusInfo = new CanBusInfo();
    private CurrentBKStatus mCurrentBKStatus = new CurrentBKStatus();
    private CurrentVolStatus mCurrentVolStatus = new CurrentVolStatus();
    private DeviceDetectionInfo mDetectionInfo = new DeviceDetectionInfo();
    private ExDvdMode mExDvdMode = new ExDvdMode();
    private CurrentFrontModeFromMcu mFrontModeFromMcu = new CurrentFrontModeFromMcu();
    private GenralSetting mGenralSetting = new GenralSetting();
    private IlluminPWM mIlluminPWM = new IlluminPWM();
    private KeyCode mKeyCode = new KeyCode();
    private McuVersion mMcuVersion = new McuVersion();
    private PowerStatus mPowerStatus = new PowerStatus();
    private PowerUpStatus mPowerUpStatus = new PowerUpStatus();
    private DeviceDetectionInfo mPrevDetectionInfo = new DeviceDetectionInfo();
    private RadioInfo mRadioInfo = new RadioInfo();
    private CurrentRearModeFromMcu mRearModeFromMcu = new CurrentRearModeFromMcu();
    private SWCStatus mSWStatus = new SWCStatus();
    private VolumeOffset mVolumeOffset = new VolumeOffset();

    public static McuInfo getInstance() {
        if (mMcuInfo == null) { mMcuInfo = new McuInfo(); }
        return mMcuInfo;
    }

    public ATVInfo getmATVInfo() {
        return mATVInfo;
    }
    public AudioInfo getmAudioInfo() {
        return mAudioInfo;
    }
    public CanBusInfo getmCanBusInfo() {
        return mCanBusInfo;
    }
    public CurrentBKStatus getmCurrentBKStatus() {
        return mCurrentBKStatus;
    }
    public CurrentVolStatus getmCurrentVolStatus() {
        return mCurrentVolStatus;
    }
    public DeviceDetectionInfo getmDetectionInfo() {
        return mDetectionInfo;
    }
    public ExDvdMode getmExDvdMode() {
        return mExDvdMode;
    }
    public CurrentFrontModeFromMcu getmFrontModeFromMcu() {
        return mFrontModeFromMcu;
    }
    public GenralSetting getmGenralSetting() {
        return mGenralSetting;
    }
    public IlluminPWM getmIlluminPWM() {
        return mIlluminPWM;
    }
    public KeyCode getmKeyCode() {
        return mKeyCode;
    }
    public McuVersion getmMcuVersion() {
        return mMcuVersion;
    }
    public PowerStatus getmPowerStatus() {
        return mPowerStatus;
    }
    public PowerUpStatus getmPowerUpStatus() {
        return mPowerUpStatus;
    }
    public DeviceDetectionInfo getmPrevDetectionInfo() {
        return mPrevDetectionInfo;
    }
    public RadioInfo getmRadioInfo() {
        return mRadioInfo;
    }
    public CurrentRearModeFromMcu getmRearModeFromMcu() {
        return mRearModeFromMcu;
    }
    public SWCStatus getmSWStatus() {
        return mSWStatus;
    }
    public VolumeOffset getmVolumeOffset() {
        return mVolumeOffset;
    }

    void shutdown() {
        try {
            Log.e("dlg", "shutdown now");
            Object object = Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "power" });
            object = Class.forName("android.os.IPowerManager$Stub").getMethod("asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { object });
            object.getClass().getMethod("shutdown", new Class[] { boolean.class, boolean.class }).invoke(object, new Object[] { Boolean.valueOf(false), Boolean.valueOf(true) });
            return;
        } catch (Exception exception) {
            Log.e("aaaa", exception.toString(), exception);
            return;
        }
    }
}
