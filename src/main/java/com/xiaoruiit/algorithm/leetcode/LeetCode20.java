package com.xiaoruiit.algorithm.leetcode;

import java.util.Stack;

public class LeetCode20 {
    public static void main(String[] args) {
        System.out.println(isValid("{"));
        System.out.println(isValid("}"));
        System.out.println(isValid("({})"));
        System.out.println(isValid("({}"));
    }

    /**
     * LeetCode20 有效的括号
     * tags: ['栈','字符串']
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            if (isLeft(charArray[i])) {
                stack.add(charArray[i]);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if (!isMatch(pop, charArray[i])) {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }

    private static boolean isMatch(Character pop, char c) {
        if (pop.equals('[') && c == ']') {
            return true;
        }
        if (pop.equals('(') && c == ')') {
            return true;
        }
        if (pop.equals('{') && c == '}') {
            return true;
        }
        return false;
    }

    public static boolean isLeft(Character ch) {
        if (ch.equals('[') || ch.equals('(') || ch.equals('{')) {
            return true;
        }
        return false;
    }
}
