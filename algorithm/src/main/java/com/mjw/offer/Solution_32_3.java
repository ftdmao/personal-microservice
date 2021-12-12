package com.mjw.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 */
public class Solution_32_3 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        boolean isRight = true;
        while (!queue.isEmpty()) {
            /**
             * 因为每一行都要变序
             * 所以出栈后不能立刻入栈，要等整一行的都出栈完之后再决定进栈的顺序
             */
            List<TreeNode> nodeList = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                nodeList.add(node);
            }
            result.add(temp);

            /**
             * 决定进栈的顺序
             */
            for (int i = nodeList.size() - 1; i >= 0; i--) {
                TreeNode node = nodeList.get(i);
                if (isRight) {
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                } else {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            // 遍历下一行之前要换序
            isRight = !isRight;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode1.left = treeNode5;
        treeNode1.right = treeNode6;
        Solution_32_3 solution = new Solution_32_3();
        solution.levelOrder(treeNode);
    }

}
