package com.auto.opandora;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IOpandora extends IInterface {
    // TODO: Complete
    public static abstract class Stub extends Binder implements IOpandora {
        public IBinder asBinder() {
            return (IBinder)this;
        }
    }
}
