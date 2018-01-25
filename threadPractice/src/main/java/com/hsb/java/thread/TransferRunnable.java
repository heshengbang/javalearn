package com.hsb.java.thread;
/*
 * Copyright ©2011-2017 hsb
 */
public class TransferRunnable implements Runnable{
    private Bank bank;
    private int fromAccount;
    private double maxAmount;

    public TransferRunnable(Bank b, int from, double max) {
        this.bank = b;
        this.fromAccount = from;
        this.maxAmount = max;
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
            while (true) {
                int toAccount = (int) (bank.size() * Math.random());
                double amount = maxAmount * Math.random();
                bank.transfer(fromAccount, toAccount, amount);
                int DELAY = 10;
                Thread.sleep((int) (DELAY * Math.random()));
            }
        } catch (InterruptedException ie) {
            //do nothing really useful
        }
    }
}
