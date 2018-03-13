package com.hsb.algorithm;
        /*
         * Copyright ©2011-2017 hsb
         */

import com.hsb.util.RandomGenerator;

public class SelectSort {
    public static void main(String[] args) {
        int[] a = RandomGenerator.randomArray(100, 2000);
        selectSort(a);
        for (int ex:a) {
            System.out.print(ex + " ");
        }
        System.out.println();
    }

    /**
     * 简单选择排序
     * @param a 待排序的数组
     */
    private static void selectSort(int[] a) {
        for (int i=0;i < a.length;i++) {
            //从左至右开始，假设最左边的为最小数
            int minIndex = i;
            for (int j = i+1;j<a.length;j++) {
                //用最左边的数与后面的数挨个比较，如果发现比它小的就纪录下标
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            //一遍遍历结束后，如果最小的坐标不是之前赋值的，则做交换值操作
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }
}
