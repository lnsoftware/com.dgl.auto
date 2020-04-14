package com.auto.mcuservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IMcuManager extends IInterface {

    public static abstract class Stub extends Binder implements IMcuManager {
        private static final String DESCRIPTOR =    "com.auto.mcuservice.IMcuManager";
        static final int TRANSACTION_SndCmd1 =      1;
        static final int TRANSACTION_SndCmd2 =      2;
        static final int TRANSACTION_SndCmd3 =      3;
        static final int TRANSACTION_SndCmd4 =      4;

        private static class Proxy implements IMcuManager {
            private IBinder mRemote;

            Proxy(IBinder remote) { mRemote = remote; }

            public IBinder asBinder() { return mRemote; }

            public String getInterfaceDescriptor() { return DESCRIPTOR; }

            public void SndCmd1(int cmd) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(cmd);
                    mRemote.transact(TRANSACTION_SndCmd1, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void SndCmd2(int cmd, int param) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(cmd);
                    data.writeInt(param);
                    mRemote.transact(TRANSACTION_SndCmd2, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void SndCmd3(int cmd, int param1, int param2) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(cmd);
                    data.writeInt(param1);
                    data.writeInt(param2);
                    mRemote.transact(TRANSACTION_SndCmd3, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void SndCmd4(int cmd, byte[] bBuff, int nLength) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(cmd);
                    data.writeByteArray(bBuff);
                    data.writeInt(nLength);
                    mRemote.transact(TRANSACTION_SndCmd4, data, reply, 0x0);
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

        public static IMcuManager asInterface(IBinder obj) {
            if (obj == null) return null;

            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if ((iin == null) || !(iin instanceof IMcuManager)) {
                iin = new IMcuManager.Stub.Proxy(obj);
            }
            return (IMcuManager)iin;
        }

        public IBinder asBinder() {
            return (IBinder)this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_SndCmd1: {
                    data.enforceInterface(DESCRIPTOR);
                    SndCmd1(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_SndCmd2: {
                    data.enforceInterface(DESCRIPTOR);
                    SndCmd2(data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_SndCmd3: {
                    data.enforceInterface(DESCRIPTOR);
                    SndCmd3(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_SndCmd4: {
                    data.enforceInterface(DESCRIPTOR);
                    SndCmd4(data.readInt(), data.createByteArray(), data.readInt());
                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }
    }

    void SndCmd1(int cmd) throws RemoteException;
    void SndCmd2(int cmd, int param) throws RemoteException;
    void SndCmd3(int cmd, int param1, int param2) throws RemoteException;
    void SndCmd4(int cmd, byte[] bBuff, int nLength) throws RemoteException;
}
