package com.hsb.java.thread;
        /*
         * Copyright ©2011-2017 hsb
         */

/**
 * 功能描述:&lt;/br&gt;
 * Copyright ©2011-2016 中国民航信息网络股份有限公司 &lt;/br&gt;
 *
 * @author hhu@travelsky.com 何虎
 * @version 1.0
 * @time 2018/1/16 14:06
 * ************************************************
 * @since
 */

public class MyThread extends Thread {

    public MyThread(String name, int pro) {
        super(name);// 设置线程的名称
        this.setPriority(pro);// 设置优先级
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(this.getName() + "线程第" + i + "次执行！");
            if (i % 5 == 0)
                Thread.yield();
        }
    }

    public static void main(String[] args) {
//        new MyThread("低级", Thread.MAX_PRIORITY).start();
//        new MyThread("中级", Thread.NORM_PRIORITY).start();
//        new MyThread("高级", Thread.MIN_PRIORITY).start();

        String s = new String("1");
        s = s.intern();
        String s2 = "1";
        System.out.println(s == s2);
        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
