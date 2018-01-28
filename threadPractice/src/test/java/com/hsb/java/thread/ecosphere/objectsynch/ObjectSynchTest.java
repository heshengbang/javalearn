package com.hsb.java.thread.ecosphere.objectsynch;

import java.util.ArrayList;

public class ObjectSynchTest {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>(Constants.SIZE);
        System.out.println("初始存量为："+arrayList.size());
        for (int i = 0; i < 100; i++) {
            new Thread(new Producer(arrayList), "生产者线程&"+i).start();
            new Thread(new Consumer(arrayList), "消费者线程&"+i).start();
        }
    }
}
