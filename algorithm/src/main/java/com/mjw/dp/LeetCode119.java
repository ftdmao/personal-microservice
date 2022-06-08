package com.mjw.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * 示例 2:
 * <p>
 * 输入: rowIndex = 0
 * 输出: [1]
 * 示例 3:
 * <p>
 * 输入: rowIndex = 1
 * 输出: [1,1]
 *  
 * <p>
 * 提示:
 * <p>
 * 0 <= rowIndex <= 33
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode119 {

    public static void main(String[] args) {
        getRow(4);
    }

    public static List<Integer> getRow(int rowIndex) {
        int dp[][] = new int[rowIndex + 1][rowIndex + 1];
        int n = dp.length;
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j] == 1) {
                    break;
                }
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <=rowIndex ; i++) {
            result.add(dp[rowIndex][i]);
        }
        return result;
    }

}
