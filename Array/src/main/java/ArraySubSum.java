package com.kxj;

/**
 * @author xiangjin.kong
 * @date 2020/6/28 10:36
 * @desc 给定一个整数数组，求其下标为m 到 下标到n 的和
 * 要求时间复杂度为o(n)
 */
public class ArraySubSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int sum = subArraySum(array, 2, 4);
        System.out.println(sum);
    }

    /**
     * 采取空间换时间的方法
     * 1、创建新数组，用来存放0-0位的和，0-1的和，0-2的和、、、、
     * 2、array[n]-array[m] 即为m-n的和
     *
     * @param array
     * @param m
     * @param n
     * @return
     */
    static int subArraySum(int[] array, int m, int n) {
        if (m < 0 || n > array.length) {
            return 0;
        }
        int[] newArray = new int[array.length];
        newArray[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            newArray[i] = newArray[i - 1] + array[i];
        }
        return newArray[n] - newArray[m];


    }
}
