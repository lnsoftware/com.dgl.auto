package com.auto.setting;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ServiceManager;

public class Setting {
    static Context mContext = null;
    private static Setting sSettingInstance = null;

    private Handler mHandler;
    private ISetting mSettingService;
    private final ISettingCallback mToken;
    ISettingCallback paramIRadioCallback;

    private Setting() {
        mHandler = null;
        mSettingService = null;
        mToken = new ISettingCallback.Stub() {
            @Override
            public void onEvent(int paramInt, String paramString) {
                if (mHandler != null) {
                    mHandler.obtainMessage(paramInt, paramString).sendToTarget();
                }
            }
        };
        paramIRadioCallback = new ISettingCallback.Stub() {
            @Override
            public void onEvent(int paramInt, String paramString) throws RemoteException {
                if(mHandler != null) {
                    mHandler.obtainMessage(paramInt, paramString).sendToTarget();
                }
            }
        };

        initService();
    }

    public static Setting getInstance() {
        if(sSettingInstance == null) {
            sSettingInstance = new Setting();
        }
        return sSettingInstance;
    }

    private void initService() {
        if(mSettingService != null) { return; }

        mSettingService = ISetting.Stub.asInterface(ServiceManager.getService("settingservice"));
        if(mSettingService != null) {
            try {
                setCallback();
            } catch(RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public void setHandler(Handler handler) {
        mHandler = handler;
    }

    public void setCallback() throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setcallback(mToken);
    }

    public void setEQ(int eqMode) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setEQ(eqMode);
    }

    public void setBalance(int balance) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setBalance(balance);
    }

