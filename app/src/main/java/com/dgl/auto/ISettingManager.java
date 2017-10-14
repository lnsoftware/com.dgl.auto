package com.dgl.auto;

import android.content.Context;
import android.os.RemoteException;

public abstract interface ISettingManager {

    public static abstract interface IDataChange {
        public abstract int onAudioSettingChange();
        public abstract int onGeneralSettingChange();
        public abstract int onUpdateMcuVersion();
    }

    public abstract void init(Context context);
    public abstract void setDataChangeListener(IDataChange dataChange);
    public abstract void unInit();

    public abstract String GetEmmcId() throws RemoteException;
    public abstract String GetMcuVersion() throws RemoteException;
    public abstract boolean GetSwitchMediaStatus() throws RemoteException;
    public abstract void SetSwitchMediaStatus(boolean bValue) throws RemoteException;

    public abstract boolean getAutoRunNaviValue() throws RemoteException;
    public abstract String getBTVersion() throws RemoteException;
    public abstract int getBalance() throws RemoteException;
    public abstract int getBass() throws RemoteException;
    public abstract boolean getBeep() throws RemoteException;
    public abstract int getBootTime() throws RemoteException;
    public abstract int getBright() throws RemoteException;
    public abstract String getCanVersion() throws RemoteException;
    public abstract boolean getCanWatchVideo() throws RemoteException;
    public abstract boolean getCanWatchVideoWhileDriver() throws RemoteException;
    public abstract String getCarNumber() throws RemoteException;
    public abstract int getContrast() throws RemoteException;
    public abstract int getEQ() throws RemoteException;
    public abstract int getFade() throws RemoteException;
    public abstract float getGPSVolumeMixValue() throws RemoteException;
    public abstract int getHueSetting() throws RemoteException;
    public abstract boolean getIllumeDetection() throws RemoteException;
    public abstract boolean getLound() throws RemoteException;
    public abstract int getMcuVol() throws RemoteException;
    public abstract int getMiddle() throws RemoteException;
    public abstract int getNaviMode() throws RemoteException;
    public abstract String getNaviPackageName() throws RemoteException;
    public abstract int getRadioField() throws RemoteException;
    public abstract boolean getReverseAuxLine() throws RemoteException;
    public abstract boolean getReverseMirror() throws RemoteException;
    public abstract int getSWCTypeValue() throws RemoteException;
    public abstract int getSaturation() throws RemoteException;
    public abstract int getScreenBrightness() throws RemoteException;
    public abstract boolean getShortcutTouchState() throws RemoteException;
    public abstract int getSubwoofer() throws RemoteException;
    public abstract String getSystemVersion() throws RemoteException;
    public abstract int getTreble() throws RemoteException;
    public abstract int getUSB0TypeValue() throws RemoteException;
    public abstract int getUSB1TypeValue() throws RemoteException;
    public abstract byte[] getVolumeOffset() throws RemoteException;

    public abstract boolean isHCNAppFirstStartup() throws RemoteException;
    public abstract boolean isMcuMute() throws RemoteException;
    public abstract void setAutoRunNaviValue(boolean bValue) throws RemoteException;
    public abstract void setBalance(int balance) throws RemoteException;
    public abstract void setBass(int bass) throws RemoteException;
    public abstract void setBeep(boolean bBeepOn) throws RemoteException;
    public abstract void setBootTime(int nBootTime) throws RemoteException;
    public abstract void setBright(int bright) throws RemoteException;
    public abstract void setBrightness(int brightness) throws RemoteException;
    public abstract void setCanWatchVideoWhileDriver(boolean bValue) throws RemoteException;
    public abstract void setContrast(int contrast) throws RemoteException;
    public abstract void setEQ(int eqMode) throws RemoteException;
    public abstract void setFade(int fade) throws RemoteException;
    public abstract void setGPSVolumeMixValue(float value) throws RemoteException;
    public abstract void setHueSetting(int hue) throws RemoteException;
    public abstract void setIllumeDetection(boolean bIllumeDetOn) throws RemoteException;
    public abstract void setLound(boolean bOn) throws RemoteException;
    public abstract void setMcuMute(int nMute) throws RemoteException;
    public abstract void setMcuVol(int nVol) throws RemoteException;
    public abstract void setMiddle(int middle) throws RemoteException;
    public abstract void setNaviMode(int mode) throws RemoteException;
    public abstract void setNaviPackageName(String value) throws RemoteException;
    public abstract void setRadioField(int field) throws RemoteException;
    public abstract void setReverseAuxLine(boolean bAuxLine) throws RemoteException;
    public abstract void setReverseMirror(boolean bMirror) throws RemoteException;
    public abstract void setSWCTypeValue(int nSWCType) throws RemoteException;
    public abstract void setSaturation(int saturation) throws RemoteException;
    public abstract void setShortcutTouchState(boolean bValue) throws RemoteException;
    public abstract void setSubwoofer(int nSubwoofer) throws RemoteException;
    public abstract void setTestMode(int testMode, int status, int enter) throws RemoteException;
    public abstract void setTreble(int treble) throws RemoteException;
    public abstract void setUSB0TypeValue(int nUSBType) throws RemoteException;
    public abstract void setUSB1TypeValue(int nUSBType) throws RemoteException;
    public abstract void setVolumeOffset(byte[] bBuff, int nLength) throws RemoteException;

}
