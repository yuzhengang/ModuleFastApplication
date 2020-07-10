#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_modulefast_example_com_modulefastapplication_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
