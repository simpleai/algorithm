package com.xiaoruiit.data_structure.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串算法题
 */
public class StringProblem {

    /**
     * LeetCode 第 242 题：给定两个字符串 s 和 t，编写一个函数来判断 t 是否是 s 的字母异位词。
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

    /**
     * 字符串匹配，主串是否包含模式串
     */
    public static boolean judgeContainPattern(String majorString, String patternString){
        if (majorString == null || patternString == null || patternString.length() == 0 || majorString.length() < patternString.length()){
            return false;
        }

        for (int i = 0; i < majorString.length() - patternString.length() + 1; i++) {
            if (majorString.charAt(i) == patternString.charAt(0)){
                int match = 1;// 记录匹配长度
                for (int j = 1; j < patternString.length() ; j++) {
                    if (majorString.charAt(i+j) != patternString.charAt(j)){
                        break;
                    }
                    match++;
                }
                if (match == patternString.length()){// 匹配长度等于模式串时，说明主串包含模式串
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 两个字符串的最大公共子串
     */
    public static String maxPattern(String a, String b){
        if (a == null || b == null || b.length() == 0 || a.length() == 0){
            return null;
        }
        String maxString = "";// 最大串

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                String tempString = "";// 单次遍历中的最大串
                if (a.charAt(i) == b.charAt(j)){
                    tempString += a.charAt(i);
                    for (int m = i+1, n=j+1; m < a.length() && n < b.length(); m++,n++) {
                        if (a.charAt(m) == b.charAt(n)){
                            tempString += a.charAt(m);
                        }else {
                            break;
                        }
                    }
                    if (maxString.length() < tempString.length()){
                        maxString = tempString;
                    }
                }
            }
        }
        return maxString;
    }
}
