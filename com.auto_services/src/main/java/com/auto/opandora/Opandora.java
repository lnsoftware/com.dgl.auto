package com.auto.opandora;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.dgl.auto.constant.CallbackConstant;

public class Opandora extends IOpandora.Stub implements CallbackConstant.OpandoraCallbackConstant, CallbackConstant.OpandoraKeyIndex, CallbackConstant.KeyStatus, CallbackConstant.KeySource {
    // TODO: Complete
    private static Opandora sInstance = null;
    private Context mContext = null;

    public static Opandora getInstance() {
        if (sInstance == null) { sInstance = new Opandora(); }
        return sInstance;
    }

    public void broadcastShowTA() {
        Log.v("Opandora", "broadcastShowTA");
        Intent intent = new Intent("com.dgl.Radio.action.ACTION_SHOW_TA");
        if (this.mContext != null) { mContext.sendBroadcast(intent); }
    }

    public void onEvent(int paramInt, String paramString) {
        // TODO: Complete
    }

}
