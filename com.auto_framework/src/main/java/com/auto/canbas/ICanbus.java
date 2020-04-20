package com.auto.canbas;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface ICanbus extends IInterface {
    // TODO: Complete
    public static abstract class Stub extends Binder implements ICanbus {
        public IBinder asBinder() { return (IBinder)this; }
    }
}
