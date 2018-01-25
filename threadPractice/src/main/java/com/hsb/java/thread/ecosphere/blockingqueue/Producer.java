package com.hsb.java.thread.ecosphere.blockingqueue;
/*
 * Copyright ©2011-2016 hsb
 */

import java.util.concurrent.BlockingQueue;

/**
 * Created by tongheshang on 2018/1/25.
 * https://twitter.com/heshengbang
 * https://github.com/tongheshang
 * email: trulyheshengbang@gmail.com
 */
public class Producer implements Runnable {

    private final BlockingQueue queue;

    Producer(BlockingQueue q) {
        queue = q;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.put(new Object());
                System.out.println(Thread.currentThread().getName() + " - 生产了一个对象 - 当前存量为：" + queue.size());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " - 生产失败");
            }
        }
    }
}
