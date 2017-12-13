package com.hsb.java.thread.deadlock;/*
 * Copyright ©2011-2016 hsb
 */

public class DeadLock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() throws Exception {
        synchronized (left) {
            Thread.sleep(1000);
            synchronized (right) {
                System.out.println("leftRight end!");
            }
        }
    }

    public void rightLeft() throws Exception {
        synchronized (right) {
            Thread.sleep(1000);
            synchronized (left) {
                System.out.println("rightLeft end!");
            }
        }
    }
}
