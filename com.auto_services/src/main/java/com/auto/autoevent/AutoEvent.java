package com.auto.autoevent;

import android.os.RemoteException;

import com.auto.mcuservice.McuService;
import com.dgl.auto.constant.CallbackConstant;

public class AutoEvent extends IAutoEvent.Stub implements CallbackConstant.AutoEventCallbackConstant {
    // TODO: Complete
    private static AutoEvent sInstance = null;
    private McuService mMcuService = null;

    public static AutoEvent getInstance() {
        if (sInstance == null) { sInstance = new AutoEvent(); }
        return sInstance;
    }

    public void onBackCarEvent(boolean bInBackCar) {
        // TODO: Complete
    }

    public void onBrakeEvent(boolean bInBrake) {
        // TODO: Complete
    }

    public void onIIIumine(boolean bInIIIumine) {
        // TODO: Complete
    }

    public void onIlluminPWMValue(int nPWMValue) {
        // TODO: Complete
    }

    public boolean isInBackcar() throws RemoteException {
        return mMcuService.getMcuInfo().getmDetectionInfo().isMbReverseState();
    }
}
