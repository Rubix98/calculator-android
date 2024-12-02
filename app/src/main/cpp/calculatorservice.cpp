#include <jni.h>

extern "C"
JNIEXPORT jint JNICALL
Java_pl_marcinwojdat_calculatorapplication_CalculatorService_calculate(JNIEnv *env, jobject thiz, jstring arg) {
    return 11;
}