package com.auto.mcuservice;

import android.content.Context;

public class SourceEvent {
    private Context mContext;

    public SourceEvent(Context context) {
        mContext = context;
    }

    public void onMessage(McuService.McuPacket mcuPacket) {
        return;
    }
}
