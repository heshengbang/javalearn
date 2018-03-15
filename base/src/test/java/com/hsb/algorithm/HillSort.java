package com.hsb.algorithm;
        /*
         * Copyright ©2011-2017 hsb
         */

import com.hsb.util.RandomGenerator;

public class HillSort {
    public static void main(String[] args) {
        int[] a = RandomGenerator.randomArray(8, 200);
        hillSort(a);
        for (int element : a) {
            System.out.print(element + " ");
        }
    }

    private static void hillSort(int[] a) {
        int d = a.length;
        while (true) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < a.length; i = i + d) {
                    int temp = a[i];
                    int j;
                    for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }
            if (d == 1) {
                break;
            }
        }
    }
}
