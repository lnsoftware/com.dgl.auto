package com.auto.setting;

import android.os.RemoteException;

import com.auto.constant.McuConstant;
import com.dgl.auto.constant.CallbackConstant;

public class SettingService extends ISetting.Stub implements McuConstant.HostCmd, McuConstant.GeneralSetIndex, McuConstant.AudioSetIndex, CallbackConstant.SettingCallbackConstant {
    final String TAG = "HCNSetting";
    public static final int CMD_GIS_MIX_VAULE = 0;

    // TODO: Uncomment
    //private static ArmSettingImp mArmSettingImp = null;
    //private static CarSetting mCarSetting = null;
    //private static McuSettingImp mMcuSettingImp = null;
    private static SettingService sInstance = null;
    private float mGPSVolumeMixVaule = 0.1F;
    private int mSWCType = -1;
    public String strEmmcId = null;

    private SettingService() {
        sInstance = this;
    }

    public static SettingService getInstance() {
        if (sInstance == null) {
            sInstance = new SettingService();
            // TODO: Uncomment
            //mMcuSettingImp = McuSettingImp.getInstance();
            //mArmSettingImp = ArmSettingImp.getInstance();
            //mCarSetting = CarSetting.getInstance();
        }
        return sInstance;
    }

    public void initSystemConfig(boolean bMcuReset) {
        // TODO: Complete
    }

    public void onMessage(int paramInt, String paramString) {
        // TODO: Complete
    }

    public void saveSysemConfig() {
        // TODO: Complete
    }

    public String GetEmmcId() throws RemoteException {
        // TODO: Complete
        return null;
    }
    public String GetMcuVersion() throws RemoteException {
        // TODO: Complete
        return null;
    }
    public boolean GetSwitchMediaStatus() throws RemoteException {
        // TODO: Complete
        return false;
    }
    public void SetSwitchMediaStatus(boolean bValue) throws RemoteException {
        // TODO: Complete
    }
    public boolean getAutoRunNaviValue() throws RemoteException {
        // TODO: Complete
        return false;
    }
    public String getBTVersion() throws RemoteException {
        // TODO: Complete
        return null;
    }
    public int getBalance() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public int getBass() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public int getBassFreq() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public int getBassQ() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public boolean getBeep() throws RemoteException {
        // TODO: Complete
        return false;
    }
    public int getBootTime() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public int getBright() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public String getCanVersion() throws RemoteException {
        // TODO: Complete
        return null;
    }
    public boolean getCanWatchVideo() throws RemoteException {
        // TODO: Complete
        return false;
    }
    public boolean getCanWatchVideoWhileDriver() throws RemoteException {
        // TODO: Complete
        return false;
    }
    public int getCarConfigLevel() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public String getCarNumber() throws RemoteException {
        // TODO: Complete
        return null;
    }
    public int getClockHour() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public int getClockMinute() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public boolean getClockMode() throws RemoteException {
        // TODO: Complete
        return false;
    }
    public int getContrast() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public int getEQ() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public int getFade() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public float getGPSVolumeMixValue() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public int getHueSetting() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public boolean getIllumeDetection() throws RemoteException {
        // TODO: Complete
        return false;
    }
    public boolean getLound() throws RemoteException {
        // TODO: Complete
        return false;
    }
    public int getMcuVol() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public int getMiddle() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public int getMiddleFreq() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public int getMiddleQ() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public int getNaviMode() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public String getNaviPackageName() throws RemoteException {
        // TODO: Complete
        return null;
    }
    public int getRadioField() throws RemoteException {
        // TODO: Complete
        return 0;
    }
    public boolean getReverseAuxLine() throws RemoteException {
        // TODO: Complete
        return false;
    }
    public boolean getReverseDetection() throws RemoteException {
        // TODO: Complete
        return false;
    }

    @Override
    public int getReverseGain() throws RemoteException {
        return 0;
    }

    @Override
    public boolean getReverseImage() throws RemoteException {
        return false;
    }

    @Override
    public boolean getReverseMirror() throws RemoteException {
        return false;
    }

    @Override
    public int getSWCTypeValue() throws RemoteException {
        return 0;
    }

    @Override
    public int getSaturation() throws RemoteException {
        return 0;
    }

    @Override
    public int getScreenBrightness() throws RemoteException {
        return 0;
    }

    @Override
    public boolean getShortcutTouchState() throws RemoteException {
        return false;
    }

    @Override
    public int getSubFilterFreq() throws RemoteException {
        return 0;
    }

    @Override
    public int getSubwoofer() throws RemoteException {
        return 0;
    }

    @Override
    public int getSubwooferPhase() throws RemoteException {
        return 0;
    }

    @Override
    public String getSystemVersion() throws RemoteException {
        return null;
    }

    @Override
    public int getTreble() throws RemoteException {
        return 0;
    }

    @Override
    public int getTrebleFreq() throws RemoteException {
        return 0;
    }

    @Override
    public int getTrebleQ() throws RemoteException {
        return 0;
    }

