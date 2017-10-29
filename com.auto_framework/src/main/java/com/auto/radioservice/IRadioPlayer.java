package com.auto.radioservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IRadioPlayer extends IInterface {

    public abstract static class Stub extends Binder implements IRadioPlayer {

        private static final String DESCRIPTOR              = "com.auto.radioservice.IRadioPlayer";

        static final int TRANSACTION_loadFreq               = 1;
        static final int TRANSACTION_saveFreq               = 2;
        static final int TRANSACTION_DX_LOC                 = 3;
        static final int TRANSACTION_PS                     = 4;
        static final int TRANSACTION_AS                     = 5;
        static final int TRANSACTION_manulDown              = 7;
        static final int TRANSACTION_scan                   = 6;
        static final int TRANSACTION_manulUp                = 8;
        static final int TRANSACTION_seekDown               = 9;
        static final int TRANSACTION_seekUp                 = 10;
        static final int TRANSACTION_band                   = 11;
        static final int TRANSACTION_setFreq                = 12;
        static final int TRANSACTION_queryRadioRange        = 13;
        static final int TRANSACTION_queryRadioInfo         = 14;
        static final int TRANSACTION_queryRadioFreqsList    = 15;
        static final int TRANSACTION_getCurrFreq            = 16;
        static final int TRANSACTION_getBand                = 17;
        static final int TRANSACTION_getPresetIndex         = 18;
        static final int TRANSACTION_getASStatus            = 19;
        static final int TRANSACTION_getPSStatus            = 20;
        static final int TRANSACTION_getScanSatus           = 21;
        static final int TRANSACTION_getSeekStatus          = 22;
        static final int TRANSACTION_getStMonoStatus        = 23;
        static final int TRANSACTION_getLocalDx             = 24;
        static final int TRANSACTION_getFreqList            = 25;
        static final int TRANSACTION_getMinFMFreq           = 26;
        static final int TRANSACTION_getMaxFMFreq           = 27;
        static final int TRANSACTION_getMinAMFreq           = 28;
        static final int TRANSACTION_getMaxAMFreq           = 29;
        static final int TRANSACTION_getFMStep              = 30;
        static final int TRANSACTION_getAMStep              = 31;
        static final int TRANSACTION_queryRdsInfo           = 32;
        static final int TRANSACTION_setPtyType             = 33;
        static final int TRANSACTION_turnREGMode            = 34;
        static final int TRANSACTION_turnAFMode             = 35;
        static final int TRANSACTION_turnTAMode             = 36;
        static final int TRANSACTION_turnEONMode            = 37;
        static final int TRANSACTION_getRdsSeting           = 38;
        static final int TRANSACTION_getRdsInfo             = 39;
        static final int TRANSACTION_getRDSPtyType          = 40;
        static final int TRANSACTION_getRDSArm2McuPtyType   = 41;
        static final int TRANSACTION_getRDSCT_Hour          = 42;
        static final int TRANSACTION_getRDSCT_Minute        = 43;
        static final int TRANSACTION_getRDSRDSPS            = 44;
        static final int TRANSACTION_getRDSRDSRT            = 45;
        static final int TRANSACTION_removecallback         = 46;
        static final int TRANSACTION_setcallback            = 47;

        private static class Proxy implements IRadioPlayer {
            private IBinder mRemote;

            Proxy(IBinder remote) { mRemote = remote; }

            public IBinder asBinder() { return mRemote; }

            public String getInterfaceDescriptor() { return DESCRIPTOR; }

            public void AS() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_AS, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void DX_LOC() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_DX_LOC, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void PS() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_PS, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void band() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_band, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getAMStep() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getAMStep, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getASStatus() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getASStatus, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getBand() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getBand, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getCurrFreq() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getCurrFreq, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getFMStep() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getFMStep, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public char[] getFreqList() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getFreqList, data, reply, 0x0);
                    reply.readException();
                    return reply.createCharArray();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getLocalDx() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getLocalDx, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getMaxAMFreq() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getMaxAMFreq, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getMaxFMFreq() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getMaxFMFreq, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getMinAMFreq() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getMinAMFreq, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getMinFMFreq() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getMinFMFreq, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getPSStatus() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getPSStatus, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getPresetIndex() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getPresetIndex, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getRDSArm2McuPtyType() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getRDSArm2McuPtyType, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getRDSCT_Hour() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getRDSCT_Hour, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getRDSCT_Minute() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getRDSCT_Minute, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getRDSPtyType() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getRDSPtyType, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public char[] getRDSRDSPS() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getRDSRDSPS, data, reply, 0x0);
                    reply.readException();
                    return reply.createCharArray();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public char[] getRDSRDSRT() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getRDSRDSRT, data, reply, 0x0);
                    reply.readException();
                    return reply.createCharArray();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getRdsInfo() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getRdsInfo, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getRdsSeting() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getRdsSeting, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getScanSatus() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getScanSatus, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt() != 0;
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getSeekStatus() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getSeekStatus, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt() != 0;
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getStMonoStatus() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getStMonoStatus, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt() != 0;
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void loadFreq(int nBroadcastID) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(nBroadcastID);
                    mRemote.transact(TRANSACTION_loadFreq, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void manulDown() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_manulDown, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void manulUp() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_manulUp, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void queryRadioFreqsList() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_queryRadioFreqsList, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void queryRadioInfo() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_queryRadioInfo, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void queryRadioRange() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_queryRadioRange, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void queryRdsInfo() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_queryRdsInfo, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void removecallback(IRadioCallback radioCallback) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeStrongBinder(radioCallback != null ? radioCallback.asBinder() : null);
                    mRemote.transact(TRANSACTION_removecallback, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void saveFreq(int nBroadcastID) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(nBroadcastID);
                    mRemote.transact(TRANSACTION_saveFreq, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void scan() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_scan, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void seekDown() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_seekDown, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void seekUp() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_seekUp, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setFreq(char wLegalFreq) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(wLegalFreq);
                    mRemote.transact(TRANSACTION_setFreq, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setPtyType(byte nPtyType) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeByte(nPtyType);
                    mRemote.transact(TRANSACTION_setPtyType, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setcallback(IRadioCallback radioCallback) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeStrongBinder(radioCallback != null ? radioCallback.asBinder() : null);
                    mRemote.transact(TRANSACTION_setcallback, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void turnAFMode(boolean bTurnOn) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bTurnOn ? 1 : 0);
                    mRemote.transact(TRANSACTION_turnAFMode, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void turnEONMode(boolean bTurnOn) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bTurnOn ? 1 : 0);
                    mRemote.transact(TRANSACTION_turnEONMode, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void turnREGMode(boolean bTurnOn) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bTurnOn ? 1 : 0);
                    mRemote.transact(TRANSACTION_turnREGMode, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void turnTAMode(boolean bTurnOn) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bTurnOn ? 1 : 0);
                    mRemote.transact(TRANSACTION_turnTAMode, data, reply, 0x0);
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

        public static IRadioPlayer asInterface(IBinder obj) {
            if (obj == null) return null;

            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if ((iin == null) || !(iin instanceof IRadioCallback)) {
                iin = new IRadioPlayer.Stub.Proxy(obj);
            }
            return (IRadioPlayer)iin;
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
                case TRANSACTION_loadFreq: {
                    data.enforceInterface(DESCRIPTOR);
                    loadFreq(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_saveFreq: {
                    data.enforceInterface(DESCRIPTOR);
                    saveFreq(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_DX_LOC: {
                    data.enforceInterface(DESCRIPTOR);
                    DX_LOC();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_PS: {
                    data.enforceInterface(DESCRIPTOR);
                    PS();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_AS: {
                    data.enforceInterface(DESCRIPTOR);
                    AS();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_scan: {
                    data.enforceInterface(DESCRIPTOR);
                    scan();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_manulDown: {
                    data.enforceInterface(DESCRIPTOR);
                    manulDown();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_manulUp: {
                    data.enforceInterface(DESCRIPTOR);
                    manulUp();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_seekDown: {
                    data.enforceInterface(DESCRIPTOR);
                    seekDown();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_seekUp: {
                    data.enforceInterface(DESCRIPTOR);
                    seekUp();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_band: {
                    data.enforceInterface(DESCRIPTOR);
                    band();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setFreq: {
                    data.enforceInterface(DESCRIPTOR);
                    setFreq((char)data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_queryRadioRange: {
                    data.enforceInterface(DESCRIPTOR);
                    queryRadioRange();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_queryRadioInfo: {
                    data.enforceInterface(DESCRIPTOR);
                    queryRadioInfo();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_queryRadioFreqsList: {
                    data.enforceInterface(DESCRIPTOR);
                    queryRadioFreqsList();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getCurrFreq: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getCurrFreq());
                    return true;
                }
                case TRANSACTION_getBand: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getBand());
                    return true;
                }
                case TRANSACTION_getPresetIndex: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getPresetIndex());
                    return true;
                }
                case TRANSACTION_getASStatus: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getASStatus() ? 1 : 0);
                    return true;
                }
                case TRANSACTION_getPSStatus: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getPSStatus() ? 1 : 0);
                    return true;
                }
                case TRANSACTION_getScanSatus: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getScanSatus() ? 1 : 0);
                    return true;
                }
                case TRANSACTION_getSeekStatus: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getSeekStatus() ? 1 : 0);
                    return true;
                }
                case TRANSACTION_getStMonoStatus: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getStMonoStatus() ? 1 : 0);
                    return true;
                }
                case TRANSACTION_getLocalDx: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getLocalDx() ? 1 : 0);
                    return true;
                }
                case TRANSACTION_getFreqList: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeCharArray(getFreqList());
                    return true;
                }
                case TRANSACTION_getMinFMFreq: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getMinFMFreq());
                    return true;
                }
                case TRANSACTION_getMaxFMFreq: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getMaxFMFreq());
                    return true;
                }
                case TRANSACTION_getMinAMFreq: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getMinAMFreq());
                    return true;
                }
                case TRANSACTION_getMaxAMFreq: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getMaxAMFreq());
                    return true;
                }
                case TRANSACTION_getFMStep: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getFMStep());
                    return true;
                }
                case TRANSACTION_getAMStep: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getAMStep());
                    return true;
                }
                case TRANSACTION_queryRdsInfo: {
                    data.enforceInterface(DESCRIPTOR);
                    queryRdsInfo();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setPtyType: {
                    data.enforceInterface(DESCRIPTOR);
                    setPtyType(data.readByte());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_turnREGMode: {
                    data.enforceInterface(DESCRIPTOR);
                    turnREGMode(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_turnAFMode: {
                    data.enforceInterface(DESCRIPTOR);
                    turnAFMode(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_turnTAMode: {
                    data.enforceInterface(DESCRIPTOR);
                    turnTAMode(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_turnEONMode: {
                    data.enforceInterface(DESCRIPTOR);
                    turnEONMode(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getRdsSeting: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getRdsSeting());
                    return true;
                }
                case TRANSACTION_getRdsInfo: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getRdsInfo());
                    return true;
                }
                case TRANSACTION_getRDSPtyType: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getRDSPtyType());
                    return true;
                }
                case TRANSACTION_getRDSArm2McuPtyType: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getRDSArm2McuPtyType());
                    return true;
                }
                case TRANSACTION_getRDSCT_Hour: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getRDSCT_Hour());
                    return true;
                }
                case TRANSACTION_getRDSCT_Minute: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getRDSCT_Minute());
                    return true;
                }
                case TRANSACTION_getRDSRDSPS: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeCharArray(getRDSRDSPS());
                    return true;
                }
                case TRANSACTION_getRDSRDSRT: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeCharArray(getRDSRDSRT());
                    return true;
                }
                case TRANSACTION_removecallback: {
                    data.enforceInterface(DESCRIPTOR);
                    removecallback(IRadioCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setcallback: {
                    data.enforceInterface(DESCRIPTOR);
                    setcallback(IRadioCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }
    }

    void AS() throws RemoteException;
    void DX_LOC() throws RemoteException;
    void PS() throws RemoteException;
    void band() throws RemoteException;
    int getAMStep() throws RemoteException;
    boolean getASStatus() throws RemoteException;
    int getBand() throws RemoteException;
    int getCurrFreq() throws RemoteException;
    int getFMStep() throws RemoteException;
    char[] getFreqList() throws RemoteException;
    boolean getLocalDx() throws RemoteException;
    int getMaxAMFreq() throws RemoteException;
    int getMaxFMFreq() throws RemoteException;
    int getMinAMFreq() throws RemoteException;
    int getMinFMFreq() throws RemoteException;
    boolean getPSStatus() throws RemoteException;
    int getPresetIndex() throws RemoteException;
    int getRDSArm2McuPtyType() throws RemoteException;
    int getRDSCT_Hour() throws RemoteException;
    int getRDSCT_Minute() throws RemoteException;
    int getRDSPtyType() throws RemoteException;
    char[] getRDSRDSPS() throws RemoteException;
    char[] getRDSRDSRT() throws RemoteException;
    int getRdsInfo() throws RemoteException;
    int getRdsSeting() throws RemoteException;
    boolean getScanSatus() throws RemoteException;
    boolean getSeekStatus() throws RemoteException;
    boolean getStMonoStatus() throws RemoteException;
    void loadFreq(int nBroadcastID) throws RemoteException;
    void manulDown() throws RemoteException;
    void manulUp() throws RemoteException;
    void queryRadioFreqsList() throws RemoteException;
    void queryRadioInfo() throws RemoteException;
    void queryRadioRange() throws RemoteException;
    void queryRdsInfo() throws RemoteException;
    void removecallback(IRadioCallback radioCallback) throws RemoteException;
    void saveFreq(int nBroadcastID) throws RemoteException;
    void scan() throws RemoteException;
    void seekDown() throws RemoteException;
    void seekUp() throws RemoteException;
    void setFreq(char wLegalFreq) throws RemoteException;
    void setPtyType(byte nPtyType) throws RemoteException;
    void setcallback(IRadioCallback radioCallback) throws RemoteException;
    void turnAFMode(boolean bTurnOn) throws RemoteException;
    void turnEONMode(boolean bTurnOn) throws RemoteException;
    void turnREGMode(boolean bTurnOn) throws RemoteException;
    void turnTAMode(boolean bTurnOn) throws RemoteException;
}
