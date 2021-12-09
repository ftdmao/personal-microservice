package com.mjw.offer;

import java.util.Iterator;
import java.util.Stack;

/**
 * 9 用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class CQueue_9 {

    Stack stack1;
    Stack stack2;

    public CQueue_9() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.size() <= 0) {
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                stack2.push(stack1.pop());
            }
            if(stack2.size()<=0){
                return -1;
            }else {
                return (int) stack2.pop();
            }
        } else {
            return (int) stack2.pop();
        }
    }

}
