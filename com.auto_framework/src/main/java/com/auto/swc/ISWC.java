package com.auto.swc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface ISWC extends IInterface {
    // TODO: Complete
    public static abstract class Stub extends Binder implements ISWC {
        public IBinder asBinder() {
            return (IBinder)this;
        }
    }
}
