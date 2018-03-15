package com.hsb.algorithm;
        /*
         * Copyright ©2011-2017 hsb
         */

import com.hsb.util.RandomGenerator;

public class HeapSort {
    public static void main(String[] args) {
        int[] a = RandomGenerator.randomArray(7, 1000);

        buildMaxHeapify(a);
        heapSort(a);
        //print(a);

        for (int ele : a) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    private static void buildMaxHeapify(int[] data) {
        //没有子节点的才需要创建最大堆，从最后一个的父节点开始
        int startIndex = getParentIndex(data.length - 1);
        //从尾端开始创建最大堆，每次都是正确的堆
        for (int i = startIndex; i >= 0; i--) {
            maxHeapify(data, data.length, i);
        }
    }

    private static void maxHeapify(int[] data, int heapSize, int index) {
        //当前点与左右子节点比较
        int left = getChildLeftIndex(index);
        int right = getChildRightIndex(index);

        int largest = index;
        if (left < heapSize && data[index] < data[left]) {
            largest = left;
        }
        if (right < heapSize && data[largest] < data[right]) {
            largest = right;
        }
        //得到最大值后可能需要交换，如果交换了，其子节点可能就不是最大堆了，需要重新调整
        if (largest != index) {
            int temp = data[index];
            data[index] = data[largest];
            data[largest] = temp;
            maxHeapify(data, heapSize, largest);
        }
    }

    private static int getChildRightIndex(int current) {
        return (current << 1) + 1;
    }

    private static int getChildLeftIndex(int current) {
        return current << 1;
    }

    private static int getParentIndex(int current) {
        return current >> 1;
    }

    private static void heapSort(int[] data) {
        //末尾与头交换，交换后调整最大堆
        for (int i = data.length - 1; i > 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            maxHeapify(data, i, 0);
        }
    }

    private static void print(int[] data) {
        int pre = -2;
        for (int i = 0; i < data.length; i++) {
            if (pre < (int) getLog(i + 1)) {
                pre = (int) getLog(i + 1);
                System.out.println();
            }
            System.out.print(data[i] + "|");
        }
    }

    /**
     * 以2为底的对数
     *
     * @param param
     * @return
     */
    private static double getLog(double param) {
        return Math.log(param) / Math.log(2);
    }
}
