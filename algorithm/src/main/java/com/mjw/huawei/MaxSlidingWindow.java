package com.mjw.huawei;

/**
 * 题目描述：
 * <p>
 * 有一个N个整数的数组和一个长度为M的窗口。
 * 窗口从数组内的第一个数开始滑动，直到窗口不能滑动为止。
 * 每次滑动产生一个窗口 和窗口内所有数的和。
 * 求窗口滑动产生的所有窗口和的最大值。
 * 输入描述：
 * <p>
 * 第一行输入一个正整数N，表示整数个数 0<N<100000。
 * 第二行输入N个整数，整数取值范围 [-100,100]。
 * 第三行输入正整数M，M代表窗口的大小，M<=100000 并<=N。
 * 输出描述：
 * <p>
 * 窗口滑动产生所有窗口和的最大值
 * 示例
 * <p>
 * 输入：
 * <p>
 * 6
 * 12 10 20 30 15 23
 * 3
 * 输出：
 * <p>
 * 68
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] arr = new int[]{12,10,20,30,15,23};
        System.out.println(getMaxSlidingWindow(arr,3));;
    }

    /**
     * @param arr    数组
     * @param length 窗口大小
     * @return
     */
    public static int getMaxSlidingWindow(int[] arr, int length) {
        int max = 0;
        for (int i = 0; i <= arr.length - length; i++) {
            int temp = 0;
            for (int j = 0; j < length; j++) {
                temp += arr[i + j];
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

}
