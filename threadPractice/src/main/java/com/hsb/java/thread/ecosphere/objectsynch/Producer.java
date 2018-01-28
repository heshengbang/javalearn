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
            // simple way but fool way for solve produce-consume question.
//            synchronized (list) {
//                System.out.println(Thread.currentThread().getName() + " 获得执行权");
//                if (list.size() < Constants.SIZE) {
//                    System.out.println(Thread.currentThread().getName() + " 空间足够，准备生产操作");
//                    list.add(new Object());
//                    System.out.println(Thread.currentThread().getName() + " 生产了一个对象 当前存量为：" + list.size());
//                } else {
//                    System.out.println(Thread.currentThread().getName() + " 空间不够，无法生产，当前存量为" + list.size());
//                }
//            }
//        }
            synchronized (list) {
                System.out.println(Thread.currentThread().getName() + " 获得执行权");
                while (true) {
                    try {
                        if (list.size() >= Constants.SIZE) {
                            System.out.println(Thread.currentThread().getName() + " 仓库已满，将进入等待");
                            list.wait();
                            System.out.println(Thread.currentThread().getName() + " 等待结束，重新开始运行");
                        } else {
                            System.out.println(Thread.currentThread().getName() + " 仓库空间足够，准备进入生产");
                            list.add(new Object());
                            System.out.println(Thread.currentThread().getName() + " 生产了一个对象 当前存量为：" + list.size());
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
}
