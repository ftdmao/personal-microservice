package com.mjw.bst;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/12/6
 * @Author : jiawei_mao
 **/
public class TreeNode {

    private int value;

    private TreeNode leftChild;

    private TreeNode rightChild;

    private TreeNode parent;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public boolean isLeaf() {
        if (getLeftChild() == null && getRightChild() == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLeftChild() {
        TreeNode parent = getParent();
        if (parent == null) {
            return false;
        }
        if (value == parent.getLeftChild().getValue()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRightChild() {
        TreeNode parent = getParent();
        if (parent == null) {
            return false;
        }
        if (value == parent.getRightChild().getValue()) {
            return true;
        } else {
            return false;
        }
    }
}
