package com.hsb.java.oom.request_array_size_exceed_vmlimit;/*
 * Copyright ©2011-2016 hsb
 */

public class TestMain {
    public static void main(String[] args) {
        for (int i = 100000; i >= 0; i--) {
            try {
                int[] arr = new int[Integer.MAX_VALUE-i];
                System.out.format("Successfully initialized an array with %,d elements.\n", Integer.MAX_VALUE-i);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
}
