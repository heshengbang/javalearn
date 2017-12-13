package com.hsb.java.thread.deadlock;/*
 * Copyright ©2011-2016 hsb
 */

public class Thread2 extends Thread {
    private DeadLock dl;

    Thread2(DeadLock dl) {
        this.dl = dl;
    }

    public void run() {
        try {
            dl.rightLeft();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
