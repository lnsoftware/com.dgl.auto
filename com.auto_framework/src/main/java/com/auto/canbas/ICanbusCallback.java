package com.auto.canbas;

import android.os.IInterface;
import android.os.RemoteException;

public interface ICanbusCallback extends IInterface {
    // TODO: Complete
    void onEvent(int paramInt1, byte[] paramArrayOfbyte, int paramInt2) throws RemoteException;
}
