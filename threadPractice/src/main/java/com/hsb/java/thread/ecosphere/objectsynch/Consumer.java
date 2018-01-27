package com.hsb.java.thread.ecosphere.objectsynch;

import java.util.ArrayList;

public class Consumer implements Runnable{
    private final ArrayList<Object> list;

    public Consumer(ArrayList<Object> list) {
        this.list = list;
    }
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
    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.size() <= 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    list.remove(0);
                    System.out.println(Thread.currentThread().getName() + " 消费了一个对象 当前存量为：" +list.size());
                    list.notifyAll();
                }
            }
        }
    }
}
