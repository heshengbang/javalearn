package com.hsb.algorithm;/**
 * Created by heshengbang on 2018/2/2.
 */

/**
 * Created by heshengbang on 2018/2/2.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 *
 * 基本思想：①选取第一个数字作为界点数字，比它大的放到它后面，比它小的放到前面
 * ②把数组分作两部分，小的部分、大的部分（方便理解的话，这两部分都不包含界点数字），两部分再分别做①操作
 *
 *  主体是递归调用
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {31,4,11,5,9,26,53,5,8,97,94,5,2,101,111000,111,99,53,22,15};

        long start = System.currentTimeMillis();
        quickSort(a, 0, a.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("耗時：" + end + "  -  " + start + " = " + (end - start));
    }

    private static void quickSort(int[] a, int low, int high) {
        int l = low;
        int h = high;
        int key = a[low];
        while (l < h) {
            while (l < h && a[h] > key) {
                h--;
            }
            if (l < h) {
                int temp = a[l];
                a[l] = a[h];
                a[h] = temp;
                l++;
            }
            while (l < h && a[l] < key) {
                l++;
            }
            if (l < h) {
                int temp = a[h];
                a[h] = a[l];
                a[l] = temp;
                h--
            }
        }
        for (int one : a) {
            System.out.print(one + " ");
        }
        System.out.println("此时的底端和高端分别为：" + low + " - " + l + " - " + h + " - " + high);
        if (low < l) {
            quickSort(a, low, l - 1);
        }
        if (h < high) {
            quickSort(a, h + 1, high);
        }
    }
}
