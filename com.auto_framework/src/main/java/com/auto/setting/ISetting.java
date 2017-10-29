package com.auto.setting;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface ISetting extends IInterface {

    public abstract static class Stub extends Binder implements ISetting {

        private static final String DESCRIPTOR                      = "com.auto.setting.ISetting";

        static final int TRANSACTION_setEQ                          = 0x01;
        static final int TRANSACTION_setBalance                     = 0x02;
        static final int TRANSACTION_setFade                        = 0x03;
        static final int TRANSACTION_setLound                       = 0x04;
        static final int TRANSACTION_setSubwoofer                   = 0x05;
        static final int TRANSACTION_setSubFilterFreq               = 0x06;
        static final int TRANSACTION_setSubwooferPhase              = 0x07;
        static final int TRANSACTION_setBass                        = 0x08;
        static final int TRANSACTION_setMiddle                      = 0x09;
        static final int TRANSACTION_setTreble                      = 0x0a;
        static final int TRANSACTION_setBassFreq                    = 0x0b;
        static final int TRANSACTION_setMiddleFreq                  = 0x0c;
        static final int TRANSACTION_setTrebleFreq                  = 0x0d;
        static final int TRANSACTION_setBassQ                       = 0x0e;
        static final int TRANSACTION_setMiddleQ                     = 0x0f;
        static final int TRANSACTION_setTrebleQ                     = 0x10;
        static final int TRANSACTION_setBright                      = 0x11;
        static final int TRANSACTION_setContrast                    = 0x12;
        static final int TRANSACTION_setClockMode                   = 0x13;
        static final int TRANSACTION_setBeep                        = 0x14;
        static final int TRANSACTION_setIllumeDetection             = 0x15;
        static final int TRANSACTION_setReverseDetection            = 0x16;
        static final int TRANSACTION_setReverseImage                = 0x17;
        static final int TRANSACTION_setReverseGain                 = 0x18;
        static final int TRANSACTION_setRadioField                  = 0x19;
        static final int TRANSACTION_setNaviMode                    = 0x1a;
        static final int TRANSACTION_setClockHour                   = 0x1b;
        static final int TRANSACTION_setClockMinute                 = 0x1c;
        static final int TRANSACTION_setHueSetting                  = 0x1d;
        static final int TRANSACTION_setSaturation                  = 0x1e;
        static final int TRANSACTION_setReverseMirror               = 0x1f;
        static final int TRANSACTION_setReverseAuxLine              = 0x20;
        static final int TRANSACTION_setCarConfigLevel              = 0x21;
        static final int TRANSACTION_setBootTime                    = 0x22;
        static final int TRANSACTION_setMcuVol                      = 0x23;
        static final int TRANSACTION_setMcuMute                     = 0x24;
        static final int TRANSACTION_setTestMode                    = 0x25;
        static final int TRANSACTION_isMcuMute                      = 0x26;
        static final int TRANSACTION_queryMcuVersion                = 0x27;
        static final int TRANSACTION_getEQ                          = 0x28;
        static final int TRANSACTION_getBalance                     = 0x29;
        static final int TRANSACTION_getFade                        = 0x2a;
        static final int TRANSACTION_getLound                       = 0x2b;
        static final int TRANSACTION_getSubwoofer                   = 0x2c;
        static final int TRANSACTION_getSubFilterFreq               = 0x2d;
        static final int TRANSACTION_getSubwooferPhase              = 0x2e;
        static final int TRANSACTION_getBass                        = 0x2f;
        static final int TRANSACTION_getMiddle                      = 0x30;
        static final int TRANSACTION_getTreble                      = 0x31;
        static final int TRANSACTION_getBassFreq                    = 0x32;
        static final int TRANSACTION_getMiddleFreq                  = 0x33;
        static final int TRANSACTION_getTrebleFreq                  = 0x34;
        static final int TRANSACTION_getBassQ                       = 0x35;
        static final int TRANSACTION_getMiddleQ                     = 0x36;
        static final int TRANSACTION_getTrebleQ                     = 0x37;
        static final int TRANSACTION_getBright                      = 0x38;
        static final int TRANSACTION_getContrast                    = 0x39;
        static final int TRANSACTION_getClockMode                   = 0x3a;
        static final int TRANSACTION_getBeep                        = 0x3b;
        static final int TRANSACTION_getIllumeDetection             = 0x3c;
        static final int TRANSACTION_getReverseDetection            = 0x3d;
        static final int TRANSACTION_getReverseImage                = 0x3e;
        static final int TRANSACTION_getReverseGain                 = 0x3f;
        static final int TRANSACTION_getRadioField                  = 0x40;
        static final int TRANSACTION_getNaviMode                    = 0x41;
        static final int TRANSACTION_getClockHour                   = 0x42;
        static final int TRANSACTION_getClockMinute                 = 0x43;
        static final int TRANSACTION_getHueSetting                  = 0x44;
        static final int TRANSACTION_getSaturation                  = 0x45;
        static final int TRANSACTION_getReverseMirror               = 0x46;
        static final int TRANSACTION_getReverseAuxLine              = 0x47;
        static final int TRANSACTION_getCarConfigLevel              = 0x48;
        static final int TRANSACTION_getMcuVol                      = 0x49;
        static final int TRANSACTION_GetMcuVersion                  = 0x4a;
        static final int TRANSACTION_getBootTime                    = 0x4b;
        static final int TRANSACTION_setUSBTypeValue                = 0x4c;
        static final int TRANSACTION_setUSB0TypeValue               = 0x4d;
        static final int TRANSACTION_setUSB1TypeValue               = 0x4e;
        static final int TRANSACTION_setSWCTypeValue                = 0x4f;
        static final int TRANSACTION_setGPSVolumeMixValue           = 0x50;
        static final int TRANSACTION_setShortcutTouchState          = 0x51;
        static final int TRANSACTION_setCanWatchVideoWhileDriver    = 0x52;
        static final int TRANSACTION_setAutoRunNaviValue            = 0x53;
        static final int TRANSACTION_setNaviPackageName             = 0x54;
        static final int TRANSACTION_getSystemVersion               = 0x55;
        static final int TRANSACTION_getBTVersion                   = 0x56;
        static final int TRANSACTION_getCanVersion                  = 0x57;
        static final int TRANSACTION_getUSBTypeValue                = 0x58;
        static final int TRANSACTION_getUSB0TypeValue               = 0x59;
        static final int TRANSACTION_getUSB1TypeValue               = 0x5a;
        static final int TRANSACTION_getSWCTypeValue                = 0x5b;
        static final int TRANSACTION_getGPSVolumeMixValue           = 0x5c;
        static final int TRANSACTION_getShortcutTouchState          = 0x5d;
        static final int TRANSACTION_getCanWatchVideoWhileDriver    = 0x5e;
        static final int TRANSACTION_getCanWatchVideo               = 0x5f;
        static final int TRANSACTION_getAutoRunNaviValue            = 0x60;
        static final int TRANSACTION_getNaviPackageName             = 0x61;
        static final int TRANSACTION_isHCNAppFirstStartup           = 0x62;
        static final int TRANSACTION_getScreenBrightness            = 0x63;
        static final int TRANSACTION_setBrightness                  = 0x64;
        static final int TRANSACTION_SetSwitchMediaStatus           = 0x65;
        static final int TRANSACTION_GetSwitchMediaStatus           = 0x66;
        static final int TRANSACTION_removecallback                 = 0x67;
        static final int TRANSACTION_setcallback                    = 0x68;
        static final int TRANSACTION_getCarNumber                   = 0x69;
        static final int TRANSACTION_GetEmmcId                      = 0x6a;
        static final int TRANSACTION_setVolumeOffset                = 0x6b;
        static final int TRANSACTION_getVolumeOffset                = 0x6c;

        private static class Proxy implements ISetting {
            private IBinder mRemote;

            Proxy(IBinder remote) { mRemote = remote; }

            public IBinder asBinder() { return mRemote; }

            public String getInterfaceDescriptor() { return DESCRIPTOR; }

            public void setEQ(int eqMode) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(eqMode);
                    mRemote.transact(TRANSACTION_setEQ, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setBalance(int balance) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(balance);
                    mRemote.transact(TRANSACTION_setBalance, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setFade(int fade) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(fade);
                    mRemote.transact(TRANSACTION_setFade, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setLound(boolean bOn) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bOn ? 0x1 : 0x0);
                    mRemote.transact(TRANSACTION_setLound, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setSubwoofer(int nSubwoofer) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(nSubwoofer);
                    mRemote.transact(TRANSACTION_setSubwoofer, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setSubFilterFreq(int swf) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(swf);
                    mRemote.transact(TRANSACTION_setSubFilterFreq, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setSubwooferPhase(int phase) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(phase);
                    mRemote.transact(TRANSACTION_setSubwooferPhase, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setBass(int bass) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bass);
                    mRemote.transact(TRANSACTION_setBass, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setMiddle(int middle) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(middle);
                    mRemote.transact(TRANSACTION_setMiddle, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setTreble(int treble) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(treble);
                    mRemote.transact(TRANSACTION_setTreble, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setBassFreq(int bassFreq) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bassFreq);
                    mRemote.transact(TRANSACTION_setBassFreq, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setMiddleFreq(int midFreq) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(midFreq);
                    mRemote.transact(TRANSACTION_setMiddleFreq, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setTrebleFreq(int trebleFreq) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(trebleFreq);
                    mRemote.transact(TRANSACTION_setTrebleFreq, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setBassQ(int bassQ) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bassQ);
                    mRemote.transact(TRANSACTION_setBassQ, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setMiddleQ(int middleQ) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(middleQ);
                    mRemote.transact(TRANSACTION_setMiddleQ, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setTrebleQ(int trebleQ) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(trebleQ);
                    mRemote.transact(TRANSACTION_setTrebleQ , data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setBright(int bright) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bright);
                    mRemote.transact(TRANSACTION_setBright, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setContrast(int contrast) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(contrast);
                    mRemote.transact(TRANSACTION_setContrast , data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setClockMode(boolean b24) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(b24 ? 0x1 : 0x0);
                    mRemote.transact(TRANSACTION_setClockMode, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setBeep(boolean bBeepOn) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bBeepOn ? 0x1 : 0x0);
                    mRemote.transact(TRANSACTION_setBeep, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setIllumeDetection(boolean bIllumeDetOn) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bIllumeDetOn ? 0x1 : 0x0);
                    mRemote.transact(TRANSACTION_setIllumeDetection, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setReverseDetection(boolean bReverseDetOn) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bReverseDetOn ? 0x1 : 0x0);
                    mRemote.transact(TRANSACTION_setReverseDetection, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setReverseImage(boolean bReverseImage) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bReverseImage ? 0x1 : 0x0);
                    mRemote.transact(TRANSACTION_setReverseImage, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setReverseGain(boolean bReverseGain) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bReverseGain ? 0x1 : 0x0);
                    mRemote.transact(TRANSACTION_setReverseGain, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setRadioField(int field) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(field);
                    mRemote.transact(TRANSACTION_setRadioField, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setNaviMode(int mode) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(mode);
                    mRemote.transact(TRANSACTION_setNaviMode, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setClockHour(int hour) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(hour);
                    mRemote.transact(TRANSACTION_setClockHour, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setClockMinute(int min) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(min);
                    mRemote.transact(TRANSACTION_setClockMinute, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setHueSetting(int hue) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(hue);
                    mRemote.transact(TRANSACTION_setHueSetting, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setSaturation(int saturation) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(saturation);
                    mRemote.transact(TRANSACTION_setSaturation, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setReverseMirror(boolean bMirror) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bMirror ? 0x1 : 0x0);
                    mRemote.transact(TRANSACTION_setReverseMirror, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setReverseAuxLine(boolean bOn) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bOn ? 0x1 : 0x0);
                    mRemote.transact(TRANSACTION_setReverseAuxLine, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setCarConfigLevel(int level) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(level);
                    mRemote.transact(TRANSACTION_setCarConfigLevel, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setBootTime(int nBootTime) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(nBootTime);
                    mRemote.transact(TRANSACTION_setBootTime, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setMcuVol(int nVol) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(nVol);
                    mRemote.transact(TRANSACTION_setMcuVol, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setMcuMute(int nMute) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(nMute);
                    mRemote.transact(TRANSACTION_setMcuMute, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setTestMode(int testMode, int status, int enter) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(testMode);
                    data.writeInt(status);
                    data.writeInt(enter);
                    mRemote.transact(TRANSACTION_setTestMode, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean isMcuMute() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_isMcuMute, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void queryMcuVersion() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_queryMcuVersion , data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getEQ() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getEQ, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getBalance() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getBalance, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getFade() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getFade, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getLound() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getLound, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getSubwoofer() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getSubwoofer, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getSubFilterFreq() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getSubFilterFreq, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getSubwooferPhase() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getSubwooferPhase, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getBass() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getBass, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getMiddle() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getMiddle, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getTreble() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getTreble, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getBassFreq() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getBassFreq, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getMiddleFreq() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getMiddleFreq, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getTrebleFreq() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getTrebleFreq, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getBassQ() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getBassQ, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getMiddleQ() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getMiddleQ, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getTrebleQ() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getTrebleQ, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getBright() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getBright, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getContrast() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getContrast, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getClockMode() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getClockMode, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getBeep() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getBeep, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getIllumeDetection() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getIllumeDetection, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getReverseDetection() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getReverseDetection, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getReverseImage() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getReverseImage, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getReverseGain() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getReverseGain, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getRadioField() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getRadioField, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getNaviMode() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getNaviMode, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getClockHour() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getClockHour, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getClockMinute() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getClockMinute, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getHueSetting() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getHueSetting, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getSaturation() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getSaturation, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getReverseMirror() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getReverseMirror, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getReverseAuxLine() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getReverseAuxLine, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getCarConfigLevel() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getCarConfigLevel, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getMcuVol() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getMcuVol, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public String GetMcuVersion() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_GetMcuVersion, data, reply, 0x0);
                    reply.readException();
                    return reply.readString();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getBootTime() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getBootTime, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setUSBTypeValue(int nUSBType) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(nUSBType);
                    mRemote.transact(TRANSACTION_setUSBTypeValue, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setUSB0TypeValue(int nUSBType) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(nUSBType);
                    mRemote.transact(TRANSACTION_setUSB0TypeValue, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setUSB1TypeValue(int nUSBType) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(nUSBType);
                    mRemote.transact(TRANSACTION_setUSB1TypeValue, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setSWCTypeValue(int nSWCType) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(nSWCType);
                    mRemote.transact(TRANSACTION_setSWCTypeValue, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setGPSVolumeMixValue(float value) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeFloat(value);
                    mRemote.transact(TRANSACTION_setGPSVolumeMixValue, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setShortcutTouchState(boolean bValue) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bValue ? 0x1 : 0x0);
                    mRemote.transact(TRANSACTION_setShortcutTouchState, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setCanWatchVideoWhileDriver(boolean bValue) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bValue ? 0x1 : 0x0);
                    mRemote.transact(TRANSACTION_setCanWatchVideoWhileDriver, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setAutoRunNaviValue(boolean bValue) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bValue ? 0x1 : 0x0);
                    mRemote.transact(TRANSACTION_setAutoRunNaviValue, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setNaviPackageName(String value) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeString(value);
                    mRemote.transact(TRANSACTION_setNaviPackageName, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public String getSystemVersion() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getSystemVersion, data, reply, 0x0);
                    reply.readException();
                    return reply.readString();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public String getBTVersion() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getBTVersion, data, reply, 0x0);
                    reply.readException();
                    return reply.readString();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public String getCanVersion() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getCanVersion, data, reply, 0x0);
                    reply.readException();
                    return reply.readString();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getUSBTypeValue() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getUSBTypeValue, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getUSB0TypeValue() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getUSB0TypeValue, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getUSB1TypeValue() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getUSB1TypeValue, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getSWCTypeValue() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getSWCTypeValue, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public float getGPSVolumeMixValue() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getGPSVolumeMixValue, data, reply, 0x0);
                    reply.readException();
                    return reply.readFloat();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getShortcutTouchState() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getShortcutTouchState, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getCanWatchVideoWhileDriver() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getCanWatchVideoWhileDriver, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getCanWatchVideo() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getCanWatchVideo, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean getAutoRunNaviValue() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getAutoRunNaviValue, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public String getNaviPackageName() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getNaviPackageName, data, reply, 0x0);
                    reply.readException();
                    return reply.readString();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean isHCNAppFirstStartup() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_isHCNAppFirstStartup, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public int getScreenBrightness() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getScreenBrightness, data, reply, 0x0);
                    reply.readException();
                    return reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setBrightness(int brightness) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(brightness);
                    mRemote.transact(TRANSACTION_setBrightness, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void SetSwitchMediaStatus(boolean bValue) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(bValue ? 0x1 : 0x0);
                    mRemote.transact(TRANSACTION_SetSwitchMediaStatus, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public boolean GetSwitchMediaStatus() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_GetSwitchMediaStatus, data, reply, 0x0);
                    reply.readException();
                    return (reply.readInt() != 0);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void removecallback(ISettingCallback paramISettingCallback) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeStrongBinder(paramISettingCallback != null ? paramISettingCallback.asBinder() : null);
                    mRemote.transact(TRANSACTION_removecallback, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setcallback(ISettingCallback paramISettingCallback) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeStrongBinder(paramISettingCallback != null ? paramISettingCallback.asBinder() : null);
                    mRemote.transact(TRANSACTION_setcallback, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public String getCarNumber() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getCarNumber, data, reply, 0x0);
                    reply.readException();
                    return reply.readString();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public String GetEmmcId() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_GetEmmcId, data, reply, 0x0);
                    reply.readException();
                    return reply.readString();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public void setVolumeOffset(byte[] bBuff, int nLength) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeByteArray(bBuff);
                    data.writeInt(nLength);
                    mRemote.transact(TRANSACTION_setVolumeOffset, data, reply, 0x0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
            public byte[] getVolumeOffset() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(TRANSACTION_getVolumeOffset, data, reply, 0x0);
                    reply.readException();
                    return reply.createByteArray();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISetting asInterface(IBinder obj) {
            if (obj == null) return null;

            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if ((iin == null) || !(iin instanceof ISettingCallback)) {
                iin = new ISetting.Stub.Proxy(obj);
            }
            return (ISetting)iin;
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
                case TRANSACTION_setEQ: {
                    data.enforceInterface(DESCRIPTOR);
                    setEQ(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setBalance: {
                    data.enforceInterface(DESCRIPTOR);
                    setBalance(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setFade: {
                    data.enforceInterface(DESCRIPTOR);
                    setFade(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setLound: {
                    data.enforceInterface(DESCRIPTOR);
                    setLound(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setSubwoofer: {
                    data.enforceInterface(DESCRIPTOR);
                    setSubwoofer(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setSubFilterFreq: {
                    data.enforceInterface(DESCRIPTOR);
                    setSubFilterFreq(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setSubwooferPhase: {
                    data.enforceInterface(DESCRIPTOR);
                    setSubwooferPhase(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setBass: {
                    data.enforceInterface(DESCRIPTOR);
                    setBass(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setMiddle: {
                    data.enforceInterface(DESCRIPTOR);
                    setMiddle(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setTreble: {
                    data.enforceInterface(DESCRIPTOR);
                    setTreble(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setBassFreq: {
                    data.enforceInterface(DESCRIPTOR);
                    setBassFreq(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setMiddleFreq: {
                    data.enforceInterface(DESCRIPTOR);
                    setMiddleFreq(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setTrebleFreq: {
                    data.enforceInterface(DESCRIPTOR);
                    setTrebleFreq(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setBassQ: {
                    data.enforceInterface(DESCRIPTOR);
                    setBassQ(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setMiddleQ: {
                    data.enforceInterface(DESCRIPTOR);
                    setMiddleQ(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setTrebleQ: {
                    data.enforceInterface(DESCRIPTOR);
                    setTrebleQ(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setBright: {
                    data.enforceInterface(DESCRIPTOR);
                    setBright(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setContrast: {
                    data.enforceInterface(DESCRIPTOR);
                    setContrast(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setClockMode: {
                    data.enforceInterface(DESCRIPTOR);
                    setClockMode(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setBeep: {
                    data.enforceInterface(DESCRIPTOR);
                    setBeep(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setIllumeDetection: {
                    data.enforceInterface(DESCRIPTOR);
                    setIllumeDetection(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setReverseDetection: {
                    data.enforceInterface(DESCRIPTOR);
                    setReverseDetection(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setReverseImage: {
                    data.enforceInterface(DESCRIPTOR);
                    setReverseImage(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setReverseGain: {
                    data.enforceInterface(DESCRIPTOR);
                    setReverseGain(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setRadioField: {
                    data.enforceInterface(DESCRIPTOR);
                    setRadioField(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setNaviMode: {
                    data.enforceInterface(DESCRIPTOR);
                    setNaviMode(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setClockHour: {
                    data.enforceInterface(DESCRIPTOR);
                    setClockHour(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setClockMinute: {
                    data.enforceInterface(DESCRIPTOR);
                    setClockMinute(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setHueSetting: {
                    data.enforceInterface(DESCRIPTOR);
                    setHueSetting(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setSaturation: {
                    data.enforceInterface(DESCRIPTOR);
                    setSaturation(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setReverseMirror: {
                    data.enforceInterface(DESCRIPTOR);
                    setReverseMirror(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setReverseAuxLine: {
                    data.enforceInterface(DESCRIPTOR);
                    setReverseAuxLine(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setCarConfigLevel: {
                    data.enforceInterface(DESCRIPTOR);
                    setCarConfigLevel(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setBootTime: {
                    data.enforceInterface(DESCRIPTOR);
                    setBootTime(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setMcuVol: {
                    data.enforceInterface(DESCRIPTOR);
                    setMcuVol(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setMcuMute: {
                    data.enforceInterface(DESCRIPTOR);
                    setMcuMute(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setTestMode: {
                    data.enforceInterface(DESCRIPTOR);
                    setTestMode(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_isMcuMute: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(isMcuMute() ? 0x1 : 0x0);
                    return true;
                }
                case TRANSACTION_queryMcuVersion: {
                    data.enforceInterface(DESCRIPTOR);
                    queryMcuVersion();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getEQ: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getEQ());
                    return true;
                }
                case TRANSACTION_getBalance: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getBalance());
                    return true;
                }
                case TRANSACTION_getFade: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getFade());
                    return true;
                }
                case TRANSACTION_getLound: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getLound() ? 0x1 : 0x0);
                    return true;
                }
                case TRANSACTION_getSubwoofer: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getSubwoofer());
                    return true;
                }
                case TRANSACTION_getSubFilterFreq: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getSubFilterFreq());
                    return true;
                }
                case TRANSACTION_getSubwooferPhase: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getSubwooferPhase());
                    return true;
                }
                case TRANSACTION_getBass: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getBass());
                    return true;
                }
                case TRANSACTION_getMiddle: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getMiddle());
                    return true;
                }
                case TRANSACTION_getTreble: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getTreble());
                    return true;
                }
                case TRANSACTION_getBassFreq: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getBassFreq());
                    return true;
                }
                case TRANSACTION_getMiddleFreq: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getMiddleFreq());
                    return true;
                }
                case TRANSACTION_getTrebleFreq: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getTrebleFreq());
                    return true;
                }
                case TRANSACTION_getBassQ: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getBassQ());
                    return true;
                }
                case TRANSACTION_getMiddleQ: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getMiddleQ());
                    return true;
                }
                case TRANSACTION_getTrebleQ: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getTrebleQ());
                    return true;
                }
                case TRANSACTION_getBright: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getBright());
                    return true;
                }
                case TRANSACTION_getContrast: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getContrast());
                    return true;
                }
                case TRANSACTION_getClockMode: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getClockMode() ? 0x1 : 0x0);
                    return true;
                }
                case TRANSACTION_getBeep: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getBeep() ? 0x1 : 0x0);
                    return true;
                }
                case TRANSACTION_getIllumeDetection: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getIllumeDetection() ? 0x1 : 0x0);
                    return true;
                }
                case TRANSACTION_getReverseDetection: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getReverseDetection() ? 0x1 : 0x0);
                    return true;
                }
                case TRANSACTION_getReverseImage: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getReverseImage() ? 0x1 : 0x0);
                    return true;
                }
                case TRANSACTION_getReverseGain: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getReverseGain());
                    return true;
                }
                case TRANSACTION_getRadioField: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getRadioField());
                    return true;
                }
                case TRANSACTION_getNaviMode: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getNaviMode());
                    return true;
                }
                case TRANSACTION_getClockHour: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getClockHour());
                    return true;
                }
                case TRANSACTION_getClockMinute: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getClockMinute());
                    return true;
                }
                case TRANSACTION_getHueSetting: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getHueSetting());
                    return true;
                }
                case TRANSACTION_getSaturation: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getSaturation());
                    return true;
                }
                case TRANSACTION_getReverseMirror: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getReverseMirror() ? 0x1 : 0x0);
                    return true;
                }
                case TRANSACTION_getReverseAuxLine: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getReverseAuxLine() ? 0x1 : 0x0);
                    return true;
                }
                case TRANSACTION_getCarConfigLevel: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getCarConfigLevel());
                    return true;
                }
                case TRANSACTION_getMcuVol: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getMcuVol());
                    return true;
                }
                case TRANSACTION_GetMcuVersion: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeString(GetMcuVersion());
                    return true;
                }
                case TRANSACTION_getBootTime: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getBootTime());
                    return true;
                }
                case TRANSACTION_setUSBTypeValue: {
                    data.enforceInterface(DESCRIPTOR);
                    setUSBTypeValue(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setUSB0TypeValue: {
                    data.enforceInterface(DESCRIPTOR);
                    setUSB0TypeValue(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setUSB1TypeValue: {
                    data.enforceInterface(DESCRIPTOR);
                    setUSB1TypeValue(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setSWCTypeValue: {
                    data.enforceInterface(DESCRIPTOR);
                    setSWCTypeValue(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setGPSVolumeMixValue: {
                    data.enforceInterface(DESCRIPTOR);
                    setGPSVolumeMixValue(data.readFloat());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setShortcutTouchState: {
                    data.enforceInterface(DESCRIPTOR);
                    setShortcutTouchState(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setCanWatchVideoWhileDriver: {
                    data.enforceInterface(DESCRIPTOR);
                    setCanWatchVideoWhileDriver(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setAutoRunNaviValue: {
                    data.enforceInterface(DESCRIPTOR);
                    setAutoRunNaviValue(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setNaviPackageName: {
                    data.enforceInterface(DESCRIPTOR);
                    setNaviPackageName(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getSystemVersion: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeString(getSystemVersion());
                    return true;
                }
                case TRANSACTION_getBTVersion: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeString(getBTVersion());
                    return true;
                }
                case TRANSACTION_getCanVersion: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeString(getCanVersion());
                    return true;
                }
                case TRANSACTION_getUSBTypeValue: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getUSBTypeValue());
                    return true;
                }
                case TRANSACTION_getUSB0TypeValue: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getUSB0TypeValue());
                    return true;
                }
                case TRANSACTION_getUSB1TypeValue: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getUSB1TypeValue());
                    return true;
                }
                case TRANSACTION_getSWCTypeValue: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getSWCTypeValue());
                    return true;
                }
                case TRANSACTION_getGPSVolumeMixValue: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeFloat(getGPSVolumeMixValue());
                    return true;
                }
                case TRANSACTION_getShortcutTouchState: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getShortcutTouchState() ? 0x1 : 0x0);
                    return true;
                }
                case TRANSACTION_getCanWatchVideoWhileDriver: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getCanWatchVideoWhileDriver() ? 0x1 : 0x0);
                    return true;
                }
                case TRANSACTION_getCanWatchVideo: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getCanWatchVideo() ? 0x1 : 0x0);
                    return true;
                }
                case TRANSACTION_getAutoRunNaviValue: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getAutoRunNaviValue() ? 0x1 : 0x0);
                    return true;
                }
                case TRANSACTION_getNaviPackageName: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeString(getNaviPackageName());
                    return true;
                }
                case TRANSACTION_isHCNAppFirstStartup: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(isHCNAppFirstStartup() ? 0x1 : 0x0);
                    return true;
                }
                case TRANSACTION_getScreenBrightness: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(getScreenBrightness());
                    return true;
                }
                case TRANSACTION_setBrightness: {
                    data.enforceInterface(DESCRIPTOR);
                    setBrightness(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_SetSwitchMediaStatus: {
                    data.enforceInterface(DESCRIPTOR);
                    SetSwitchMediaStatus(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_GetSwitchMediaStatus: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeInt(GetSwitchMediaStatus() ? 0x1 : 0x0);
                    return true;
                }
                case TRANSACTION_removecallback: {
                    data.enforceInterface(DESCRIPTOR);
                    removecallback(ISettingCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setcallback: {
                    data.enforceInterface(DESCRIPTOR);
                    setcallback(ISettingCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getCarNumber: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeString(getCarNumber());
                    return true;
                }
                case TRANSACTION_GetEmmcId: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeString(GetEmmcId());
                    return true;
                }
                case TRANSACTION_setVolumeOffset: {
                    data.enforceInterface(DESCRIPTOR);
                    setVolumeOffset(data.createByteArray(),  data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getVolumeOffset: {
                    data.enforceInterface(DESCRIPTOR);
                    reply.writeNoException();
                    reply.writeByteArray(getVolumeOffset());
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }
    }

    public abstract String GetEmmcId() throws RemoteException;
    public abstract String GetMcuVersion() throws RemoteException;
    public abstract boolean GetSwitchMediaStatus() throws RemoteException;
    public abstract void SetSwitchMediaStatus(boolean bValue) throws RemoteException;
    public abstract boolean getAutoRunNaviValue() throws RemoteException;
    public abstract String getBTVersion() throws RemoteException;
    public abstract int getBalance() throws RemoteException;
    public abstract int getBass() throws RemoteException;
    public abstract int getBassFreq() throws RemoteException;
    public abstract int getBassQ() throws RemoteException;
    public abstract boolean getBeep() throws RemoteException;
    public abstract int getBootTime() throws RemoteException;
    public abstract int getBright() throws RemoteException;
    public abstract String getCanVersion() throws RemoteException;
    public abstract boolean getCanWatchVideo() throws RemoteException;
    public abstract boolean getCanWatchVideoWhileDriver() throws RemoteException;
    public abstract int getCarConfigLevel() throws RemoteException;
    public abstract String getCarNumber() throws RemoteException;
    public abstract int getClockHour() throws RemoteException;
    public abstract int getClockMinute() throws RemoteException;
    public abstract boolean getClockMode() throws RemoteException;
    public abstract int getContrast() throws RemoteException;
    public abstract int getEQ() throws RemoteException;
    public abstract int getFade() throws RemoteException;
    public abstract float getGPSVolumeMixValue() throws RemoteException;
    public abstract int getHueSetting() throws RemoteException;
    public abstract boolean getIllumeDetection() throws RemoteException;
    public abstract boolean getLound() throws RemoteException;
    public abstract int getMcuVol() throws RemoteException;
    public abstract int getMiddle() throws RemoteException;
    public abstract int getMiddleFreq() throws RemoteException;
    public abstract int getMiddleQ() throws RemoteException;
    public abstract int getNaviMode() throws RemoteException;
    public abstract String getNaviPackageName() throws RemoteException;
    public abstract int getRadioField() throws RemoteException;
    public abstract boolean getReverseAuxLine() throws RemoteException;
    public abstract boolean getReverseDetection() throws RemoteException;
    public abstract int getReverseGain() throws RemoteException;
    public abstract boolean getReverseImage() throws RemoteException;
    public abstract boolean getReverseMirror() throws RemoteException;
    public abstract int getSWCTypeValue() throws RemoteException;
    public abstract int getSaturation() throws RemoteException;
    public abstract int getScreenBrightness() throws RemoteException;
    public abstract boolean getShortcutTouchState() throws RemoteException;
    public abstract int getSubFilterFreq() throws RemoteException;
    public abstract int getSubwoofer() throws RemoteException;
    public abstract int getSubwooferPhase() throws RemoteException;
    public abstract String getSystemVersion() throws RemoteException;
    public abstract int getTreble() throws RemoteException;
    public abstract int getTrebleFreq() throws RemoteException;
    public abstract int getTrebleQ() throws RemoteException;
    public abstract int getUSB0TypeValue() throws RemoteException;
    public abstract int getUSB1TypeValue() throws RemoteException;
    public abstract int getUSBTypeValue() throws RemoteException;
    public abstract byte[] getVolumeOffset() throws RemoteException;
    public abstract boolean isHCNAppFirstStartup() throws RemoteException;
    public abstract boolean isMcuMute() throws RemoteException;
    public abstract void queryMcuVersion() throws RemoteException;
    public abstract void removecallback(ISettingCallback paramISettingCallback) throws RemoteException;
    public abstract void setAutoRunNaviValue(boolean bValue) throws RemoteException;
    public abstract void setBalance(int balance) throws RemoteException;
    public abstract void setBass(int bass) throws RemoteException;
    public abstract void setBassFreq(int bassFreq) throws RemoteException;
    public abstract void setBassQ(int bassQ) throws RemoteException;
    public abstract void setBeep(boolean bBeepOn) throws RemoteException;
    public abstract void setBootTime(int nBootTime) throws RemoteException;
    public abstract void setBright(int bright) throws RemoteException;
    public abstract void setBrightness(int brightness) throws RemoteException;
    public abstract void setCanWatchVideoWhileDriver(boolean bValue) throws RemoteException;
    public abstract void setCarConfigLevel(int level) throws RemoteException;
    public abstract void setClockHour(int hour) throws RemoteException;
    public abstract void setClockMinute(int min) throws RemoteException;
    public abstract void setClockMode(boolean b24) throws RemoteException;
    public abstract void setContrast(int contrast) throws RemoteException;
    public abstract void setEQ(int eqMode) throws RemoteException;
    public abstract void setFade(int fade) throws RemoteException;
    public abstract void setGPSVolumeMixValue(float value) throws RemoteException;
    public abstract void setHueSetting(int hue) throws RemoteException;
    public abstract void setIllumeDetection(boolean bIllumeDetOn) throws RemoteException;
    public abstract void setLound(boolean bOn) throws RemoteException;
    public abstract void setMcuMute(int nMute) throws RemoteException;
    public abstract void setMcuVol(int nVol) throws RemoteException;
    public abstract void setMiddle(int middle) throws RemoteException;
    public abstract void setMiddleFreq(int middleFreq) throws RemoteException;
    public abstract void setMiddleQ(int middleQ) throws RemoteException;
    public abstract void setNaviMode(int mode) throws RemoteException;
    public abstract void setNaviPackageName(String value) throws RemoteException;
    public abstract void setRadioField(int field) throws RemoteException;
    public abstract void setReverseAuxLine(boolean bOn) throws RemoteException;
    public abstract void setReverseDetection(boolean bReverseDetOn) throws RemoteException;
    public abstract void setReverseGain(boolean bReverseGain) throws RemoteException;
    public abstract void setReverseImage(boolean bReverseImage) throws RemoteException;
    public abstract void setReverseMirror(boolean bMirror) throws RemoteException;
    public abstract void setSWCTypeValue(int nSWCType) throws RemoteException;
    public abstract void setSaturation(int saturation) throws RemoteException;
    public abstract void setShortcutTouchState(boolean bValue) throws RemoteException;
    public abstract void setSubFilterFreq(int swf) throws RemoteException;
    public abstract void setSubwoofer(int nSubwoofer) throws RemoteException;
    public abstract void setSubwooferPhase(int phase) throws RemoteException;
    public abstract void setTestMode(int testMode, int status, int enter) throws RemoteException;
    public abstract void setTreble(int treble) throws RemoteException;
    public abstract void setTrebleFreq(int trebleFreq) throws RemoteException;
    public abstract void setTrebleQ(int trebleQ) throws RemoteException;
    public abstract void setUSB0TypeValue(int nUSBType) throws RemoteException;
    public abstract void setUSB1TypeValue(int nUSBType) throws RemoteException;
    public abstract void setUSBTypeValue(int nUSBType) throws RemoteException;
    public abstract void setVolumeOffset(byte[] bBuff, int nLength) throws RemoteException;
    public abstract void setcallback(ISettingCallback paramISettingCallback) throws RemoteException;
}
