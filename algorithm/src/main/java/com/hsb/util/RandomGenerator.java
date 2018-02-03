package com.hsb.util;/**
 * Created by heshengbang on 2018/2/3.
 */

import java.util.Random;

/**
 * Created by heshengbang on 2018/2/3.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */
public class RandomGenerator {
    public static int[] randomArray(int size, int range) {
        int[] a = new int[size];
        Random random = new Random();
        for (int i = 0; i < size;i++) {
            a[i] = random.nextInt(range);
        }
        return a;
    }
}
