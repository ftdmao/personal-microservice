package com.mjw.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目描述：
 * <p>
 * 给定一个数组，编写一个函数来计算它的最大N个数与最小N个数的和。你需要对数组进行去重。
 * 题目说明：
 * <p>
 * 数组中数字范围[0, 1000]
 * 最大N个数与最小N个数不能有重叠，如有重叠，输入非法返回-1
 * 输入非法返回-1
 * 输入描述：
 * <p>
 * 第一行输入M， M标识数组大小
 * 第二行输入M个数，标识数组内容
 * 第三行输入N，N表达需要计算的最大、最小N个数
 * 输出描述：
 * <p>
 * 输出最大N个数与最小N个数的和。
 * ————————————————
 * 版权声明：本文为CSDN博主「JOEL-T99」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_47243236/article/details/123780171
 */
public class SelectMaxAndMIn {

    public static void main(String[] args) {
        int[] array = {3, 2, 3, 4, 2};
        System.out.println(count(5, array, 2));
    }

    public static int count(int M, int[] array, int N) {
        Arrays.sort(array);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(array[i]);
        }
        for (int i = array.length - 1; i >= array.length - N; i--) {
            set.add(array[i]);
        }

        if (set.size() != (N * 2)) {
            return -1;
        }
        return set.stream().reduce(Integer::sum).orElse(0);
    }

}
