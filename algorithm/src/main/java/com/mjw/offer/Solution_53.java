package com.mjw.offer;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/12/10
 * @Author : jiawei_mao
 **/
public class Solution_53 {
    public int search(int[] nums, int target) {
        int i = 0;
        for (int num : nums) {
            if (num == target) {
                i++;
            }
        }
        return i;
    }

    public int missingNumber(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != temp) {
                return temp;
            }
            temp++;
        }
        return temp;
    }

    public int search_dichotomy(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if (j >= 0 && nums[j] != target) {
            return 0;
        }
        // 搜索左边界 right
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int left = j;
        return right - left - 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 8, 8, 8, 8, 9};
        int target = 8;
        Solution_53 solution_53 = new Solution_53();
        System.out.println(solution_53.search_dichotomy(nums, target));
    }
}
