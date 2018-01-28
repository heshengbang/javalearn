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
public class Consumer implements Runnable {
    private ArrayList list;
    private Condition full;
    private Condition empty;
    private Lock lock;

    public Consumer(ArrayList list, Condition full, Condition empty, Lock lock) {
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
                if (list.size() <= 0) {
                    System.out.println(Thread.currentThread().getName() + " 库存不足，即将进入等待，当前存量为：" + list.size());
                    empty.await();
                    System.out.println(Thread.currentThread().getName() + "从等待条件中返回，重新开始执行");
                } else {
                    list.remove(0);
                    System.out.println(Thread.currentThread().getName() + " 消费了一个对象 当前存量为：" + list.size());
                    full.signalAll();
                    System.out.println(Thread.currentThread().getName() + "唤醒了在满条件上等待的线程");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
