package com.auto.autoevent;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IAutoEvent extends IInterface {
    // TODO: Complete
    public static abstract class Stub extends Binder implements IAutoEvent {
        public IBinder asBinder() {
            return (IBinder)this;
        }
    }
}
