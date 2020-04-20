package com.auto.canbus;

import android.os.RemoteException;
import android.util.Log;
import com.auto.canbas.ICanbus;
import com.auto.canbas.ICanbusCallback;
import com.auto.constant.McuConstant;
import com.auto.mcuservice.McuService;

public class CanbusService extends ICanbus.Stub implements McuConstant.HostCmd {
    private static CanbusService sInstance = null;
    ICanbusCallback mCanBusCallback = null;
    private McuService mMcuService = null;

    private CanbusService() {
        mMcuService = McuService.getMcuService();
    }

    public static CanbusService getInstance() {
        if (sInstance == null)
            sInstance = new CanbusService();
        return sInstance;
    }

    public boolean init() {
        return true;
    }

    public void onMessage(int paramInt, byte[] array, int length) throws RemoteException {
        if (mCanBusCallback != null)
            try {
                mCanBusCallback.onEvent(paramInt, array, length);
                return;
            } catch (Exception exception) {
                Log.e("CanbusService", "Exception erre-->" + exception);
                exception.printStackTrace();
                return;
            }
    }

    public void setCallback(ICanbusCallback callback) throws RemoteException {
        mCanBusCallback = callback;
    }

    public void sndCanCmd(byte[] canCmd, int length) throws RemoteException {
        mMcuService.SndCmd(CMD_SND_CAN_PUBLIC_CMD, canCmd, length);
    }
}