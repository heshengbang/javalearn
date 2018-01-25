package com.hsb.java.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MatchCounter implements Callable<Integer>{
    private File directory;
    private String keyword;
    private ExecutorService pool;

    public MatchCounter(File file, String keyword) {
        this.directory = file;
        this.keyword = keyword;
    }

    public MatchCounter(File file, String keyword, ExecutorService pool) {
        this.directory = file;
        this.keyword = keyword;
        this.pool = pool;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     */
    @Override
    public Integer call() {
        int count = 0;
        File[] files = directory.listFiles();
        List<Future<Integer>> results = new ArrayList<>();

        if (files != null) {
            for (File file: files) {
                if (file.isDirectory()) {
                    //通过为每个搜索开辟一个线程来实现
                    //MatchCounter counter = new MatchCounter(file, keyword);
                    //FutureTask<Integer> task = new FutureTask<>(counter);
//                    results.add(task);
//                    Thread thread = new Thread(task);
//                    thread.start();
                    //通过使用线程池来实现
                    MatchCounter counter = new MatchCounter(file, keyword, pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);

                } else {
                    if (search(file))
                        count++;
                }
                for (Future<Integer> result: results) {
                    try {
                        count += result.get();
                    } catch (ExecutionException | InterruptedException ee) {
                        ee.printStackTrace();
                    }
                }
            }
        }
        return count;
    }

    private boolean search(File file) {
        try (Scanner in = new Scanner(file)){
            boolean found = false;
            while (!found && in.hasNextLine()) {
                String line = in.nextLine();
                if (line.contains(keyword))
                    found = true;
            }
            return found;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
