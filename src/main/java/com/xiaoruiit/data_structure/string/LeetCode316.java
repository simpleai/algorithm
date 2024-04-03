package com.xiaoruiit.data_structure.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 去除重复字母 https://leetcode.cn/problems/remove-duplicate-letters/description/
 * @author hanxiaorui
 * @date 2024/4/3
 */
public class LeetCode316 {

    public static void main(String[] args) {
        String s = "bcabc"; // "abc"
        String s2 = "cbacdcbc"; // "acdb"
        String s3 = "bbcaac"; // "bac"
        String s4 = "abacb"; // "abc"
        System.out.println(removeDuplicateLetters(s));
        System.out.println(removeDuplicateLetters(s2));
        System.out.println(removeDuplicateLetters(s3));
        System.out.println(removeDuplicateLetters(s4));
    }
    public static String removeDuplicateLetters(String s) {
        String result = "";
        char[] charArray = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        Map<Character, Integer> map = new HashMap<>();// 字符出现次数
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char ch : charArray) {
            while (!stack.isEmpty() && ch < stack.peek() && map.get(stack.peek()) > 0 && !stack.contains(ch)){
                stack.pop();
            }
            if (stack.isEmpty() || !stack.contains(ch) || (ch > stack.peek() && !stack.contains(ch)) ){
                stack.add(ch);
            }
            map.put(ch, map.get(ch) - 1);
        }

        while (!stack.empty()){
            result = stack.pop() + result;
        }
        return result;
    }
}
