package com.hsb.algorithm;
        /*
         * Copyright ©2011-2017 hsb
         */

import com.hsb.util.RandomGenerator;

public class InsertSort {
    public static void main(String[] args) {
        int[] a = RandomGenerator.randomArray(10, 100);
        insertSort(a);
        for (int ex:a) {
            System.out.print(ex + " ");
        }
        System.out.println();
    }

    private static void insertSort(int[] arr) {
        //如果数组为空或小于2，则不用排序
        if (arr == null || arr.length < 2) {
            return;
        }
        //从左起第二个数字开始遍历，左边为有序数列，右边为无序数列
        for (int i = 1; i < arr.length; i++) {
            //下标为i的数字和左边的有序数列进行比较
            for (int j = i; j > 0; j--) {
                //当下标为i的数字小于有序数列的数字时交换位置
                // 直到其在一个合适的位置
                //如果下标为i的数字大于有序数列右边第一个数字则不作任何操作
                // 因为左边是有序数列，所以它一定是大于左边所有数字的
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
