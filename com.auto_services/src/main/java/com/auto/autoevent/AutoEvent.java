package com.auto.autoevent;

import com.dgl.auto.constant.CallbackConstant;

public class AutoEvent extends IAutoEvent.Stub implements CallbackConstant.AutoEventCallbackConstant {
    // TODO: Complete
    private static AutoEvent sInstance = null;

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
}
