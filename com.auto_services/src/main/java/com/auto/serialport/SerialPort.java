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

    static  {
        System.loadLibrary("serialport");
    }

    private static native FileDescriptor open(String p1, int p2);

    native int BCWaitArm2Fin();

    public native void close();

    public InputStream getInputStream() { return this.mFileInputStream; }

    public OutputStream getOutputStream() { return this.mFileOutputStream; }

    public boolean openSerialPort(File paramFile, int paramInt)
    {
        this.mFd = open(paramFile.getAbsolutePath(), paramInt);
        if (this.mFd == null) {
            Log.e(TAG, "native open returns null==>mFd:" + this.mFd + "\t devicepath:" + paramFile.getAbsolutePath());
            return false;
        }

        this.mFileInputStream = new FileInputStream(this.mFd);
        this.mFileOutputStream = new FileOutputStream(this.mFd);
        return true;
    }
}
