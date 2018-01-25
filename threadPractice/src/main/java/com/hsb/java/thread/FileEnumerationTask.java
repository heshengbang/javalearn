package com.hsb.java.thread;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class FileEnumerationTask extends Thread{
    public static File DUMMY = new File("");
    private BlockingQueue<File> queue;
    private File startingDirectory;


    FileEnumerationTask(String threadName, BlockingQueue<File> queue, File file) {
        setName(threadName);
        this.queue = queue;
        this.startingDirectory = file;
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
            enumerate(startingDirectory);
            queue.put(DUMMY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void enumerate(File startingDirectory) throws InterruptedException {
        File[] files = startingDirectory.listFiles();
        for (File file: files) {
            if (file.isDirectory())
                enumerate(file);
            else
                queue.put(file);
        }
    }
}






















