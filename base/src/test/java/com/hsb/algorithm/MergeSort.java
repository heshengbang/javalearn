package com.hsb.algorithm;

/**
 * Created by heshengbang on 2018/2/2.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 10, 15, 101};//8
        int[] b = {2, 4, 6, 11, 14, 19, 22, 33, 100};//9
        int i = 0;
        int j = 0;
        int k = 0;
        int[] c = new int[a.length + b.length];
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < a.length) {
            c[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
            c[k] = b[j];
            j++;
            k++;
        }
        for (int aC : c) {
            System.out.print(aC + " ");
        }
        System.out.println();
    }
}
