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
    }

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
            max = max > map.size() ? max : map.size();
        }
        return max;
    }
}
