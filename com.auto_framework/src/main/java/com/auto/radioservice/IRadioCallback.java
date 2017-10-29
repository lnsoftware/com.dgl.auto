package com.auto.radioservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IRadioCallback extends IInterface {

    public abstract static class Stub extends Binder implements IRadioCallback {

        private static final String DESCRIPTOR  = "com.auto.radioservice.IRadioCallback";
        static final int TRANSACTION_onEvent    = 0x01;

        private static class Proxy implements IRadioCallback {

            private IBinder mRemote;

            Proxy(final IBinder remote) {
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
                    mRemote.transact(TRANSACTION_onEvent, data, reply, 0x00);
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

        public static IRadioCallback asInterface(IBinder obj) {
            if (obj == null) return null;

            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if ((iin == null) || !(iin instanceof IRadioCallback)) {
                iin = new IRadioCallback.Stub.Proxy(obj);
            }
            return (IRadioCallback)iin;
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
