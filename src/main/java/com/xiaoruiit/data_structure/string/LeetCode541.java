package com.xiaoruiit.data_structure.string;

/**
 * @author hanxiaorui
 * @date 2024/4/12
 */
public class LeetCode541 {
    public static void main(String[] args) {
//        System.out.println(reverseStr("abcdefg", 2));
//        System.out.println(reverseStr("abcd", 2));
//        System.out.println(reverseStr("abcd", 4));
//        System.out.println(reverseStr("a", 1));
        System.out.println(reverseStr("abcdefg", 1));

        System.out.println(reverseStr2("abcdefg", 2));
        System.out.println(reverseStr2("abcd", 2));
        System.out.println(reverseStr2("abcd", 4));
        System.out.println(reverseStr2("a", 1));
        System.out.println(reverseStr2("abcdefg", 1));
    }

    public static String reverseStr2(String s, int k) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i += 2 * k) {
            reverse(chars, i, Math.min(i + k, s.length()) - 1);
//            if (i + k > s.length()){
//                reverse(chars, i, i + k);
//            } else {
//                reverse(chars, i, s.length());
//            }
        }

        for (int i = 0; i < chars.length; i++) {

        }
        return new String(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char t = chars[start];
            chars[start] = chars[end];
            chars[end] = t;
            start++;
            end--;
        }
    }

    public static String reverseStr(String s, int k) {
        StringBuilder builder = new StringBuilder();

        int start = 0, end = start + 2 * k - 1;
        while (start < s.length()) {
            if (end < s.length()) {
                int temp = start + (end - start) / 2;
                while (temp >= start) {
                    builder.append(s.substring(temp, temp + 1));
                    temp--;
                }
                temp = start + (end + 1 - start) / 2;
                while (temp <= end) {
                    builder.append(s.substring(temp, temp + 1));
                    temp++;
                }
            } else if (s.length() - start < k) {
                for (int i = s.length() - 1; i >= start; i--) {
                    builder.append(s.substring(i, i + 1));
                }
                break;
            } else {
                int temp = start + k;
                for (int i = temp; i > start; i--) {
                    builder.append(s.substring(i - 1, i));
                }
                while (temp < s.length()) {
                    builder.append(s.substring(temp, temp + 1));
                    temp++;
                }
                break;
            }
            start = end + 1;
            end = start + 2 * k - 1;
        }

        return builder.toString();
    }
}
