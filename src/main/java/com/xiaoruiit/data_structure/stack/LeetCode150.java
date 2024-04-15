package com.xiaoruiit.data_structure.stack;

import java.util.Objects;
import java.util.Stack;

public class LeetCode150 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (isNumber(tokens[i])) {
                stack.push(Long.valueOf(tokens[i]));
            } else {
                Long pop = stack.pop();
                if (Objects.equals(tokens[i], "+")) {
                    stack.push(stack.pop() + pop);
                } else if (Objects.equals(tokens[i], "-")) {
                    stack.push(stack.pop() - pop);
                } else if (Objects.equals(tokens[i], "*")) {
                    stack.push(stack.pop() * pop);
                } else if (Objects.equals(tokens[i], "/")) {
                    stack.push(stack.pop() / pop);
                }
            }
        }

        return stack.pop().intValue();
    }

    private static boolean isNumber(String token) {
        return !(Objects.equals(token, "+") || token.equals("-") || token.equals("*") || Objects.equals(token, "/"));
    }

}
