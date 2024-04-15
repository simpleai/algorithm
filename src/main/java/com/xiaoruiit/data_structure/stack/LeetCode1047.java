package com.xiaoruiit.data_structure.stack;

import java.util.LinkedList;

/**
 * 删除字符串中的所有相邻重复项
 */
public class LeetCode1047 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (!list.isEmpty()) {
                if (s.charAt(i) == list.peekLast()) {
                    list.pollLast();
                    continue;
                }
            }
            list.add(s.charAt(i));
        }

        StringBuffer str = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            str.append(list.get(i));
        }

        return str.toString();
    }
}
