package com.hsb.java.oom.metaspace;/*
 * Copyright ©2011-2016 hsb
 */
public class Metaspace {
    static javassist.ClassPool cp = javassist.ClassPool.getDefault();
    //with jvm options -XX:MaxMetaspaceSize=64m , when javassist generate 70000 classes,
    //Exception in thread "main" javassist.CannotCompileException: by java.lang.OutOfMemoryError: Metaspace will occur
    public static void main(String[] args) throws Exception{
        for (int i = 0; ; i++) {
            Class c = cp.makeClass("eu.plumbr.demo.Generated" + i).toClass();
        }
    }
}