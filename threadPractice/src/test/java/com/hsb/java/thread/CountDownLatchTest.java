package com.hsb.java.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new ReadNum(i, countDownLatch)).start();
        }
        countDownLatch.await();
        System.out.println("线程执行结束。。。。");
    }

    static class ReadNum implements Runnable {
        private int id;
        private CountDownLatch latch;

        ReadNum(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        public void run() {
            synchronized (this) {
                System.out.println("id:" + id);
                latch.countDown();
                System.out.println("线程组任务 " + id + " 结束，其他任务继续");
            }
        }
    }
}
