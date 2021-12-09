package com.mjw.offer;

import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class Solution_6 {

    public int[] reversePrint(ListNode head) {
        Stack stack = new Stack();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.empty()) {
            result[i] = (int) stack.pop();
            i++;
        }
        return result;
    }

}
