package com.mjw.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * 剑指 Offer 27. 二叉树的镜像
 */
public class Solution_27 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList();
        TreeNode newRoot = new TreeNode(root.val);
        queue.offer(root);
        queue.offer(newRoot);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode newNode = queue.poll();
            if (node.left != null) {
                newNode.right = new TreeNode(node.left.val);
                queue.offer(node.left);
                queue.offer(newNode.right);
            }
            if (node.right != null) {
                newNode.left = new TreeNode(node.right.val);
                queue.offer(node.right);
                queue.offer(newNode.left);
            }
        }
        return newRoot;
    }
}
