package com.hsb.algorithm;/**
 * Created by heshengbang on 2018/2/3.
 */

/**
 * Created by heshengbang on 2018/2/3.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {3, 5, 6, 9, 10, 14, 15, 92, 105, 653, 1000, 5897, 9000, 10110};
        int key = 10110;
        System.out.println(binarySearch(a, 0, a.length, key));
    }

    private static int binarySearch(int[] a, int start, int end, int key) {

        //recursive
//        int temp = (start + end) / 2;
//        if (key < a[temp]) {
//            return binarySearch(a, start, temp-1, key);
//        } else if (key > a[temp]) {
//            return binarySearch(a, temp+1, end, key);
//        } else {
//            return temp;
//        }

        //loop
        int temp = (start + end) / 2;
        while (start < end) {
            if (a[temp] < key) {
                start = temp + 1;
            } else if (a[temp] > key) {
                end = temp - 1;
            } else {
                break;
            }
            temp = (start + end) / 2;
        }
        return temp;
    }
}
