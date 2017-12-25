package com.hsb.java.oom.permgen_space;/*
 * Copyright ©2011-2016 hsb
 */

import javassist.ClassPool;

public class MicroGenerator {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100000000; i++) {
            generate("eu.plumbr.demo.Generated" + i);
        }
    }

    public static Class generate(String name) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        return pool.makeClass(name).toClass();
    }
}
