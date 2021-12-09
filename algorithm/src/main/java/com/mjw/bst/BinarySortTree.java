package com.mjw.bst;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/12/6
 * @Author : jiawei_mao
 **/
public class BinarySortTree {

    TreeNode root;

    public void add(TreeNode node) {
        if (node == null) {
            return;
        }
        if (root == null) {
            root = node;
            return;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (node.getValue() < curr.getValue()) {
                if (curr.getLeftChild() == null) {
                    curr.setLeftChild(node);
                    curr.getLeftChild().setParent(curr);
                    return;
                } else {
                    curr = curr.getLeftChild();
                }
            } else {
                if (curr.getRightChild() == null) {
                    curr.setRightChild(node);
                    curr.getRightChild().setParent(curr);
                    return;
                } else {
                    curr = curr.getRightChild();
                }
            }
        }
    }

    public void add(int value) {
        add(new TreeNode(value));
    }

    /**
     * 中序遍历
     */
    public void minPrint(TreeNode node) {
        if (node.getLeftChild() != null) {
            minPrint(node.getLeftChild());
        }
        System.out.println(node.getValue());
        if (node.getRightChild() != null) {
            minPrint(node.getRightChild());
        }
    }

    /**
     * 查找元素
     *
     * @param value
     * @return
     */
    public TreeNode find(int value) {
        TreeNode curr = root;
        while (curr != null) {
            if (value == curr.getValue()) {
                return curr;
            } else if (value <= curr.getValue()) {
                curr = curr.getLeftChild();
            } else {
                curr = curr.getRightChild();
            }
        }
        return null;
    }

    /**
     * 找最小结点
     *
     * @return
     */
    public TreeNode min() {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.getLeftChild() == null) {
                return curr;
            } else {
                curr = curr.getLeftChild();
            }
        }
        return null;
    }

    /**
     * 找最大结点
     *
     * @return
     */
    public TreeNode max() {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.getRightChild() == null) {
                return curr;
            } else {
                curr = curr.getRightChild();
            }
        }
        return null;
    }

    public void delete(int value) {
        TreeNode deleteNode = find(value);
        if (deleteNode == null) {
            return;
        }
        if (deleteNode.isLeaf()) {
            TreeNode parent = deleteNode.getParent();
            if (parent.getLeftChild().getValue() == value) {
                parent.setLeftChild(null);
                return;
            }
            if (parent.getRightChild().getValue() == value) {
                parent.setRightChild(null);
                return;
            }
        }

    }

    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.add(4);
        binarySortTree.add(3);
        binarySortTree.add(4);
        binarySortTree.add(2);
        binarySortTree.find(2);
        binarySortTree.minPrint(binarySortTree.root);
    }
}
