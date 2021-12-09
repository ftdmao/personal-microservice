package com.mjw.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/12/8
 * @Author : jiawei_mao
 **/
public class Solution_35 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }

        Node curr = head;
        Node after;
        /**
         * 第一次遍历复制节点
         */
        while (curr != null) {
            after = curr.next;
            Node newNode = new Node(curr.val);
            curr.next = newNode;
            newNode.next = after;
            curr = after;
        }

        /**
         * 第二次遍历设置random
         */
        curr = head;
        after = head.next;
        while (curr != null) {
            if (curr.random == null) {
                after.random = null;
            } else {
                after.random = curr.random.next;
            }
            curr = after.next;
            if (curr == null) {
                break;
            }
            after = curr.next;
        }

        /**
         * 第三次遍历分离两个链表
         */
        curr = head;
        after = head.next;
        Node newHead = head.next;
        while (curr != null) {
            curr.next = after.next;
            if (after.next == null) {
                break;
            }
            curr = after.next;
            after.next = curr.next;
            after = curr.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Solution_35 solution_35 = new Solution_35();
        Node node = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node.random = null;
        node1.random = node;
        node2.random = node4;
        node3.random = node2;
        node4.random = node;
        solution_35.copyRandomList(node);
    }


}
