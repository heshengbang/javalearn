package com.hsb.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
         * Copyright ©2011-2017 hsb
         */
public class Bank {
    private Lock bankLock = new ReentrantLock();
    private Condition sufficientFunds;
    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        this.accounts = new double[n];
        for (int i = 0;i < this.accounts.length; i++) {
            this.accounts[i] = initialBalance;
        }
        sufficientFunds = bankLock.newCondition();
    }
    public void transfer(int from, int to, double amount) {
//            if (accounts[from] >= amount) {
//                System.out.print(Thread.currentThread());
//                accounts[from] -= amount;
//                System.out.printf(" %10.2f from %d to %d ", amount, from, to);
//                accounts[to] += amount;
//                System.out.printf(" Total Balance: %10.2f%n ", getTotalBalance());

        bankLock.lock();
        try {
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d ", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n ", getTotalBalance());
        } finally {
            bankLock.unlock();
        }
    }
    private Object getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }
    public int size() {
        return accounts.length;
    }
}
