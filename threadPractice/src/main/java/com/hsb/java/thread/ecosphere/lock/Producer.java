package com.hsb.java.thread.ecosphere.lock;/*
 * Copyright ©2011-2016 hsb
 */

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by tongheshang on 2018/1/28.
 * https://twitter.com/heshengbang
 * https://github.com/tongheshang
 * email: trulyheshengbang@gmail.com
 */
public class Producer implements Runnable{
    private ArrayList list;
    private Condition full;
    private Condition empty;
    private Lock lock;

    public Producer(ArrayList list, Condition full, Condition empty, Lock lock) {
        this.list = list;
        this.full = full;
        this.empty = empty;
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "获得执行权限");
        while (true) {
            try {
                lock.lock();
                if (list.size() >= Constant.SIZE) {
                    System.out.println(Thread.currentThread().getName() + " 空间不足，即将进入等待，当前存量为：" + list.size());
                    full.await();
                    System.out.println(Thread.currentThread().getName() + "从等待条件中返回，重新开始执行");
                } else {
                    list.add(new Object());
                    System.out.println(Thread.currentThread().getName() + " 生产了一个对象 当前存量为：" + list.size());
                    empty.signalAll();
                    System.out.println(Thread.currentThread().getName() + "唤醒了在空条件上等待的线程");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
