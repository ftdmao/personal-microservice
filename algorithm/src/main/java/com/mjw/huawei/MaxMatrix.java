package com.mjw.huawei;

import java.util.Arrays;

/**
 * 题目描述：
 * <p>
 * 给定一个仅包含0和1的n*n二维矩阵，请计算二维矩阵的最大值
 * <p>
 * 计算规则如下：
 * <p>
 * 每行元素按下标顺序组成一个二进制数(下标越大约排在低位)，二进制数的值就是该行的值，矩阵各行之和为矩阵的值。
 * <p>
 * 允许通过向左或向右整体循环移动每个元素来改变元素在行中的位置。
 * <p>
 * 比如：
 * <p>
 * [1,0,1,1,1] 向右整体循环移动两位 [1,1,1,0,1]，二进制数为11101 值为29
 * [1,0,1,1,1] 向左整体循环移动两位 [1,1,1,1,0]，二进制数为11110 值为30
 * <p>
 * 输入描述：
 * <p>
 * 数据的第一行为正整数，记录了N的大小，0<N<=20
 * 输入的第2到n+1行为二维矩阵信息
 * 行内元素边角逗号分割
 * 输出描述：
 * <p>
 * 矩阵的最大值
 * 示例
 * <p>
 * 输入：
 * <p>
 * 5
 * 1,0,0,0,1
 * 0,0,0,1,1
 * 0,1,0,1,0
 * 1,0,0,1,1
 * 1,0,1,0,1
 * 输出：
 * <p>
 * 122
 * 说明：
 * <p>
 * 第一行向右整体循环移动一位，得到最大值 11000为24，依次循环，得到最大值122。
 */
public class MaxMatrix {

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 0, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {1, 0, 1, 0, 1}
        };
        getMaxMatrix(a);
    }

    public static int getMaxMatrix(int matrix[][]) {
        if (matrix.length == 0) {
            return 0;
        }
        if (matrix[0].length == 0) {
            return 0;
        }

        int max = 0;
        /**
         * 遍历每一行
         */
        for (int i = 0; i < matrix.length; i++) {
            //  每一行的最大值
            int temp = 0;
            String row = toString(matrix[i]);
            for (int j = 0; j < matrix[0].length; j++) {
                StringBuilder newRow = new StringBuilder();
                newRow.append(row.substring(j, matrix[0].length));
                newRow.append(row.substring(0, j));
                int newValue = Integer.parseInt(newRow.toString(), 2);
                if (newValue > temp) {
                    temp = newValue;
                }
            }
            max += temp;
        }
        return max;
    }


    public static String toString(int[] a) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            builder.append(a[i]);
        }
        return builder.toString();
    }

}
