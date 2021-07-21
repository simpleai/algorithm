package com.xiaoruiit.data_structure.LinearList;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 栈算法题
 */
public class StackProblem {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。有效字符串需满足：左括号必须与相同类型的右括号匹配，左括号必须以正确的顺序匹配。
     */
    public static boolean judgeBracketString(LinkedList<String> bracket){
        if (bracket == null || bracket.size() == 0 || bracket.size() % 2 == 1){
            return false;
        }
        Stack stack = new Stack();
        for (int i = 0; i < bracket.size(); i++) {
            if (judgeLeftBracket(bracket.get(i))){
                stack.push(bracket.get(i));
            }
            if (judgeRightBracket(bracket.get(i))){

            }

        }
        return false;
    }

    private static boolean judgeRightBracket(String s) {
        return false;
    }

    private static boolean judgeLeftBracket(String str) {
        return false;
    }
}
