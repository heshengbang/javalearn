package com.hsb.java.thread;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * Copyright ©2011-2017 hsb
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter base directory (e.g. /usr/local/jdk16.0./src):");
        String directory = in.nextLine();
        System.out.println("Enter keyword (e.g. volatile:");
        String keyword = in.nextLine();

        final int FILE_QUEUE_SIZE = 10;
        final int SEARCH_THREADS = 15;
        BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

        FileEnumerationTask enumerator = new FileEnumerationTask("SearchThread", queue, new File(directory));
        new Thread(enumerator).start();
        for (int i = 0;i <= SEARCH_THREADS;i++) {
            new Thread(new SearchTask("FUCK-"+i, queue, keyword)).start();
        }
    }
}





















