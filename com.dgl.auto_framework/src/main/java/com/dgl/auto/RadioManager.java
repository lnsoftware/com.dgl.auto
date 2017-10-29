package com.dgl.auto;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;

import com.auto.radioservice.RadioPlayer;
import com.dgl.auto.constant.CallbackConstant;

public class RadioManager implements IRadioManager, CallbackConstant.RadioCallbackConstant {

    static IRadioManager mRadioManager = null;
    IRadioManager.IDataChange mIDataChangeListener = null;
    RadioPlayer mRadioPlayer = null;

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case UPDATE_TUNER_INFO: {
                    if(mIDataChangeListener != null) {
                        mIDataChangeListener.onTunerInfoChange();
                    }
                    return;
                }
                case UPDATE_PRESET_LIST_INFO: {
                    if(mIDataChangeListener != null) {
                        mIDataChangeListener.onTunerPresetList();
                    }
                    return;
                }
                case UPDATE_TUNER_RANGE: {
                    if(mIDataChangeListener != null) {
                        mIDataChangeListener.onTunerRangeChange();
                    }
                    return;
                }
                case UPDATE_TUNER_READY: {
                    if(mIDataChangeListener != null) {
                        mIDataChangeListener.onTunerReady();
                    }
                    return;
                }
                case UPDATE_TUNER_RDSINFO: {
                    if(mIDataChangeListener != null) {
                        mIDataChangeListener.onTunerUpdateRdsInfo();
                    }
                    return;
                }
            }
        }
    };

    public RadioManager() {
        mRadioPlayer = RadioPlayer.getInstance();
    }

    public static IRadioManager getInstance() {
        if (mRadioManager == null) {
            mRadioManager = new RadioManager();
        }
        return mRadioManager;
    }

    public void init(Context context) {
        setContext(context);
        setHandler(mHandler);
    }

    public void unInit() { }

    private void setContext(Context context) {
        mRadioPlayer.setContext(context);
    }

    private void setHandler(Handler handler) {
        mRadioPlayer.setHandler(handler);
    }

    public void setDataChangeListener(IRadioManager.IDataChange dataChangeListener) {
        mIDataChangeListener = dataChangeListener;
    }

    public void AS() throws RemoteException {
        this.mRadioPlayer.AS();
    }
    public void DX_LOC() throws RemoteException {
        this.mRadioPlayer.DX_LOC();
    }
    public void PS() throws RemoteException {
        this.mRadioPlayer.PS();
    }
    public void band() throws RemoteException {
        this.mRadioPlayer.band();
    }
    public int getAMStep() throws RemoteException {
        return this.mRadioPlayer.getAMStep();
    }
    public boolean getASStatus() throws RemoteException {
        return this.mRadioPlayer.getASStatus();
    }
    public int getBand() throws RemoteException {
        return this.mRadioPlayer.getBand();
    }
    public int getCurrFreq() throws RemoteException {
        return this.mRadioPlayer.getCurrFreq();
    }
    public int getFMStep() throws RemoteException {
        return this.mRadioPlayer.getFMStep();
    }
    public char[] getFreqList() throws RemoteException {
        return this.mRadioPlayer.getFreqList();
    }
    public boolean getLocalDx() throws RemoteException {
        return this.mRadioPlayer.getLocalDx();
    }
    public int getMaxAMFreq() throws RemoteException {
        return this.mRadioPlayer.getMaxAMFreq();
    }
    public int getMaxFMFreq() throws RemoteException {
        return this.mRadioPlayer.getMaxFMFreq();
    }
    public int getMinAMFreq() throws RemoteException {
        return this.mRadioPlayer.getMinAMFreq();
    }
    public int getMinFMFreq() throws RemoteException {
        return this.mRadioPlayer.getMinFMFreq();
    }
    public boolean getPSStatus() throws RemoteException {
        return this.mRadioPlayer.getPSStatus();
    }
    public int getPresetIndex() throws RemoteException {
        return this.mRadioPlayer.getPresetIndex();
    }
    public int getRDSArm2McuPtyType() throws RemoteException {
        return this.mRadioPlayer.getRDSArm2McuPtyType();
    }
    public int getRDSCT_Hour() throws RemoteException {
        return this.mRadioPlayer.getRDSCT_Hour();
    }
    public int getRDSCT_Minute() throws RemoteException {
        return this.mRadioPlayer.getRDSCT_Minute();
    }
    public int getRDSPtyType() throws RemoteException {
        return this.mRadioPlayer.getRDSPtyType();
    }
    public char[] getRDSRDSPS() throws RemoteException {
        return this.mRadioPlayer.getRDSRDSPS();
    }
    public char[] getRDSRDSRT() throws RemoteException {
        return this.mRadioPlayer.getRDSRDSRT();
    }
    public int getRdsInfo() throws RemoteException {
        return this.mRadioPlayer.getRdsInfo();
    }
    public int getRdsSeting() throws RemoteException {
        return this.mRadioPlayer.getRdsSeting();
    }
    public boolean getScanSatus() throws RemoteException {
        return this.mRadioPlayer.getScanSatus();
    }
    public boolean getSeekStatus() throws RemoteException {
        return this.mRadioPlayer.getSeekStatus();
    }
    public boolean getStMonoStatus() throws RemoteException {
        return this.mRadioPlayer.getStMonoStatus();
    }
    public void loadFreq(int nBroadcastID) throws RemoteException {
        this.mRadioPlayer.loadFreq(nBroadcastID);
    }
    public void manulDown() throws RemoteException {
        this.mRadioPlayer.manulDown();
    }
    public void manulUp() throws RemoteException {
        this.mRadioPlayer.manulUp();
    }
    public void queryRadioFreqsList() throws RemoteException {
        this.mRadioPlayer.queryRadioFreqsList();
    }
    public void queryRadioInfo() throws RemoteException {
        this.mRadioPlayer.queryRadioInfo();
    }
    public void queryRadioRange() throws RemoteException {
        this.mRadioPlayer.queryRadioRange();
    }
    public void queryRdsInfo() throws RemoteException {
        this.mRadioPlayer.queryRdsInfo();
    }
    public void saveFreq(int nBroadcastID) throws RemoteException {
        this.mRadioPlayer.saveFreq(nBroadcastID);
    }
    public void scan() throws RemoteException {
        this.mRadioPlayer.scan();
    }
    public void seekDown() throws RemoteException {
        this.mRadioPlayer.seekDown();
    }
    public void seekUp() throws RemoteException {
        this.mRadioPlayer.seekUp();
    }
    public void setFreq(char wLegalFreq) throws RemoteException {
        this.mRadioPlayer.setFreq(wLegalFreq);
    }
    public void setPtyType(byte nPtyType) throws RemoteException {
        this.mRadioPlayer.setPtyType(nPtyType);
    }
    public void turnAFMode(boolean bTurnOn) throws RemoteException {
        this.mRadioPlayer.turnAFMode(bTurnOn);
    }
    public void turnEONMode(boolean bTurnOn) throws RemoteException {
        this.mRadioPlayer.turnEONMode(bTurnOn);
    }
    public void turnREGMode(boolean bTurnOn) throws RemoteException {
        this.mRadioPlayer.turnREGMode(bTurnOn);
    }
    public void turnTAMode(boolean bTurnOn) throws RemoteException {
        this.mRadioPlayer.turnTAMode(bTurnOn);
    }
}
