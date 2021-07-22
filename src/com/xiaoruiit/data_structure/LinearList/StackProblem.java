package com.xiaoruiit.data_structure.LinearList;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 栈算法题
 */
public class StackProblem {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。有效字符串需满足：左括号必须与相同类型的右括号匹配，左括号必须以正确的顺序匹配。
     */
    public static boolean judgeBracketString(String[] str){
        if (str == null || str.length == 0){
            return false;
        }

        Stack stack = new Stack();
        for (int i = 0; i < str.length; i++) {
            if (judgeLeftBracket(str[i])){
                stack.push(str[i]);
            }
            if (judgeRightBracket(str[i])){
                if (stack.empty()){
                    return false;
                }
                if (!judgeBracketType(str[i]).equals(stack.pop().toString())){
                    return false;
                }
            }
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }

    private static String judgeBracketType(String s) {
        String result = "";
        switch (s){
            case ")":
                result= "(";
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
        if (s == null || s.length() == 0){
            return false;
        }
        if ("(".equals(s) || "[".equals(s) || "{".equals(s)){
            return true;
        }
        return false;
    }

    private static boolean judgeRightBracket(String s) {
        if (s == null || s.length() == 0){
            return false;
        }
        if (")".equals(s) || "]".equals(s) || "}".equals(s)){
            return true;
        }
        return false;
    }

    /**
     * 给定一个包含 n 个元素的链表，现在要求每 k 个节点一组进行翻转，打印翻转后的链表结果。其中，k 是一个正整数，且 n 可被 k 整除。
     * 例如，链表为 1 -> 2 -> 3 -> 4 -> 5 -> 6，k = 3，则打印 321654。
     */
    public static void reverserLinkedList(Node node,int k){
        // TODO
        Stack<Node> stack = new Stack<Node>();
        int count = 0;
        while (node != null){
            stack.push(node);
            count++;
            if (count == k){
                while (!stack.empty()){
                    System.out.println(stack.pop().data);
                }
                count = 0;
            }
            node = node.next;
        }
    }
}
