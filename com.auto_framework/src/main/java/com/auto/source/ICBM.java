package com.auto.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface ICBM extends IInterface {
    // TODO: Complete
    public static abstract class Stub extends Binder implements ICBM {
        public IBinder asBinder() {
            return (IBinder)this;
        }
    }
}
