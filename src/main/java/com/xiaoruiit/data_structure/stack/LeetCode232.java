package com.xiaoruiit.data_structure.stack;

import java.util.Stack;

public class LeetCode232 {

    /**
     * LeetCode.232用栈实现队列
     */
    class MyQueue {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            while (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
            stack.push(x);
            while (!stack2.isEmpty()) {
                stack.push(stack2.pop());
            }
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.empty();
        }
    }
}
