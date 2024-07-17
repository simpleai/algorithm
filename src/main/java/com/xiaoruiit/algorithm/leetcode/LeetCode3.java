package com.xiaoruiit.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode3 {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwke"));
//        System.out.println(lengthOfLongestSubstring("cdd"));
//        System.out.println(lengthOfLongestSubstring("dvdf"));
//        System.out.println(lengthOfLongestSubstring("abba"));

        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
    }

    /**
     * LeetCode3 无重复字符的最长子串
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int slow = 0, fast = 0; fast < charArray.length; fast++) {
            if (map.containsKey(charArray[fast])){
                // 从左到右移除map中的元素，直到把相等前和相等的元素都移除
                while (charArray[slow] != charArray[fast]){// 相等前的所有元素
                    map.remove(charArray[slow]);
                    slow++;
                }
                map.remove(charArray[slow]);// 相等的元素
                slow++;
            }

            map.put(charArray[fast], fast);
            max = Math.max(max, map.size());
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {// abcabcbb
        if (s.length() == 1){
            return 1;
        }
        int left = 0, right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            max = Math.max(max, right - left + 1);
            map.put(s.charAt(right), right);
            right++;
        }
        return max;
    }
}
