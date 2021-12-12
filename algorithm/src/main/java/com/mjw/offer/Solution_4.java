package com.mjw.offer;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 剑指 Offer 04. 二维数组中的查找
 */
public class Solution_4 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean canFind = true;
        if(matrix.length<=0){
            return canFind;
        }
        int x = matrix[0].length - 1;
        int y = 0;

        int begin = matrix[y][x];
        while (begin != target) {
            if (begin < target) {
                y++;
            } else {
                x--;
            }
            if(y>=matrix.length || x <= 0 ){
                canFind = false;
                break;
            }
            begin = matrix[y][x];
        }
        return canFind;
    }

    public static void main(String[] args) {
        Solution_4 solution = new Solution_4();
        int[][] a = new int[][]{{1}};
        solution.findNumberIn2DArray(a, 15);
    }
}
