package com.xiaoruiit.data_structure.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串算法题
 */
public class StringProblem {
    public static void main(String[] args) {
        /*
        // 主串是否包含模式串
        String major = "abcefdefgh";
        String pattern = "efg";
        System.out.println(StringProblem.judgeContainPattern(major,pattern));
        */

        // 两个串的最大子串
        String a = "abcefdefgh";
        String b = "aefgab";
        System.out.println(StringProblem.maxPattern(a,b));

        // leetCode242
        String s = "abcdef";
        String t = "abdcfe";
        System.out.println(StringProblem.leetCode242(s,t));

        // leetCode 3.无重复字符的最长子串
        System.out.println(StringProblem.leetCode3("abcdaefbcdg"));
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

    /**
     * LeetCode 3.给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
     *
     * abcdaefbcdg
     *
     * 分析：
     *  快慢指针，已经存在，从慢指针开始删除。
     *  map查找是否已经存在。
     *
     *  遍历，
     *      如果map中存在，从慢指针处开始删除，直到不重复。
     *      将每个字母加入到map中。
     *      维护map的最大值，遍历完成后，返回最大值。
     */
    public static int leetCode3(String str){
        if (str.length() == 0){
            return 0;
        }
        char[] chars = str.toCharArray();
        Map map = new HashMap();// 存已经遍历过的字符串，重复时根据slow慢指针删除
        map.put(chars[0],0);
        int max = map.size();// 记录遍历过程中map长度的最大值
        for (int slow = 0,fast = 1; fast < chars.length; fast++) {
            if (map.containsKey(chars[fast])){
                while(chars[slow] != chars[fast]){
                    map.remove(chars[slow]);
                    slow++;
                }
                map.remove(chars[slow]);
                slow++;
            }
            map.put(chars[fast],fast);
            max = max > map.size() ? max : map.size();
        }
        return max;
    }
}
