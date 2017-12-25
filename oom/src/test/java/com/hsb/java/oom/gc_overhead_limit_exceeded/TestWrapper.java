package com.hsb.java.oom.gc_overhead_limit_exceeded;/*
 * Copyright ©2011-2016 hsb
 */
import java.util.Map;
import java.util.Random;
public class TestWrapper {
    //配置JVM参数:   ‐Xmx12m 。执行时产生的错误信息 Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
    //配置JVM参数:   ‐Xmx10m 。执行时产生的错误信息 Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    public static void main(String args[]) {
        Map map = System.getProperties();
        Random r = new Random();
        while (true) {
            map.put(r.nextInt(), "value");
        }
    }
}
