#include "jni.h"
#include "com_hsb_jni_HelloWorld.h"

//#include otherheaders

JNIEXPORT void JNICALL
Java_com_hsb_jni_HelloWorld_displayHelloWorld(JNIEnv *env, jobject obj)
{
    printf("Helloworld!\n");
    return;
}