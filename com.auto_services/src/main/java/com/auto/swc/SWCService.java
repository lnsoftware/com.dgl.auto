package com.auto.swc;

import com.auto.constant.McuConstant;
import com.dgl.auto.constant.CallbackConstant;

public class SWCService extends ISWC.Stub implements McuConstant.HostCmd, CallbackConstant.SWCCallbackConstant {
    // TODO: Complete
    private static SWCService sInstance = null;

    public static SWCService getInstance() {
        if (sInstance == null) { sInstance = new SWCService(); }
        return sInstance;
    }

    public void onMessage(int paramInt, String paramString) {
        // TODO: Complete
    }
}
