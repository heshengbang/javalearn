package com.hsb.java.thread;

import java.util.concurrent.RecursiveTask;

public class Counter extends RecursiveTask<Integer>{
    private static final int THRESHOLD = 1000;
    private double[] values;
    private int from;
    private int to;
    private Filter filter;

    Counter(double[] numbers, int i, int length, Filter filter) {
        this.values = numbers;
        this.from = i;
        this.to = length;
        this.filter = filter;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        if (to - from < THRESHOLD) {
            int count = 0;
            for (int i = from; i< to;i ++) {
                if (filter.accept(values[i]))
                    count++;
            }
            return count;
        } else {
            int mid = (from + to) / 2;
            Counter first = new Counter(values, from, mid, filter);
            Counter second = new Counter(values, mid, to, filter);
            invokeAll(first, second);
            return first.join() + second.join();
        }
    }
}
