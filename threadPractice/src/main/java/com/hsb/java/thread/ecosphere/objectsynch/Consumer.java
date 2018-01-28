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
        // simple way but fool way for solve produce-consume question.
//        while (true) {
//            synchronized (list) {
//                System.out.println(Thread.currentThread().getName() + " 获得执行权");
//                if (list.size() > 0) {
//                    System.out.println(Thread.currentThread().getName() + " 存量足够，准备消费操作");
//                    list.remove(0);
//                    System.out.println(Thread.currentThread().getName() + " 消费了一个对象 当前存量为：" + list.size());
//                } else {
//                    System.out.println(Thread.currentThread().getName() + " 存量不够，无法消费，当前存量为：" + list.size());
//                }
//            }
//        }
        synchronized (list) {
            System.out.println(Thread.currentThread().getName() + " 获得执行权");
            while (true) {
                try {
                    if (list.size() <= 0) {
                        System.out.println(Thread.currentThread().getName() + " 存量不够，将进入等待");
                        list.wait();
                        System.out.println(Thread.currentThread().getName() + " 等待结束，重新开始运行");
                    } else {
                        System.out.println(Thread.currentThread().getName() + " 存量足够，准备进入消费");
                        list.remove(0);
                        System.out.println(Thread.currentThread().getName() + " 消费了一个对象 当前存量为：" + list.size());
                        list.notifyAll();
                        System.out.println(Thread.currentThread().getName() + " 唤醒在对象上等待的线程并准备进入等待");
                        list.wait();
                        System.out.println(Thread.currentThread().getName() + " 等待结束，重新开始运行");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
