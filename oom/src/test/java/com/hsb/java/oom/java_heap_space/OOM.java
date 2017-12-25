package com.hsb.java.oom.java_heap_space;/*
 * Copyright ©2011-2016 hsb
 */

/*
* modified vm options to -Xmx12m, oom will occur.
* modified VM options to -Xmx13m, oom will disappear.
* */
public class OOM {
    static final int SIZE=2*1024*1024;
    public static void main(String[] a) {
        //int size is 32
        int[] i = new int[SIZE];
    }
}
