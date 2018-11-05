package com.hsb.java.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * created by heshengbang
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2018/11/5 10:34
 */

public class RejectPolicyTest {
    private static ThreadFactory factory = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable task) {
            return new Thread(task, "线程池-");
        }
    };
    private static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1), factory, new ThreadPoolExecutor.CallerRunsPolicy());
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + finalI);
                }
            });
        }
    }
}
