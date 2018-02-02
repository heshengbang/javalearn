package com.hsb.algorithm;/**
 * Created by heshengbang on 2018/2/2.
 */

/**
 * Created by heshengbang on 2018/2/2.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {3, 14, 1, 5, 6, 26, 58, 5, 89, 7, 9, 45};
        int i = 0;
        int j = a.length-1;
        quickSort(a, i, j);
        System.out.println();
    }

    private static void quickSort(int[] a, int start, int end) {
        int l = start;
        int h = end;
        int key = a[start];
        while (l < h) {
            while (l < h && a[h] >= key) {
                h--;
            }
            if (l < h) {
                int temp = a[l];
                a[l] = a[h];
                a[h] = temp;
                l++;
            }
            while (l < h && a[l] <= key) {
                l++;
            }
            if (l < h) {
                int temp = a[h];
                a[h] = a[l];
                a[l] = temp;
                h--;
            }
        }
        for (int one: a) {
            System.out.print(one + " ");
        }
        System.out.println();
        if ( l > start) {
            quickSort(a, start, l-1);
        }
        if ( h < end) {
            quickSort(a, l+1, end);
        }
    }
}
