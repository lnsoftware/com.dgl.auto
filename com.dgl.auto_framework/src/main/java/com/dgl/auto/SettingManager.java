package com.dgl.auto;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;

import com.auto.setting.Setting;
import com.dgl.auto.constant.CallbackConstant;

public class SettingManager implements ISettingManager, CallbackConstant.SettingCallbackConstant {

    Setting mSetting = null;
    ISettingManager.IDataChange mIDataChangeListener = null;
    static SettingManager mSettingManager = null;

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case UPDATE_SETUP_GENERAL_INFO: {
                    if(mIDataChangeListener != null) {
                        mIDataChangeListener.onGeneralSettingChange();
                    }
                    return;
                }
                case UPDATE_SETUP_AUDIO_INFO: {
                    if(mIDataChangeListener != null) {
                        mIDataChangeListener.onAudioSettingChange();
                    }
                    return;
                }
                case UPDATE_MCU_VERSION: {
                    if(mIDataChangeListener != null) {
                        mIDataChangeListener.onUpdateMcuVersion();
                        break;
                    }
                }
            }
        }
    };

    public SettingManager() {
        mSetting = Setting.getInstance();
    }

    public static ISettingManager getInstance() {
        if(mSettingManager == null) {
            mSettingManager = new SettingManager();
        }
        return mSettingManager;
    }

    public void init(Context context) {
        setContext(context);
        setHandler(mHandler);
    }

    public void unInit() { }

    private void setHandler(Handler handler) {
        mSetting.setHandler(handler);
    }

    private void setContext(Context context) {
        mSetting.setContext(context);
    }

    public void setDataChangeListener(ISettingManager.IDataChange dataChangeListener) {
        mIDataChangeListener = dataChangeListener;
    }

    public void setEQ(int eqMode) throws RemoteException {
        mSetting.setEQ(eqMode);
    }

    public void setNaviMode(int mode) throws RemoteException {
        mSetting.setNaviMode(mode);
    }

    public void setBalance(int balance) throws RemoteException {
        mSetting.setBalance(balance);
    }

    public void setFade(int fade) throws RemoteException {
        mSetting.setFade(fade);
    }

    public void setLound(boolean bOn) throws RemoteException {
        mSetting.setLound(bOn);
    }

    public void setSubwoofer(int nSubwoofer) throws RemoteException {
        mSetting.setSubwoofer(nSubwoofer);
    }

    public void setBass(int bass) throws RemoteException {
        mSetting.setBass(bass);
    }

    public void setMiddle(int middle) throws RemoteException {
        mSetting.setMiddle(middle);
    }

    public void setTreble(int treble) throws RemoteException {
        mSetting.setTreble(treble);
    }

    public void setBright(int bright) throws RemoteException {
        mSetting.setBright(bright);
    }

    public void setContrast(int contrast) throws RemoteException {
        mSetting.setContrast(contrast);
    }

    public void setIllumeDetection(boolean bIllumeDetOn) throws RemoteException {
        mSetting.setIllumeDetection(bIllumeDetOn);
    }

    public void setReverseMirror(boolean bMirror) throws RemoteException {
        mSetting.setReverseMirror(bMirror);
    }

    public void setRadioField(int field) throws RemoteException {
        mSetting.setRadioField(field);
    }

    public void setHueSetting(int hue) throws RemoteException {
        mSetting.setHueSetting(hue);
    }

    public void setSaturation(int saturation) throws RemoteException {
        mSetting.setSaturation(saturation);
    }

    public void setReverseAuxLine(boolean bAuxLine) throws RemoteException {
        mSetting.setReverseAuxLine(bAuxLine);
    }

    public void setBootTime(int nBootTime) throws RemoteException {
        mSetting.setBootTime(nBootTime);
    }

    public void setMcuVol(int nVol) throws RemoteException {
        mSetting.setMcuVol(nVol);
    }

    public String GetMcuVersion() throws RemoteException {
        return mSetting.GetMcuVersion();
    }

    public String getCarNumber() throws RemoteException {
        return mSetting.getCarNumber();
    }

    public String GetEmmcId() throws RemoteException {
        return mSetting.GetEmmcId();
    }

    public void setBeep(boolean bBeepOn) throws RemoteException {
        mSetting.setBeep(bBeepOn);
    }

    public int getEQ() throws RemoteException {
        return mSetting.getEQ();
    }

    public int getNaviMode() throws RemoteException {
        return mSetting.getNaviMode();
    }

    public int getBalance() throws RemoteException {
        return mSetting.getBalance();
    }

    public int getFade() throws RemoteException {
        return mSetting.getFade();
    }

    public boolean getLound() throws RemoteException {
        return mSetting.getLound();
    }

    public int getSubwoofer() throws RemoteException {
        return mSetting.getSubwoofer();
    }

    public int getBass() throws RemoteException {
        return mSetting.getBass();
    }

    public int getMiddle() throws RemoteException {
        return mSetting.getMiddle();
    }

    public int getTreble() throws RemoteException {
        return mSetting.getTreble();
    }

    public int getBright() throws RemoteException {
        return mSetting.getBright();
    }

    public int getContrast() throws RemoteException {
        return mSetting.getContrast();
    }

    public boolean getBeep() throws RemoteException {
        return mSetting.getBeep();
    }

    public boolean getIllumeDetection() throws RemoteException {
        return mSetting.getIllumeDetection();
    }

    public int getRadioField() throws RemoteException {
        return mSetting.getRadioField();
    }

    public int getBootTime() throws RemoteException {
        return mSetting.getBootTime();
    }

    public boolean getReverseMirror() throws RemoteException {
        return mSetting.getReverseMirror();
    }

    public boolean getReverseAuxLine() throws RemoteException {
        return mSetting.getReverseAuxLine();
    }

    public int getHueSetting() throws RemoteException {
        return mSetting.getHueSetting();
    }

    public int getSaturation() throws RemoteException {
        return mSetting.getSaturation();
    }

    public int getMcuVol() throws RemoteException {
        return mSetting.getMcuVol();
    }

    public void setUSBTypeValue(int nUSBType) throws RemoteException {
        mSetting.setUSBTypeValue(nUSBType);
    }

    public void setUSB0TypeValue(int nUSBType) throws RemoteException {
        mSetting.setUSB0TypeValue(nUSBType);
    }

    public void setUSB1TypeValue(int nUSBType) throws RemoteException {
        mSetting.setUSB1TypeValue(nUSBType);
    }

    public void setSWCTypeValue(int nSWCType) throws RemoteException {
        mSetting.setSWCTypeValue(nSWCType);
    }

    public void setGPSVolumeMixValue(float value) throws RemoteException {
        mSetting.setGPSVolumeMixValue(value);
    }

    public void setShortcutTouchState(boolean bValue) throws RemoteException {
        mSetting.setShortcutTouchState(bValue);
    }

    public void setCanWatchVideoWhileDriver(boolean bValue) throws RemoteException {
        mSetting.setCanWatchVideoWhileDriver(bValue);
    }

    public void setAutoRunNaviValue(boolean bValue) throws RemoteException {
        mSetting.setAutoRunNaviValue(bValue);
    }

    public void setNaviPackageName(String value) throws RemoteException {
        mSetting.setNaviPackageName(value);
    }

    public String getSystemVersion() throws RemoteException {
        return mSetting.getSystemVersion();
    }

    public String getBTVersion() throws RemoteException {
        return mSetting.getBTVersion();
    }

    public String getCanVersion() throws RemoteException {
        return mSetting.getCanVersion();
    }

    public int getUSB0TypeValue() throws RemoteException {
        return mSetting.getUSB0TypeValue();
    }

    public int getUSB1TypeValue() throws RemoteException {
        return mSetting.getUSB1TypeValue();
    }

    public int getSWCTypeValue() throws RemoteException {
        return mSetting.getSWCTypeValue();
    }

    public float getGPSVolumeMixValue() throws RemoteException {
        return mSetting.getGPSVolumeMixValue();
    }

    public boolean getShortcutTouchState() throws RemoteException {
        return mSetting.getShortcutTouchState();
    }

    public boolean getCanWatchVideoWhileDriver() throws RemoteException {
        return mSetting.getCanWatchVideoWhileDriver();
    }

    public boolean getCanWatchVideo() throws RemoteException {
        return mSetting.getCanWatchVideo();
    }

    public boolean getAutoRunNaviValue() throws RemoteException {
        return mSetting.getAutoRunNaviValue();
    }

    public String getNaviPackageName() throws RemoteException {
        return mSetting.getNaviPackageName();
    }

    public boolean isHCNAppFirstStartup() throws RemoteException {
        return mSetting.isHCNAppFirstStartup();
    }

    public void setTestMode(int testMode, int status, int enter) throws RemoteException {
        try {
            mSetting.setTestMode(testMode, status, enter);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setBrightness(int brightness) throws RemoteException {
        try {
            mSetting.setBrightness(brightness);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
    }

    public int getScreenBrightness() throws RemoteException {
        try {
            return mSetting.getScreenBrightness();
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return -0x1;
    }

    public void SetSwitchMediaStatus(boolean bValue) throws RemoteException {
        try {
            mSetting.SetSwitchMediaStatus(bValue);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean GetSwitchMediaStatus() throws RemoteException {
        try {
            return mSetting.GetSwitchMediaStatus();
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void setVolumeOffset(byte[] bBuff, int nLength) throws RemoteException {
        try {
            mSetting.setVolumeOffset(bBuff, nLength);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
    }

    public byte[] getVolumeOffset() throws RemoteException {
        try {
            return mSetting.getVolumeOffset();
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setMcuMute(int nMute) throws RemoteException {
        try {
            mSetting.setMcuMute(nMute);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean isMcuMute() throws RemoteException {
        return mSetting.isMcuMute();
    }
}
