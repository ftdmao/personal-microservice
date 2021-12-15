package com.mjw.offer;

/**
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * 剑指 Offer 26. 树的子结构
 */
public class Solution_26 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSameStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 判断两颗树是否相等
     *
     * @param a
     * @param b
     * @return
     */
    private boolean isSameStructure(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return isSameStructure(a.left, b.left) && isSameStructure(a.right, b.right);
    }

    public static void main(String[] args) {
        Solution_26 solution = new Solution_26();
        TreeNode treeA = new TreeNode(3);
        TreeNode nodeA1 = new TreeNode(4);
        TreeNode nodeA2 = new TreeNode(5);
        TreeNode nodeA3 = new TreeNode(1);
        TreeNode nodeA4 = new TreeNode(2);

        treeA.left = nodeA1;
        treeA.right = nodeA2;
        nodeA1.left = nodeA3;
        nodeA1.right = nodeA4;

        TreeNode treeB = new TreeNode(4);
        TreeNode nodeB1 = new TreeNode(2);
        treeB.right = nodeB1;

        System.out.println(solution.isSubStructure(treeA, treeB));
    }
}
