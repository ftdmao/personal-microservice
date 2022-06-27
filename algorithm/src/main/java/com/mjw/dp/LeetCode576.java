package com.mjw.dp;

import java.util.Arrays;

/**
 * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
 * <p>
 * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * 输出：6
 * 示例 2：
 * <p>
 * <p>
 * 输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * 输出：12
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/out-of-boundary-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode576 {

    static int MOD = 1000000007;

    public static void main(String[] args) {
        int m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1;
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp3d = new int[m][n][maxMove];
        for (int[][] dp2d : dp3d) {
            for (int[] dp : dp2d) {
                Arrays.fill(dp, -1);
            }
        }
        return helper(m, n, maxMove, startRow, startColumn, dp3d);
//        return helper(m, n, maxMove, startRow, startColumn);
    }

//    /**
//     * 递归查找结果
//     *
//     * @param m 棋盘有多少行
//     * @param n 棋盘有多少列
//     * @param N 走到目标的部署
//     * @param x 目标横坐标
//     * @param y 目标纵坐标
//     * @return
//     */
//    public static int helper(int m, int n, int N, int x, int y) {
//        if (x < 0 || y < 0 || x >= m || y >= n) {
//            return 1;
//        }
//        // 没步数了就证明达不到目标
//        if (N == 0) {
//            return 0;
//        }
//        int res = 0;
//        res += helper(m, n, N - 1, x - 1, y);
//        res += helper(m, n, N - 1, x + 1, y);
//        res += helper(m, n, N - 1, x, y - 1);
//        res += helper(m, n, N - 1, x, y + 1);
//        return res;
//    }


    /**
     * dp数组 记忆法
     *
     * @param m 棋盘有多少行
     * @param n 棋盘有多少列
     * @param N 走到目标的部署
     * @param x 目标横坐标
     * @param y 目标纵坐标
     * @return
     */
    public static int helper(int m, int n, int N, int x, int y, int dp[][][]) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return 1;
        }
        // 没步数了就证明达不到目标
        if (N == 0) {
            return 0;
        }
        if (dp[x][y][N] != -1) {
            return dp[x][y][N];
        }

        int res = 0;
        res = (res + helper(m, n, N - 1, x - 1, y, dp)) % MOD;
        res = (res + helper(m, n, N - 1, x + 1, y, dp)) % MOD;
        res = (res + helper(m, n, N - 1, x, y - 1, dp)) % MOD;
        res = (res + helper(m, n, N - 1, x, y + 1, dp)) % MOD;
        return res;
    }

}
