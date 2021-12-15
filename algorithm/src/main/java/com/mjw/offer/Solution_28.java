package com.mjw.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/12/14
 * @Author : jiawei_mao
 **/
public class Solution_28 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> nodeList = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                nodeList.add(node.left);
                nodeList.add(node.right);
            }
            for (int j = 0; j < nodeList.size() / 2; j++) {
                TreeNode node1 = nodeList.get(j);
                TreeNode node2 = nodeList.get(nodeList.size() - j - 1);
                if (node1 == null && node2 != null) {
                    return false;
                }
                if (node2 == null && node1 != null) {
                    return false;
                }
                if (node1 == null && node2 == null) {
                    continue;
                }
                if (node1.val != node2.val) {
                    return false;
                }

            }
            for (TreeNode treeNode : nodeList) {
                if (treeNode != null) {
                    queue.offer(treeNode);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_28 solution = new Solution_28();
        TreeNode treeA = new TreeNode(1);
        TreeNode nodeA1 = new TreeNode(2);
        TreeNode nodeA2 = new TreeNode(2);
        TreeNode nodeA3 = new TreeNode(3);
        TreeNode nodeA6 = new TreeNode(3);

        treeA.left = nodeA1;
        treeA.right = nodeA2;

        nodeA1.right = nodeA3;
        nodeA2.right = nodeA6;
        solution.isSymmetric(treeA);
    }

}
