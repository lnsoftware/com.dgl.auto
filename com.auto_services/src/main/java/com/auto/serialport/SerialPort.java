package com.auto.serialport;

import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class SerialPort {
    private static final String TAG = "SerialPort";
    private FileDescriptor mFd = null;
    private FileInputStream mFileInputStream = null;
    private FileOutputStream mFileOutputStream = null;

    static {
        System.loadLibrary("com/auto/serialport");
    }

    private static native FileDescriptor open(String serialPort, int baudRate);

    native int BCWaitArm2Fin();

    public native void close();

    public InputStream getInputStream() { return this.mFileInputStream; }

    public OutputStream getOutputStream() { return this.mFileOutputStream; }

    public boolean openSerialPort(File path, int baudRate)
    {
        mFd = open(path.getAbsolutePath(), baudRate);
        if (mFd == null) {
            Log.e(TAG, "native open returns null==>mFd:" + mFd + "\t devicepath:" + path.getAbsolutePath());
            return false;
        }

        mFileInputStream = new FileInputStream(mFd);
        mFileOutputStream = new FileOutputStream(mFd);
        return true;
    }
}
