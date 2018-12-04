package com.hsb.java.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshengbang on 2018/12/4.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    threadLocal.set(temp);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程名为：" + Thread.currentThread().getName() + " 值为：" + threadLocal.get());
                }
            }, "线程 - " + i));
        }
        for (Thread item: threads) {
            item.start();
        }
    }
}
