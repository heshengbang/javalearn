package com.hsb.java.slf4j;
        /*
         * Copyright ©2011-2017 hsb
         */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程情况下，使用slf4j日志对象
 * 按照Stack Overflow上面的说法，slf4j本身是线程不安全的，但是它使用的门面模式，所以它产生的日志对象是否线程安全得看具体日志框架的实现。目前的情况是，所有主流的日志框架例如log4j，logback，java自带的日志，都是线程安全的。
 */
public class MutilThreadSlf4jTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MutilThreadSlf4jTest.class);

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 1000; i++) {
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    LOGGER.info("多线程下使用日志会不会出现问题？？？？ - " + Thread.currentThread().getName(), MutilThreadSlf4jTest.class);
                }
            });
        }
        fixedThreadPool.shutdown();
        System.out.println("主线程至此结束——————————————————————————————————————————————————————");
    }
}
