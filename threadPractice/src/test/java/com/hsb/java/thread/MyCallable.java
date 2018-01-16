package com.hsb.java.thread;
        /*
         * Copyright ©2011-2017 hsb
         */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<Integer> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }

    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallable);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i == 20) {
                new Thread(futureTask, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值：" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        new Thread(new FutureTask<Integer>(new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Integer("1");
            }
        })).start();
    }

}
