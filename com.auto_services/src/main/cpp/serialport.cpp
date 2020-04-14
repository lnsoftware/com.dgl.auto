#include <jni.h>
#include <stdexcept>

// Stub library !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

extern "C"
JNIEXPORT jobject JNICALL Java_com_auto_serialport_SerialPort_open(JNIEnv *env, jclass clazz, jstring serial_port, jint baud_rate) {
    throw std::runtime_error("Stub!");
}

extern "C"
JNIEXPORT jint JNICALL Java_com_auto_serialport_SerialPort_BCWaitArm2Fin(JNIEnv *env, jobject thiz) {
    throw std::runtime_error("Stub!");
}

extern "C"
JNIEXPORT void JNICALL Java_com_auto_serialport_SerialPort_close(JNIEnv *env, jobject thiz) {
    throw std::runtime_error("Stub!");
}