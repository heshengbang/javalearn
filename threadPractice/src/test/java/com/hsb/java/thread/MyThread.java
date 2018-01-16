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
    @Override
    public void run() {
        System.out.println("fuck you");
    }

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().run();
    }
}
