package com.mjw.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 58.II. 左旋转字符串
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class Solution_58 {

    public String reverseLeftWords(String s, int n) {

        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        Queue queue = new LinkedList();
        for (int i = 0; i < chars.length; i++) {
            if (i < n) {
                queue.add(chars[i]);
            } else {
                result.append(chars[i]);
            }
        }
        while (!queue.isEmpty()) {
            result.append(queue.poll());
        }
        System.out.println(result.toString());
        return result.toString();
    }

    public static void main(String[] args) {
        Solution_58 solution_58 = new Solution_58();
        solution_58.reverseLeftWords("abcdefg", 2);
    }

}
