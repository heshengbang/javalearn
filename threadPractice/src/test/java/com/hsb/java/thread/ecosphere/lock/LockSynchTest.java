package com.hsb.java.thread.ecosphere.lock;/*
 * Copyright ©2011-2016 hsb
 */

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tongheshang on 2018/1/28.
 * https://twitter.com/heshengbang
 * https://github.com/tongheshang
 * email: trulyheshengbang@gmail.com
 */
public class LockSynchTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        ArrayList arrayList = new ArrayList(Constant.SIZE);
        Condition full = lock.newCondition();
        Condition empty = lock.newCondition();

        for (int i=0;i<10;i++) {
            new Thread(new Producer(arrayList, full, empty, lock), "生产者&"+i).start();
            new Thread(new Consumer(arrayList, full, empty, lock), "消费者&"+i).start();
        }
    }
}
