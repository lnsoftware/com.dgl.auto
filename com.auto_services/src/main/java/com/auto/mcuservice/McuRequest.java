package com.auto.mcuservice;

import com.auto.constant.McuConstant;

public class McuRequest implements McuConstant.PacketExtraMsg {
    private static final int MAX_POOL_SIZE = 8;

    private static McuRequest sPool = null;
    private static Object sPoolLock = new Object();
    private static int sPoolSize = 0;

    byte mCmd;
    byte mHeader;
    byte mHiCRCByte;
    byte mLoCRCByte;
    byte mLength;
    byte[] mParam = new byte[MAX_TX_COMMAND_LENGTH];
    byte mSync;
    byte mTransactionId;

    McuRequest mNext;

    static McuRequest obtain(byte transactionId, byte cmd, byte dataLength, byte[] data) {
        synchronized (sPoolLock) {
            McuRequest mcuRequest = new McuRequest();
            mcuRequest.set(transactionId, cmd, dataLength, data);
            return mcuRequest;
        }
    }

    void release() {
        synchronized (sPoolLock) { }
    }

    void set(byte transactionId, byte cmd, byte dataLength, byte[] data) {
        mSync = (byte)SYNC;
        mHeader = (byte)HEADER;
        mTransactionId = transactionId;
        mCmd = cmd;
        mLength = (byte)(dataLength + 1);
        if (dataLength != 0)
            System.arraycopy(data, 0, mParam, 0, dataLength);
        byte[] tmpBuf = new byte[mLength + 1];
        tmpBuf[0] = mLength;
        tmpBuf[1] = mCmd;
        if (dataLength != 0)
            System.arraycopy(data, 0, tmpBuf, 2, dataLength);
        char crc = Utility.CalculateCRC(tmpBuf, mLength + 1);
        mHiCRCByte = Utility.HiByte(crc);
        mLoCRCByte = Utility.LoByte(crc);
    }
}
