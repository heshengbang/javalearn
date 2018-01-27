package com.hsb.java.thread.ecosphere.objectsynch;

import java.util.ArrayList;

public class Producer implements Runnable{
    private final ArrayList<Object> list;

    public Producer(ArrayList<Object> list) {
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
                if (list.size() >= Constants.SIZE) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    list.add(new Object());
                    System.out.println(Thread.currentThread().getName() + " 生产了一个对象 当前存量为：" + list.size());
                    list.notifyAll();
                }
            }
        }
    }
}
