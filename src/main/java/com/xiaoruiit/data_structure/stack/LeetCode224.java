package com.xiaoruiit.data_structure.stack;

import java.util.Stack;

/**
 * 基本计算器
 */
public class LeetCode224 {

    public static void main(String[] args) {
        System.out.println("leetCode224:" + calculateSimple("2-1 + 2"));
        System.out.println("leetCode224:" + calculateSimple("-1+2-1"));

        System.out.println(calculate2("-5"));
        System.out.println(calculate2("2 - 1 + 2"));
        System.out.println(calculate2("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate2("2147483647"));
        System.out.println(calculate2("1-(     -2)"));
        System.out.println(calculate2("(1+2)"));
    }
    /**
     * 1. 处理 空格; （0 → （-0 ;第一个字符是 - ,前边填充0；
     * 3. 每次添加数字后，进行计算；遇到 ) ，需要将提前加入的 ( 弹出，如果 ( 弹出后下一个是操作符，进行计算；
     */

    public static int calculate2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String str = s.replace(" ", "").replace("(-", "(0-");
        if (str.charAt(0) == '-') {
            str = "0".concat(str);
        }
        char[] charArray = str.toCharArray();
        Stack<Character> stackOpt = new Stack<>();
        Stack<Integer> stackInt = new Stack<>();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(' || charArray[i] == '+' || charArray[i] == '-') {
                stackOpt.push(charArray[i]);
            } else if (Character.isDigit(charArray[i])) {
                // 数字处理 '218' → 218
                int num = Character.getNumericValue(charArray[i]);
                while (i + 1 < charArray.length && Character.isDigit(charArray[i + 1])) {
                    num = num * 10 + Character.getNumericValue(charArray[i + 1]);
                    i++;
                }
                stackInt.push(num);

                // 计算
                calc(stackOpt, stackInt);
            } else {// charArray[i] == ')'
                stackOpt.pop();// （ 出栈
                // 计算
                calc(stackOpt, stackInt);
            }
        }

        return stackInt.pop();
    }

    public static void calc(Stack<Character> stackOpt, Stack<Integer> stackInt) {
        if (stackInt.empty() || stackInt.size() < 2) {
            return;
        }

        if (stackOpt.peek() == '+') {
            stackInt.push(stackInt.pop() + stackInt.pop());
            stackOpt.pop();
        } else if (stackOpt.peek() == '-') {
            Integer pop = stackInt.pop();
            stackInt.push(stackInt.pop() - pop);
            stackOpt.pop();
        }

//        if (stackOpt.isEmpty() || stackOpt.peek() == '('){
//            return;
//        }
    }

    /**
     * LeetCode224.基本计算器
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.replace(" ", "").toCharArray();
        Stack<Object> stack = new Stack<>();
        if (Character.isDigit(chars[0])) {
            stack.push(0);
            stack.push('+');
        } else if ('-' == chars[0]) {
            stack.push(0);
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '-' && !stack.isEmpty()) {
                if (stack.peek() instanceof Character && '(' == (Character) stack.peek()) {
                    stack.push(0);
                }
            }
            if (chars[i] == '+' || chars[i] == '(' || chars[i] == '-') {
                stack.push(chars[i]);
            } else if (chars[i] == ')') {
                String str = String.valueOf(stack.pop());
                Integer i1 = Integer.valueOf(str);
                stack.pop();
                if (!stack.isEmpty()) {
                    if ('(' == (Character) stack.peek()) {
                        stack.pop();
                        stack.push(i1);
                    } else {
                        Character pop = (Character) stack.pop();// 必定是操作符
                        Integer i2 = Integer.valueOf(String.valueOf(stack.pop()));
                        if (pop == '+') {
                            stack.push(i2 + i1);
                        } else {
                            stack.push(i2 - i1);
                        }
                    }
                } else {
                    stack.push(i1);
                }
            } else {// 数字
                int temp = 0;
                Stack<Integer> stackInt = new Stack<>();
                stackInt.push(Character.getNumericValue(chars[i]));
                while (i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
                    stackInt.push(Character.getNumericValue(chars[i + 1]));
                    i++;
                }
                temp += stackInt.pop();
                int wei = 1;
                int j = 0;
                while (!stackInt.isEmpty()) {
                    wei *= 10;
                    temp += stackInt.pop() * wei;
                    j++;
                }

                // 栈顶是 ( 或 操作符 +-
                if (stack.isEmpty() || '(' == (Character) stack.peek()) {
                    stack.push(temp);
                } else {// 操作符
                    Character pop = (Character) stack.pop();
                    Integer i1 = (Integer) stack.pop();
                    if ('+' == pop) {
                        stack.push(i1 + temp);
                    } else {
                        stack.push(i1 - temp);
                    }
                }
            }
        }

        return (Integer) stack.pop();
    }


    /**
     * LeetCode224.基本计算器 简化
     *
     * @param s
     * @return
     */
    public static int calculateSimple(String s) {
        char[] chars = s.replace(" ", "").toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push('+');
        Stack<Integer> stackInt = new Stack<>();
        stackInt.push(0);

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+' || chars[i] == '-') {
                stack.push(chars[i]);
            } else {
                Character ch = stack.pop();
                Integer integer = stackInt.pop();
                Integer i1 = Integer.valueOf(String.valueOf(chars[i]));
                if (ch == '+') {
                    stackInt.push(integer + i1);
                } else if (ch == '-') {
                    stackInt.push(integer - i1);
                }
            }
        }

        return stackInt.pop();
    }
}
