package com.hsb.java.thread.ecosphere.blockingqueue;/*
 * Copyright ©2011-2016 hsb
 */

import java.util.concurrent.BlockingQueue;

/**
 * Created by tongheshang on 2018/1/25.
 * https://twitter.com/heshengbang
 * https://github.com/tongheshang
 * email: trulyheshengbang@gmail.com
 */
public class Consumer implements Runnable{

    private final BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.take();
                System.out.println(Thread.currentThread().getName() + " - 消费了一个对象 - 当前存量为：" + queue.size());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " - 消费失败");
            }
        }
    }
}
