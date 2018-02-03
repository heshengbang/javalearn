package com.hsb.algorithm;/**
 * Created by heshengbang on 2018/2/3.
 */

import com.hsb.util.RandomGenerator;

import java.util.Arrays;

/**
 * Created by heshengbang on 2018/2/3.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 * 基本思想，一组无序的数字，相邻数字之间比较，如果 a[i] > a[i+1] 则交换位置，否则不做操作
 * 遍历数组，直到不再有交换操作发生
 *
 * 方法二：遍历第一遍，把最大的数字移到数组最后一个位置，然后下一次遍历就不再比较最后一个数字
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = RandomGenerator.randomArray(100, 10000);
        bubbleSort(a);
    }

    private static void bubbleSort(int[] a) {

        int[] b = Arrays.copyOf(a, a.length);

        //此种比较方式，比较次数比下面那种恒定要少一些
        int count2 = 0;
        long start = System.currentTimeMillis();
        boolean flag = true;
        int size = a.length;
        while (flag) {
            flag = false;
            for (int i = 0;i< size - 1;i++) {
                count2 ++;
                if (a[i] > a[i+1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    flag = true;
                }
            }
            size -= 1;
        }
        long end = System.currentTimeMillis();
        System.out.println("耗時：" + end + "  -  " + start + " = " + (end - start));
        for (int one : a) {
            System.out.print(one + " ");
        }
        System.out.println("比較次數："+count2);

        int count1 = 0;
        start = System.currentTimeMillis();
        for (int i = b.length - 1; i > 0; --i)
        {
            for (int j = 0; j < i; ++j)
            {
                count1 ++;//190
                if (b[j + 1] < b[j])
                {
                    int temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                }
            }
        }

        end = System.currentTimeMillis();
        System.out.println("耗時：" + end + "  -  " + start + " = " + (end - start));
        for (int one : b) {
            System.out.print(one + " ");
        }
        System.out.println("比較次數："+count1);

    }
}
