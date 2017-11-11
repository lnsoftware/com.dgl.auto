#include <jni.h>
#include <stdexcept>

extern "C"
JNIEXPORT jstring

// Stub library !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

JNICALL
Java_com_auto_serialport_SerialPort_open(jstring p1, int p2) {
    throw std::runtime_error("Stub!");
}

int Java_com_auto_serialport_SerialPort_BCWaitArm2Fin() {
    throw std::runtime_error("Stub!");
}

void Java_com_auto_serialport_SerialPort_close() {
    throw std::runtime_error("Stub!");
}