package com.hsb.java.thread;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter base directory (e.g. /usr/bin/python):");
        String directory = in.nextLine();
        System.out.print("Enter keyword (e.g. volatile:");
        String keyword = in.nextLine();

        MatchCounter counter = new MatchCounter(new File(directory), keyword);
        FutureTask<Integer> task = new FutureTask<>(counter);

        Thread thread = new Thread(task);
        thread.start();
        try {
            System.out.println(task.get() + " matching file.");
        } catch (ExecutionException | InterruptedException ee) {
            ee.printStackTrace();
        }

    }
}






















