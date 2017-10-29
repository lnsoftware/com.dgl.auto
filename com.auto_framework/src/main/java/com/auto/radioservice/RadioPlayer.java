package com.auto.radioservice;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

public class RadioPlayer {
    public static final String TAG = "RadioPlayer";
    static Context mContext = null;
    private static RadioPlayer sRadioInstance = null;
    private Handler mHandler;
    private IRadioPlayer mRadioService;
    private final IRadioCallback mToken;

    private RadioPlayer() {
        mHandler = null;
        mRadioService = null;
        mToken = new IRadioCallback.Stub() {
            @Override
            public void onEvent(int paramInt, String paramString) throws RemoteException {
                if (mHandler != null) {
                    Log.i(TAG, "onEvent[" + paramInt + "]---->" + paramString);
                    mHandler.obtainMessage(paramInt, paramString).sendToTarget();
                    return;
                }
                Log.e(TAG, "----------------mHandler==null");
            }
        };

        initService();
    }

    public static RadioPlayer getInstance() {
        if(sRadioInstance == null) {
            sRadioInstance = new RadioPlayer();
        }
        return sRadioInstance;
    }

    private void initService() {
        if(mRadioService != null) { return; }

        Log.i(TAG, "---------------mRadioService==null");
        mRadioService = IRadioPlayer.Stub.asInterface(ServiceManager.getService("radioservice"));
        if(mRadioService != null) {
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
        if (mRadioService == null) { return; }
        mRadioService.setcallback(mToken);
    }

    public void AS() throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.AS();
    }
    public void DX_LOC() throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.DX_LOC();
    }
    public void PS() throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.PS();
    }
    public void band() throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.band();
    }
    public int getAMStep() throws RemoteException {
        initService();
        if (mRadioService == null) { return 0; }
        return mRadioService.getAMStep();
    }
    public boolean getASStatus() throws RemoteException {
        initService();
        if (mRadioService == null) { return false; }
        return mRadioService.getASStatus();
    }
    public int getBand() throws RemoteException {
        initService();
        if (mRadioService == null) { return 0; }
        return mRadioService.getBand();
    }
    public int getCurrFreq() throws RemoteException {
        initService();
        if (mRadioService == null) { return 0; }
        return mRadioService.getCurrFreq();
    }
    public int getFMStep() throws RemoteException {
        initService();
        if (mRadioService == null) { return 0; }
        return mRadioService.getFMStep();
    }
    public char[] getFreqList() throws RemoteException {
        initService();
        if (mRadioService == null) { return null; }
        return mRadioService.getFreqList();
    }
    public boolean getLocalDx() throws RemoteException {
        initService();
        if (mRadioService == null) { return false; }
        return mRadioService.getLocalDx();
    }
    public int getMaxAMFreq() throws RemoteException {
        initService();
        if (mRadioService == null) { return 0; }
        return mRadioService.getMaxAMFreq();
    }
    public int getMaxFMFreq() throws RemoteException {
        initService();
        if (mRadioService == null) { return 0; }
        return mRadioService.getMaxFMFreq();
    }
    public int getMinAMFreq() throws RemoteException {
        initService();
        if (mRadioService == null) { return 0; }
        return mRadioService.getMinAMFreq();
    }
    public int getMinFMFreq() throws RemoteException {
        initService();
        if (mRadioService == null) { return 0; }
        return mRadioService.getMinFMFreq();
    }
    public boolean getPSStatus() throws RemoteException {
        initService();
        if (mRadioService == null) { return false; }
        return mRadioService.getPSStatus();
    }
    public int getPresetIndex() throws RemoteException {
        initService();
        if (mRadioService == null) { return 0; }
        return mRadioService.getPresetIndex();
    }
    public int getRDSArm2McuPtyType() throws RemoteException {
        initService();
        if (mRadioService == null) { return 0; }
        return mRadioService.getRDSArm2McuPtyType();
    }
    public int getRDSCT_Hour() throws RemoteException {
        initService();
        if (mRadioService == null) { return 0; }
        return mRadioService.getRDSCT_Hour();
    }
    public int getRDSCT_Minute() throws RemoteException {
        initService();
        if (mRadioService == null) { return 0; }
        return mRadioService.getRDSCT_Minute();
    }
    public int getRDSPtyType() throws RemoteException {
        initService();
        if (mRadioService == null) { return 0; }
        return mRadioService.getRDSPtyType();
    }
    public char[] getRDSRDSPS() throws RemoteException {
        initService();
        if (mRadioService == null) { return null; }
        return mRadioService.getRDSRDSPS();
    }
    public char[] getRDSRDSRT() throws RemoteException {
        initService();
        if (mRadioService == null) { return null; }
        return mRadioService.getRDSRDSRT();
    }
    public int getRdsInfo() throws RemoteException {
        initService();
        if (mRadioService == null) { return 0; }
        return mRadioService.getRdsInfo();
    }
    public int getRdsSeting() throws RemoteException {
        initService();
        if (mRadioService == null) { return 0; }
        return mRadioService.getRdsSeting();
    }
    public boolean getScanSatus() throws RemoteException {
        initService();
        if (mRadioService == null) { return false; }
        return mRadioService.getScanSatus();
    }
    public boolean getSeekStatus() throws RemoteException {
        initService();
        if (mRadioService == null) { return false; }
        return mRadioService.getSeekStatus();
    }
    public boolean getStMonoStatus() throws RemoteException {
        initService();
        if (mRadioService == null) { return false; }
        return mRadioService.getStMonoStatus();
    }
    public void loadFreq(final int n) throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.loadFreq(n);
    }
    public void manulDown() throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.manulDown();
    }
    public void manulUp() throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.manulUp();
    }
    public void queryRadioFreqsList() throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.queryRadioFreqsList();
    }
    public void queryRadioInfo() throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.queryRadioInfo();
    }
    public void queryRadioRange() throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.queryRadioRange();
    }
    public void queryRdsInfo() throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.queryRdsInfo();
    }
    public void saveFreq(final int n) throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.saveFreq(n);
    }
    public void scan() throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.scan();
    }
    public void seekDown() throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.seekDown();
    }
    public void seekUp() throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.seekUp();
    }
    public void setFreq(final char freq) throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.setFreq(freq);
    }
    public void setPtyType(final byte ptyType) throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.setPtyType(ptyType);
    }
    public void turnAFMode(final boolean b) throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.turnAFMode(b);
    }
    public void turnEONMode(final boolean b) throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.turnEONMode(b);
    }
    public void turnREGMode(final boolean b) throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.turnREGMode(b);
    }
    public void turnTAMode(final boolean b) throws RemoteException {
        initService();
        if (mRadioService == null) { return; }
        mRadioService.turnTAMode(b);
    }
}
