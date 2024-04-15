package com.xiaoruiit.data_structure.stack;

import java.util.Stack;

/**
 * 最小栈
 */
public class LeetCode155 {

    public static void main(String[] args) {

    }

    class MinStack {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public MinStack() {
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(minStack.peek(), val));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