    @Override
    public int getUSB0TypeValue() throws RemoteException {
        return 0;
    }

    @Override
    public int getUSB1TypeValue() throws RemoteException {
        return 0;
    }

    @Override
    public int getUSBTypeValue() throws RemoteException {
        return 0;
    }

    @Override
    public byte[] getVolumeOffset() throws RemoteException {
        return new byte[0];
    }

    public boolean getCanBusStatus() {
        // TODO: Complete
        return false;
    }

    @Override
    public boolean isHCNAppFirstStartup() throws RemoteException {
        return false;
    }

    @Override
    public boolean isMcuMute() throws RemoteException {
        return false;
    }

    @Override
    public void queryMcuVersion() throws RemoteException {

    }

    @Override
    public void removecallback(ISettingCallback paramISettingCallback) throws RemoteException {

    }

    @Override
    public void setAutoRunNaviValue(boolean bValue) throws RemoteException {

    }

    @Override
    public void setBalance(int balance) throws RemoteException {

    }

    @Override
    public void setBass(int bass) throws RemoteException {

    }

    @Override
    public void setBassFreq(int bassFreq) throws RemoteException {

    }

    @Override
    public void setBassQ(int bassQ) throws RemoteException {

    }

    @Override
    public void setBeep(boolean bBeepOn) throws RemoteException {

    }

    @Override
    public void setBootTime(int nBootTime) throws RemoteException {

    }

    @Override
    public void setBright(int bright) throws RemoteException {

    }

    @Override
    public void setBrightness(int brightness) throws RemoteException {

    }

    @Override
    public void setCanWatchVideoWhileDriver(boolean bValue) throws RemoteException {

    }

    @Override
    public void setCarConfigLevel(int level) throws RemoteException {

    }

    @Override
    public void setClockHour(int hour) throws RemoteException {

    }

    @Override
    public void setClockMinute(int min) throws RemoteException {

    }

    @Override
    public void setClockMode(boolean b24) throws RemoteException {

    }

    @Override
    public void setContrast(int contrast) throws RemoteException {

    }

    @Override
    public void setEQ(int eqMode) throws RemoteException {

    }

    @Override
    public void setFade(int fade) throws RemoteException {

    }

    @Override
    public void setGPSVolumeMixValue(float value) throws RemoteException {

    }

    @Override
    public void setHueSetting(int hue) throws RemoteException {

    }

    @Override
    public void setIllumeDetection(boolean bIllumeDetOn) throws RemoteException {

    }

    @Override
    public void setLound(boolean bOn) throws RemoteException {

    }

    @Override
    public void setMcuMute(int nMute) throws RemoteException {

    }

    @Override
    public void setMcuVol(int nVol) throws RemoteException {

    }

    @Override
    public void setMiddle(int middle) throws RemoteException {

    }

    @Override
    public void setMiddleFreq(int middleFreq) throws RemoteException {

    }

    @Override
    public void setMiddleQ(int middleQ) throws RemoteException {

    }

    @Override
    public void setNaviMode(int mode) throws RemoteException {

    }

    @Override
    public void setNaviPackageName(String value) throws RemoteException {

    }

    @Override
    public void setRadioField(int field) throws RemoteException {

    }

    @Override
    public void setReverseAuxLine(boolean bOn) throws RemoteException {

    }

    @Override
    public void setReverseDetection(boolean bReverseDetOn) throws RemoteException {

    }

    @Override
    public void setReverseGain(boolean bReverseGain) throws RemoteException {

    }

    @Override
    public void setReverseImage(boolean bReverseImage) throws RemoteException {

    }

    @Override
    public void setReverseMirror(boolean bMirror) throws RemoteException {

    }

    @Override
    public void setSWCTypeValue(int nSWCType) throws RemoteException {

    }

    @Override
    public void setSaturation(int saturation) throws RemoteException {

    }

    @Override
    public void setShortcutTouchState(boolean bValue) throws RemoteException {

    }

    @Override
    public void setSubFilterFreq(int swf) throws RemoteException {

    }

    @Override
    public void setSubwoofer(int nSubwoofer) throws RemoteException {

    }

    @Override
    public void setSubwooferPhase(int phase) throws RemoteException {

    }

    @Override
    public void setTestMode(int testMode, int status, int enter) throws RemoteException {

    }

    @Override
    public void setTreble(int treble) throws RemoteException {

    }

    @Override
    public void setTrebleFreq(int trebleFreq) throws RemoteException {

    }

    @Override
    public void setTrebleQ(int trebleQ) throws RemoteException {

    }

    @Override
    public void setUSB0TypeValue(int nUSBType) throws RemoteException {

    }

    @Override
    public void setUSB1TypeValue(int nUSBType) throws RemoteException {

    }

    @Override
    public void setUSBTypeValue(int nUSBType) throws RemoteException {

    }

    @Override
    public void setVolumeOffset(byte[] bBuff, int nLength) throws RemoteException {

    }

    @Override
    public void setcallback(ISettingCallback paramISettingCallback) throws RemoteException {

    }
}
