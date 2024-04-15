package com.xiaoruiit.data_structure.string;

public class LeetCode459 {
    public static void main(String[] args) {
//        System.out.println(repeatedSubstringPattern2("abab"));
//        System.out.println(repeatedSubstringPattern2("ababab"));
//        System.out.println(repeatedSubstringPattern2("abcab"));
//        System.out.println(repeatedSubstringPattern2("aaaa"));
//        System.out.println(repeatedSubstringPattern2("abaababaab"));
//        System.out.println(repeatedSubstringPattern2("abac"));
        System.out.println(repeatedSubstringPattern2("babbabbabbabbab"));
    }

    public static boolean repeatedSubstringPattern2(String s) {
        for (int i = 1; i * 2 <= s.length(); i++) {
            if (s.length() % i != 0){
                continue;
            }
            boolean flag = true;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j - i)) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                return true;
            }
        }

        return false;
    }

    public static boolean repeatedSubstringPattern(String s) {
        int i = (s + s).indexOf(s, 1);

        return i != s.length();
    }
}
