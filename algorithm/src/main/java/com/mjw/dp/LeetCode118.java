package com.mjw.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 示例 1:
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 * <p>
 * 输入: numRows = 1
 * 输出: [[1]]
 */
public class LeetCode118 {

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(2);
        System.out.println(generate);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 1) {
            List<Integer> first = new ArrayList<>();
            first.add(1);
            result.add(first);
            return result;
        }
        result = generate(numRows - 1);
        List<Integer> integers = result.get(numRows - 2);
        List<Integer> newRows = new ArrayList<>();
        newRows.add(1);
        for (int i = 0; i < integers.size() - 1; i++) {
            newRows.add(integers.get(i) + integers.get(i + 1));
        }
        newRows.add(1);
        result.add(newRows);
        return result;
    }

}
