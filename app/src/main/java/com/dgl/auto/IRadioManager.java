package com.dgl.auto;

import android.content.Context;
import android.os.RemoteException;

public abstract interface IRadioManager {

    public static abstract interface IRadioConstant
    {
        public static final int REGION_USA              = 0;
        public static final int REGION_Europe           = 1;
        public static final int REGION_Latin            = 2;
        public static final int REGION_OIRT             = 3;
        public static final int REGION_China            = 4;
        public static final int REGION_JAPAN            = 5;

        public static final int BAND_FM                 = 1;
        public static final int BAND_AM                 = 2;

        public static final int BAND_AM_1               = 3;
        public static final int BAND_AM_2               = 4;

        public static final int BAND_FM_1               = 0;
        public static final int BAND_FM_2               = 1;
        public static final int BAND_FM_3               = 2;

        public static final int BAND_CHANNEL_SIZE       = 18;
        public static final int BAND_SIZE               = 5;

        public static final int RADIO_AM_DEFUALT_FREQ   = 520;
        public static final int RADIO_FM_DEFUALT_FREQ   = 8750;
    }

    public static abstract interface IRadioRefreshMsgType
    {
        public static final int REFRESH_TUNER_INFO          = 1;
        public static final int REFRESH_TUNER_PRESET_LIST   = 2;
        public static final int REFRESH_TUNER_RANGE         = 3;
        public static final int REFRESH_TUNER_READY         = 0;
    }

    public static abstract interface IDataChange
    {
        public abstract int onTunerInfoChange();
        public abstract int onTunerPresetList();
        public abstract int onTunerRangeChange();
        public abstract int onTunerReady();
        public abstract int onTunerUpdateRdsInfo();
    }

    public abstract void init(Context context);
    public abstract void setDataChangeListener(IDataChange dataChange);
    public abstract void unInit();

    public abstract void AS() throws RemoteException;
    public abstract void DX_LOC() throws RemoteException;
    public abstract void PS() throws RemoteException;
    public abstract void band() throws RemoteException;
    public abstract int getAMStep() throws RemoteException;
    public abstract boolean getASStatus() throws RemoteException;
    public abstract int getBand() throws RemoteException;
    public abstract int getCurrFreq() throws RemoteException;
    public abstract int getFMStep() throws RemoteException;
    public abstract char[] getFreqList() throws RemoteException;
    public abstract boolean getLocalDx() throws RemoteException;
    public abstract int getMaxAMFreq() throws RemoteException;
    public abstract int getMaxFMFreq() throws RemoteException;
    public abstract int getMinAMFreq() throws RemoteException;
    public abstract int getMinFMFreq() throws RemoteException;
    public abstract boolean getPSStatus() throws RemoteException;
    public abstract int getPresetIndex() throws RemoteException;
    public abstract int getRDSArm2McuPtyType() throws RemoteException;
    public abstract int getRDSCT_Hour() throws RemoteException;
    public abstract int getRDSCT_Minute() throws RemoteException;
    public abstract int getRDSPtyType() throws RemoteException;
    public abstract char[] getRDSRDSPS() throws RemoteException;
    public abstract char[] getRDSRDSRT() throws RemoteException;
    public abstract int getRdsInfo() throws RemoteException;
    public abstract int getRdsSeting() throws RemoteException;
    public abstract boolean getScanSatus() throws RemoteException;
    public abstract boolean getSeekStatus() throws RemoteException;
    public abstract boolean getStMonoStatus() throws RemoteException;
    public abstract void loadFreq(int paramInt) throws RemoteException;
    public abstract void manulDown() throws RemoteException;
    public abstract void manulUp() throws RemoteException;
    public abstract void queryRadioFreqsList() throws RemoteException;
    public abstract void queryRadioInfo() throws RemoteException;
    public abstract void queryRadioRange() throws RemoteException;
    public abstract void queryRdsInfo() throws RemoteException;
    public abstract void saveFreq(int paramInt) throws RemoteException;
    public abstract void scan() throws RemoteException;
    public abstract void seekDown() throws RemoteException;
    public abstract void seekUp() throws RemoteException;
    public abstract void setFreq(char paramChar) throws RemoteException;
    public abstract void setPtyType(byte paramByte) throws RemoteException;
    public abstract void turnAFMode(boolean paramBoolean) throws RemoteException;
    public abstract void turnEONMode(boolean paramBoolean) throws RemoteException;
    public abstract void turnREGMode(boolean paramBoolean) throws RemoteException;
    public abstract void turnTAMode(boolean paramBoolean) throws RemoteException;

}
