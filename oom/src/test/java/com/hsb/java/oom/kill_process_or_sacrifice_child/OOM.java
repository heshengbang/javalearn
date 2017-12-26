package com.hsb.java.oom.kill_process_or_sacrifice_child;/*
 * Copyright ©2011-2016 hsb
 */

public class OOM {

    public static void main(String[] args){
        java.util.List<int[]> l = new java.util.ArrayList();
        for (int i = 10000; i < 100000; i++) {
            try {
                l.add(new int[100_000_000]);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
}
