package com.hsb.java.thread;
        /*
         * Copyright ©2011-2017 hsb
         */

/**
 * 功能描述:&lt;/br&gt;
 * Copyright ©2011-2016 中国民航信息网络股份有限公司 &lt;/br&gt;
 *
 * @author hhu@travelsky.com 何虎
 * @version 1.0
 * @time 2018/1/16 13:52
 * ************************************************
 * @since
 */

public class MyRunnable implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        new Thread(new Runnable() {
            public void run() {
                for (int i =0 ;i < 100;i++) {
                    System.out.println("fuck you - "+i);
                }
            }
        }).start();
        for(int i = 0;i <100;i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
    public static void main(String[] args) {
        for(int i = 0;i < 100;i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==20) {
                MyRunnable myRunnable = new MyRunnable();
                new Thread(myRunnable,"新线程1").start();
                new Thread(myRunnable,"新线程2").start();
            }
        }
        new Thread(new Runnable() {
            public void run() {
                for (int i =0 ;i < 100;i++) {
                    System.out.println("fuck you - "+i);
                }
            }
        }).start();
    }
}
