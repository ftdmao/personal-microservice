package com.mjw.offer;

/**
 * 剑指 Offer 24. 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class Solution_24 {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre = null;
        ListNode after = head.next;
        while (head.next != null) {
            head.next = pre;
            pre = head;
            head = after;
            after = head.next;
        }
        head.next = pre;
        return head;
    }
}
