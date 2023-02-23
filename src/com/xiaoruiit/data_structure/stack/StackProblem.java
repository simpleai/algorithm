package com.xiaoruiit.data_structure.stack;

import com.xiaoruiit.data_structure.LinkedList.ListNode;

import java.util.Stack;

/**
 * 栈算法题
 */
public class StackProblem {

    public static void main(String[] args) {
        System.out.println(judgeBracketString2("()[()]"));
    }

    /**
     * 简单 LeetCode 20.有效的括号
     * 思路：
         * 左括号入栈，
         * 右括号，出栈与右括号相同，继续循环；
         *       出栈与右括号不相同，返回fasle;
         *  最后判断栈是否为空
     * @param s
     * @return
     */
    public static boolean judgeBracketString2(String s){
        char[] chars = s.toCharArray();

        Stack stack = new Stack();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                stack.push(chars[i]);
            } else if (chars[i] == ')'){
                if (stack.isEmpty()){
                    return false;
                } else if (!stack.pop().equals('(') ){
                    return false;
                }
            } else if(chars[i] == ']'){
                if (stack.isEmpty()){
                    return false;
                } else if (!stack.pop().equals('[') ){
                    return false;
                }
            } else if(chars[i] == '}'){
                if (stack.isEmpty()){
                    return false;
                } else if (!stack.pop().equals('{') ){
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
     * LeetCode 20.有效的括号
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

    /**
     * 给定一个包含 n 个元素的链表，现在要求每 k 个节点一组进行翻转，打印翻转后的链表结果。其中，k 是一个正整数，且 n 可被 k 整除。
     * 例如，链表为 1 -> 2 -> 3 -> 4 -> 5 -> 6，k = 3，则打印 321654。
     */
    public static void reverserLinkedList(ListNode node, int k) {
        if (node == null || k < 1) {
            return;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        int count = 0;
        while (node != null) {
            stack.push(node);
            count++;
            if (count == k) {
                while (!stack.empty()) {
                    System.out.println(stack.pop().val);
                }
                count = 0;
            }
            node = node.next;
        }
    }

    /**
     * leetCode739.每日温度
     * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     * <p>
     * 输入: temperatures = [30,40,50,60]
     * 输出: [1,1,1,0]
     */
    public static int[] everydayTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                result[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return result;
    }

}
