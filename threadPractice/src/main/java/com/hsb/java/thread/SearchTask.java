package com.hsb.java.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class SearchTask extends Thread {
    private BlockingQueue<File> queue;
    private String keyword;

    SearchTask(String threadName, BlockingQueue<File> queue, String keyword) {
        setName(threadName);
        this.queue = queue;
        this.keyword = keyword;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        try {
            boolean done = false;
            while (!done) {
                File file = queue.take();
                if (file == FileEnumerationTask.DUMMY) {
                    queue.put(file);
                    done = true;
                } else {
                    search(file);
                }
            }
        } catch (InterruptedException | FileNotFoundException ie) {
            ie.printStackTrace();
        }
    }

    private void search(File file) throws FileNotFoundException {
        try (Scanner in = new Scanner(file)){
            int lineNumber = 0;
            while (in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
                }
            }
        }
    }
}
