package com.mjw.slidingwindow;

/**
 * @Description :
 * @Date : 2022/6/27
 * @Author : jiawei_mao
 **/
public class LeetCode209 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 4};
        System.out.println(minSubArrayLen(10, a));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(right - left + 1, result);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


}
