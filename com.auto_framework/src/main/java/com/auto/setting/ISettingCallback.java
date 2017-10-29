package com.auto.setting;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface ISettingCallback extends IInterface {

    public abstract static class Stub extends Binder implements ISettingCallback {

        private static final String DESCRIPTOR  = "com.auto.setting.ISettingCallback";
        static final int TRANSACTION_onEvent    = 0x01;

        private static class Proxy implements ISettingCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                mRemote = remote;
            }

            @Override
            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            public void onEvent(int paramInt, String paramString) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(paramInt);
                    data.writeString(paramString);
                    mRemote.transact(TRANSACTION_onEvent, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISettingCallback asInterface(IBinder obj) {
            if (obj == null) return null;

            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if ((iin == null) || !(iin instanceof ISettingCallback)) {
                iin = new ISettingCallback.Stub.Proxy(obj);
            }
            return (ISettingCallback)iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_onEvent: {
                    data.enforceInterface(DESCRIPTOR);
                    onEvent(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }
    }

    public abstract void onEvent(int paramInt, String paramString) throws RemoteException;
}