    public void setFade(int fade) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setFade(fade);
    }

    public void setLound(boolean bOn) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setLound(bOn);
    }

    public void setSubwoofer(int nSubwoofer) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setSubwoofer(nSubwoofer);
    }

    public void setBass(int bass) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setBass(bass);
    }

    public void setMiddle(int middle) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setMiddle(middle);
    }

    public void setTreble(int treble) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setTreble(treble);
    }

    public void setBright(int bright) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setBright(bright);
    }

    public void setContrast(int contrast) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setContrast(contrast);
    }

    public void setClockMode(boolean b24) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setClockMode(b24);
    }

    public void setBeep(boolean bBeepOn) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setBeep(bBeepOn);
    }

    public void setIllumeDetection(boolean bIllumeDetOn) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setIllumeDetection(bIllumeDetOn);
    }

    public void setReverseDetection(boolean bReverseDetOn) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setIllumeDetection(bReverseDetOn);
    }

    public void setReverseImage(boolean bReverseImage) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setReverseImage(bReverseImage);
    }

    public void setReverseGain(boolean bReverseGain) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setReverseGain(bReverseGain);
    }

    public void setRadioField(int field) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setRadioField(field);
    }

    public void setNaviMode(int mode) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setNaviMode(mode);
    }

    public void setClockHour(int hour) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setClockHour(hour);
    }

    public void setClockMinute(int min) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setClockMinute(min);
    }

    public void setHueSetting(int hue) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setHueSetting(hue);
    }

    public void setSaturation(int saturation) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setSaturation(saturation);
    }

    public void setReverseMirror(boolean bMirror) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setReverseMirror(bMirror);
    }

    public void setReverseAuxLine(boolean bOn) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setReverseAuxLine(bOn);
    }

    public void setCarConfigLevel(int level) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setCarConfigLevel(level);
    }

    public void setBootTime(int nBootTime) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setBootTime(nBootTime);
    }

    public void setMcuVol(int nVol) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setMcuVol(nVol);
    }

    public void setMcuMute(int nMute) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setMcuMute(nMute);
    }

    public void setTestMode(int testMode, int status, int enter) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setTestMode(testMode, status, enter);
    }

    public boolean isMcuMute() throws RemoteException {
        initService();
        if (mSettingService == null) { return false; }
        return mSettingService.isMcuMute();
    }

    public String GetMcuVersion() throws RemoteException {
        initService();
        if (mSettingService == null) { return ""; }
        return mSettingService.GetMcuVersion();
    }

    public int getEQ() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getEQ();
    }

    public int getNaviMode() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getNaviMode();
    }

    public int getBalance() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getBalance();
    }

    public int getFade() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getFade();
    }

    public boolean getLound() throws RemoteException {
        initService();
        if (mSettingService == null) { return false; }
        return mSettingService.getLound();
    }

    public int getSubwoofer() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getSubwoofer();
    }

    public int getBass() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getBass();
    }

    public int getMiddle() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getMiddle();
    }

    public int getTreble() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getTreble();
    }

    public int getBright() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getBright();
    }

    public int getContrast() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getContrast();
    }

    public boolean getBeep() throws RemoteException {
        initService();
        if (mSettingService == null) { return false; }
        return mSettingService.getBeep();
    }

    public boolean getIllumeDetection() throws RemoteException {
        initService();
        if (mSettingService == null) { return false; }
        return mSettingService.getIllumeDetection();
    }

    public int getRadioField() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getRadioField();
    }

    public int getHueSetting() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getHueSetting();
    }

    public int getSaturation() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getSaturation();
    }

    public int getMcuVol() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getMcuVol();
    }

    public int getBootTime() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getBootTime();
    }

    public boolean getReverseMirror() throws RemoteException {
        initService();
        if (mSettingService == null) { return false; }
        return mSettingService.getReverseMirror();
    }

    public boolean getReverseAuxLine() throws RemoteException {
        initService();
        if (mSettingService == null) { return false; }
        return mSettingService.getReverseAuxLine();
    }

    public void setUSBTypeValue(int nUSBType) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setUSBTypeValue(nUSBType);
    }

    public void setUSB0TypeValue(int nUSBType) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setUSB0TypeValue(nUSBType);
    }

    public void setUSB1TypeValue(int nUSBType) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setUSB1TypeValue(nUSBType);
    }

    public void setSWCTypeValue(int nSWCType) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setSWCTypeValue(nSWCType);
    }

    public void setGPSVolumeMixValue(float value) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setGPSVolumeMixValue(value);
    }

    public void setShortcutTouchState(boolean bValue) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setShortcutTouchState(bValue);
    }

    public void setCanWatchVideoWhileDriver(boolean bValue) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setCanWatchVideoWhileDriver(bValue);
    }

    public boolean getCanWatchVideo() throws RemoteException {
        initService();
        if (mSettingService == null) { return false; }
        return mSettingService.getCanWatchVideo();
    }

    public void setAutoRunNaviValue(boolean bValue) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setAutoRunNaviValue(bValue);
    }

    public void setNaviPackageName(String value) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setNaviPackageName(value);
    }

    public String getNaviPackageName() throws RemoteException {
        initService();
        if (mSettingService == null) { return ""; }
        return mSettingService.getNaviPackageName();
    }

    public String getSystemVersion() throws RemoteException {
        initService();
        if (mSettingService == null) { return ""; }
        return mSettingService.getSystemVersion();
    }

    public String getBTVersion() throws RemoteException {
        initService();
        if (mSettingService == null) { return ""; }
        return mSettingService.getBTVersion();
    }

    public String getCarNumber() throws RemoteException {
        initService();
        if (mSettingService == null) { return ""; }
        return mSettingService.getCarNumber();
    }

    public String GetEmmcId() throws RemoteException {
        initService();
        if (mSettingService == null) { return ""; }
        return mSettingService.GetEmmcId();
    }

    public String getCanVersion() throws RemoteException {
        initService();
        if (mSettingService == null) { return ""; }
        return mSettingService.getCanVersion();
    }

    public int getUSBTypeValue() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getUSBTypeValue();
    }

    public int getUSB0TypeValue() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getUSB0TypeValue();
    }

    public int getUSB1TypeValue() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getUSB1TypeValue();
    }

    public int getSWCTypeValue() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getSWCTypeValue();
    }

    public float getGPSVolumeMixValue() throws RemoteException {
        initService();
        if (mSettingService == null) { return 0; }
        return mSettingService.getGPSVolumeMixValue();
    }

    public boolean getShortcutTouchState() throws RemoteException {
        initService();
        if (mSettingService == null) { return false; }
        return mSettingService.getShortcutTouchState();
    }

    public boolean getCanWatchVideoWhileDriver() throws RemoteException {
        initService();
        if (mSettingService == null) { return false; }
        return mSettingService.getCanWatchVideoWhileDriver();
    }

    public boolean getAutoRunNaviValue() throws RemoteException {
        initService();
        if (mSettingService == null) { return false; }
        return mSettingService.getAutoRunNaviValue();
    }

    public void setVolumeOffset(byte[] bBuff, int nLength) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setVolumeOffset(bBuff, nLength);
    }

    public byte[] getVolumeOffset() throws RemoteException {
        initService();
        if (mSettingService == null) { return null; }
        return mSettingService.getVolumeOffset();
    }

    public void setBrightness(int brightness) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setBrightness(brightness);
    }

    public int getScreenBrightness() throws RemoteException {
        initService();
        if (mSettingService == null) { return -0x1; }
        return mSettingService.getScreenBrightness();
    }

    public void SetSwitchMediaStatus(boolean bValue) throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.SetSwitchMediaStatus(bValue);
    }

    public boolean GetSwitchMediaStatus() throws RemoteException {
        initService();
        if (mSettingService == null) { return false; }
        return mSettingService.GetSwitchMediaStatus();
    }

    public boolean isHCNAppFirstStartup() throws RemoteException {
        initService();
        if (mSettingService == null) { return false; }
        return mSettingService.isHCNAppFirstStartup();
    }

    public void removecallback(ISettingCallback paramIRadioCallback) throws RemoteException { }

    public void setcallback() throws RemoteException {
        initService();
        if (mSettingService == null) { return; }
        mSettingService.setcallback(paramIRadioCallback);
    }
}
