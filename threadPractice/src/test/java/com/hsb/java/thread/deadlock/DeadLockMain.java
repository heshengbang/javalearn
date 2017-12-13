package com.hsb.java.thread.deadlock;/*
 * Copyright ©2011-2016 hsb
 */

public class DeadLockMain {
    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        Thread1 thread1 = new Thread1(deadLock);
        Thread2 thread2 = new Thread2(deadLock);

        thread1.start();
        thread2.start();
    }
}
