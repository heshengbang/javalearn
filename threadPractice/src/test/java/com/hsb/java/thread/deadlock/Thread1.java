package com.hsb.java.thread.deadlock;/*
 * Copyright ©2011-2016 hsb
 */

public class Thread1 extends Thread {
    private DeadLock dl;

    Thread1(DeadLock dl) {
        this.dl = dl;
    }

    public void run() {
        try {
            dl.leftRight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
