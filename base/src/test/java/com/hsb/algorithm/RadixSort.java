package com.hsb.algorithm;
        /*
         * Copyright ©2011-2017 hsb
         */

import com.hsb.util.RandomGenerator;

public class RadixSort {
    public static void main(String[] args) {
        int[] data = RandomGenerator.randomArray(200, 1000000);
        radixSort(data);
        for (int aData : data) {
            System.out.print(aData + " ");
        }
    }

    private static void radixSort(int[] number) {
        int d = 0;
        //求出數列中最大的位數
        for (int ele : number) {
            if (d < String.valueOf(ele).length()) {
                d = String.valueOf(ele).length();
            }
        }
        int k = 0;
        int n = 1;
        //控制键值排序依据在哪一位
        int m = 1;
        //数组的第一维表示可能的余数0-9
        int[][] temp = new int[10][number.length];
        //数组order[i]用来表示该位是i的数的个数
        int[] order = new int[10];
        while (m <= d) {
            //这趟遍历将数列中的数，放到0~9的桶中
            for (int ele : number) {
                int lsd = ((ele / n) % 10);
                temp[lsd][order[lsd]] = ele;
                order[lsd]++;
            }
            //这趟排序将0~9的桶中的数列拿出来重新组合成数列
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0) {
                    //通过之前分桶装的计数，来将数从桶中取出并拿给数列
                    for (int j = 0; j < order[i]; j++) {
                        number[k] = temp[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            //用于求当前位数的数
            n *= 10;
            k = 0;
            //从个位开始，对所有位数进行处理，用于标记当前位数
            m++;
        }
    }
}
