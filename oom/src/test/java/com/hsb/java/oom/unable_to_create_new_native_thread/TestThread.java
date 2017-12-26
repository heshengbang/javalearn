package com.hsb.java.oom.unable_to_create_new_native_thread;/*
 * Copyright ©2011-2016 hsb
 */

public class TestThread {
    public static void main(String[] args) {
        //jdk8 win7 amd64 8G when 210000 threads be created and stop it will occur
        // Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
        while(true){
            new Thread(new Runnable(){
                public void run() {
                    try {
                        Thread.sleep(10000000);
                    } catch(InterruptedException e) { }
                }
            }).start();
        }
    }
}
