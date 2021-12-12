package com.mjw.offer;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * 剑指 Offer 11. 旋转数组的最小数字
 */
public class Solution_11 {

    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] <= numbers[i + 1]) {
                i++;
            } else {
                return numbers[i + 1];
            }
            if (numbers[j] >= numbers[j - 1]) {
                j--;
            } else {
                return numbers[j];
            }
        }
        return numbers[0];
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,2,2,0,1};
        Solution_11 solution = new Solution_11();
        System.out.println(solution.minArray(a));
    }

}
