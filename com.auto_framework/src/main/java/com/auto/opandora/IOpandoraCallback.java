package com.auto.opandora;

import android.os.IInterface;
import android.os.RemoteException;

public interface IOpandoraCallback extends IInterface {
    void onEvent(int paramInt, String paramString) throws RemoteException;
}
