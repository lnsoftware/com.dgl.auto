package com.auto.source;

import com.auto.constant.McuConstant;
import com.dgl.auto.constant.GlobalConstant;

public class McuCBMService extends ICBM.Stub implements McuConstant.HostCmd, McuConstant.McuSourceIndex, GlobalConstant {
    private boolean mbInCalling = false;
    private int mNormalAppMode = 0;

    public boolean isInCalling() {
        return mbInCalling;
    }

    public int getNormalAppMode() {
        return mNormalAppMode;
    }
}
