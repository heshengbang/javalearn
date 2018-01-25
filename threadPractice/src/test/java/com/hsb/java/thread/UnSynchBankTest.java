package com.hsb.java.thread;

/*
 * Copyright ©2011-2017 hsb
 */
public class UnSynchBankTest {
    private static final int ACCOUNTS = 100;
    private static final double INITIAL_BALANCE = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(ACCOUNTS, INITIAL_BALANCE);
        for ( int i = 0;i < ACCOUNTS; i++) {
            TransferRunnable tr = new TransferRunnable(bank, i, INITIAL_BALANCE);
            Thread thread = new Thread(tr);
            thread.start();
        }
    }
}
