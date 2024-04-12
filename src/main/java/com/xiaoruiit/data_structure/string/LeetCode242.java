package com.xiaoruiit.data_structure.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hanxiaorui
 * @date 2024/4/12
 */
public class LeetCode242 {

    public static void main(String[] args) {
        // leetCode242
        String s = "abcdef";
        String t = "abdcfe";
        System.out.println(leetCode242(s,t));
    }
    /**
     * LeetCode 242.给定两个字符串 s 和 t，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 示例 1
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     *
     * 示例 2
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     * 解析：两个字符串中，每个字符出现的字符次数是否相等
     */

    public static boolean leetCode242(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() != 0){
                return false;
            }
        }
        return true;
    }
}
