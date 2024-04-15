package com.xiaoruiit.data_structure.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 反转字符串中的单词
 * 思路：慢指针标记单词起点，快指针寻找空格
 * tags: ['字符串','双指针']
 */
public class LeetCode151 {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));

        System.out.println(reverseWords2("the sky is blue"));
        System.out.println(reverseWords2("  hello world  "));
    }

    public static String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        s = s.trim();

        int start = 0, end = 0;
        while (end < s.length()){
            while (end < s.length() && s.charAt(end) != ' ') {// 找到单词之间的空格
                end++;
            }
            builder.insert(0, s.substring(start, end) + " ");

            while (end < s.length() && s.charAt(end + 1) == ' '){// 去除多余的空格
                end++;
            }
            end++;
            start = end;
        }

        return builder.substring(0, builder.length() - 1);
    }

    public static String reverseWords2(String s) {
        StringBuilder builder = new StringBuilder();
        s = s.trim();

        List<String> list = Arrays.asList(s.split(" "));
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
