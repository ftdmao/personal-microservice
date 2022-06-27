package com.mjw.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 *  
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode219 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }


    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        int left = 0;
        int right = 1;
        Set<Integer> set = new HashSet<>();
        set.add(nums[left]);
        while (right < nums.length && left < right) {
            if (right - left <= k) {
                if (set.contains(nums[right])) {
                    return true;
                } else {
                    set.add(nums[right]);
                    right++;
                }
            } else {
                set.remove(nums[left]);
                left++;
            }
        }
        return false;
    }

}
