package com.xiaoruiit.data_structure.string;

import java.util.Arrays;

/**
 * 反转字符串
 * tags: ['字符串','双指针']
 * 思路：交换首尾; 首++，尾--;
 * @author hanxiaorui
 * @date 2024/4/12
 */
public class LeetCode344 {

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        reverseString(chars);
        System.out.println(Arrays.toString(chars));

    }

    public static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}
