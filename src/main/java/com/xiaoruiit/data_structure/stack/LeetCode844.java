package com.xiaoruiit.data_structure.stack;

import java.util.Stack;

/**
 * 比较含退格的字符串
 */
public class LeetCode844 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("#abc", "abc"));
        System.out.println(backspaceCompare("ab#c", "ac#c"));
        System.out.println(backspaceCompare("ab", "ac"));
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (stack.empty()) {
                    continue;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        Stack<Character> stack2 = new Stack<>();
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (stack2.empty()) {
                    continue;
                }
                stack2.pop();
            } else {
                stack2.push(c);
            }
        }

        if (stack.size() != stack2.size()) {
            return false;
        }

        while (!stack.isEmpty() && !stack2.isEmpty()) {
            if (stack.pop() != stack2.pop()) {
                return false;
            }
        }
        return true;
    }
}
