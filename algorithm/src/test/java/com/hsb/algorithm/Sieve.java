package com.hsb.algorithm;/*
 * Copyright ©2011-2016 hsb
 */

import java.util.BitSet;

/**
 * Created by tongheshang on 2018/2/1.
 * https://twitter.com/heshengbang
 * https://github.com/tongheshang
 * email: trulyheshengbang@gmail.com
 *
 * source from Java核心技术卷一 P617 13-8   Eratosthenes 筛子算法
 */
public class Sieve {
    public static void main(String[] args) {
        int n = 2000000;
        long start = System.currentTimeMillis();
        BitSet bitSet = new BitSet(n+1);
        int count = 0;
        int i;
        for (i = 2; i <= n; i++) {
            bitSet.set(i);
        }
        i = 2;
        while (i * i <= n) {
            if (bitSet.get(i)) {
                count ++;
                int k = 2 * i;
                while (k <= n) {
                    bitSet.clear(k);
                    k += i;
                }
            }
            i++;
        }
        while (i <= n) {
            if (bitSet.get(i)) {
                count++;
            }
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end - start) + " milliseconds ");
    }
}

























