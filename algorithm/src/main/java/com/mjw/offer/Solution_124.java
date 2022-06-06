package com.mjw.offer;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_124 {

    public static int maxSum = Integer.MIN_VALUE;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(-10);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        System.out.println(maxPathSum(a));
    }

    public static int maxPathSum(TreeNode root) {
       getCurrGain(root);
       return maxSum;
    }

    public static int getCurrGain(TreeNode root){
        if (root == null) {
            return 0;
        }

        // 左边最大的贡献值，如果左边贡献值小于0则不选择左边
        int leftMax = Math.max(getCurrGain(root.left), 0);
        // 右边最大的贡献值，如果右边贡献值小于0则不选择右边
        int rightMax = Math.max(getCurrGain(root.right), 0);

        /**
         * 经过当前节点的最大贡献值，无论当前节点是否为负数都要算上
         *    -1
         *  -1 -1
         *
         *    -1
         *  1  -1
         *
         *    -1
         *  -1  1
         */
        int temp = root.val + leftMax + rightMax;

        maxSum = Math.max(maxSum, temp);

        /**
         * 返回给上级节点的最大贡献值，此处和maxSum的算法不一样
         *   1
         *  1 2
         *  如上面这种情况，只能选择有路返回出去，不能返回整个结构
         */
        return root.val + Math.max(leftMax, rightMax);

    }


}
