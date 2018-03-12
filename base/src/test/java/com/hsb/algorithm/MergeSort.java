package com.hsb.algorithm;

import com.hsb.util.RandomGenerator;

/**
 * Created by heshengbang on 2018/2/2.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */
public class MergeSort {
//    public static void main(String[] args) {
//        int[] a = {1, 3, 5, 7, 9, 10, 15, 101};//8
//        int[] b = {2, 4, 6, 11, 14, 19, 22, 33, 100};//9
//        int i = 0;
//        int j = 0;
//        int k = 0;
//        int[] c = new int[a.length + b.length];
//        while (i < a.length && j < b.length) {
//            if (a[i] <= b[j]) {
//                c[k] = a[i];
//                i++;
//            } else {
//                c[k] = b[j];
//                j++;
//            }
//            k++;
//        }
//        while (i < a.length) {
//            c[k] = a[i];
//            i++;
//            k++;
//        }
//        while (j < b.length) {
//            c[k] = b[j];
//            j++;
//            k++;
//        }
//        for (int aC : c) {
//            System.out.print(aC + " ");
//        }
//        System.out.println();
//    }
    //　private　static　long　sum　=　0;


    /**
     * 先拆分数组并排序，然后再合并
     * @param a 待分组排序的大数组
     * @param low 小数列的起始位置
     * @param high 小数列的结束位置（包含在数组内）
     */
    private static void mergeSort(int[] a, int low, int high) {
        //将数列分为两部分
        int mid = (low + high) / 2;
        if (low < high) {
            //左边部分进行拆分并排序
            mergeSort(a, low, mid);
            //右边部分进行拆分并排序
            mergeSort(a, mid + 1, high);
            //将已经有序的两部分进行合并
            merge(a, low, mid, high);
        }
    }

    /**
     * 合并有序数组
     * @param a 在各个小区域有序的数组
     * @param low 小数列在大数组中的开始位置
     * @param mid 两个有序小数列的中点位置
     * @param high 小数列在大数组中的结束位置
     */
    private static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= high) {
            temp[k++] = a[j++];
        }

        System.arraycopy(temp, 0, a, low, temp.length);
    }

    public static void main(String[] args) {
        int[] a = RandomGenerator.randomArray(100, 10000);
        mergeSort(a, 0, a.length-1);
        for (int anA : a) {
            System.out.print(anA + "　");
        }
    }
}
