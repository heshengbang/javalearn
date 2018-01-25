package com.hsb.java.thread.ecosphere.blockingqueue;/*
 * Copyright ©2011-2016 hsb
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by tongheshang on 2018/1/25.
 * https://twitter.com/heshengbang
 * https://github.com/tongheshang
 * email: trulyheshengbang@gmail.com
 */
public class EcosphereTest {
    public static final int QUEUE_SIZE = 10;
    public static void main(String[] args) {

        BlockingQueue queue = new ArrayBlockingQueue(QUEUE_SIZE);

        for (int i = 0;i<10;i++) {
            new Thread(new Producer(queue), "生产者&"+i+"号").start();
        }

        for (int i = 0;i<10;i++) {
            new Thread(new Consumer(queue), "消费者&"+i+"号").start();
        }

    }
}
