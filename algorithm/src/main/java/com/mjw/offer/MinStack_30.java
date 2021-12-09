package com.mjw.offer;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
public class MinStack_30 {


    Stack stack;

    Stack minStack;


    /**
     * initialize your data structure here.
     */
    public MinStack_30() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(stack.peek());
        } else {
            int min = (int) minStack.peek();
            if (x <= min) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        int x = (int) stack.peek();
        if(x == (int)minStack.peek()){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return (int) stack.peek();
    }

    public int min() {
        return (int) minStack.peek();
    }

    public static void main(String[] args) {
        MinStack_30 minStack_30 = new MinStack_30();
        minStack_30.push(0);
        minStack_30.push(1);
        minStack_30.push(0);
        minStack_30.min();
        minStack_30.pop();
        minStack_30.min();
    }

}
