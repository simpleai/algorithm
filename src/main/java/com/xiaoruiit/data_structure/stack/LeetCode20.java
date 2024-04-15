package com.xiaoruiit.data_structure.stack;

import java.util.Stack;

/**
 * 有效的括号
 */
public class LeetCode20 {

    public static void main(String[] args) {
        String[] str = {"a",")","(",")","]"};
        System.out.println(judgeBracketString(str));

        System.out.println(judgeBracketString2("()[()]"));
    }
    /**
     * 简单 LeetCode20.有效的括号
     * 思路：
     * 左括号入栈，
     * 右括号，出栈与右括号相同，继续循环；
     * 出栈与右括号不相同，返回fasle;
     * 最后判断栈是否为空
     *
     * @param s
     * @return
     */
    public static boolean judgeBracketString2(String s) {
        char[] chars = s.toCharArray();

        Stack stack = new Stack();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            } else if (chars[i] == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else if (!stack.pop().equals('(')) {
                    return false;
                }
            } else if (chars[i] == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else if (!stack.pop().equals('[')) {
                    return false;
                }
            } else if (chars[i] == '}') {
                if (stack.isEmpty()) {
                    return false;
                } else if (!stack.pop().equals('{')) {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    /**
     * LeetCode20.有效的括号
     * <p>
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：左括号必须与相同类型的右括号匹配，左括号必须以正确的顺序匹配。
     */
    public static boolean judgeBracketString(String[] str) {
        if (str == null || str.length == 0) {
            return false;
        }

        Stack stack = new Stack();
        for (int i = 0; i < str.length; i++) {
            if (judgeLeftBracket(str[i])) {
                stack.push(str[i]);
            }
            if (judgeRightBracket(str[i])) {
                if (stack.empty()) {
                    return false;
                }
                if (!judgeBracketType(str[i]).equals(stack.pop().toString())) {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    private static String judgeBracketType(String s) {
        String result = "";
        switch (s) {
            case ")":
                result = "(";
                break;
            case "]":
                result = "[";
                break;
            case "}":
                result = "{";
                break;
        }
        return result;
    }

    private static boolean judgeLeftBracket(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if ("(".equals(s) || "[".equals(s) || "{".equals(s)) {
            return true;
        }
        return false;
    }

    private static boolean judgeRightBracket(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (")".equals(s) || "]".equals(s) || "}".equals(s)) {
            return true;
        }
        return false;
    }
}
