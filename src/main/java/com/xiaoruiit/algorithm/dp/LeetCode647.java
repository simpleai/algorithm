package com.xiaoruiit.algorithm.dp;

/**
 * 回文子串
 * tags: ['动态规划','子序列']
 * @author hanxiaorui
 * @date 2024/5/30
 */
public class LeetCode647 {

    public static void main(String[] args) {
        LeetCode647 leet = new LeetCode647();
        System.out.println(leet.countSubstrings("abc"));
        System.out.println(leet.countSubstrings("aaa"));
        System.out.println(leet.countSubstrings("abba"));

        System.out.println(leet.countSubstrings2("abc"));
        System.out.println(leet.countSubstrings2("aaa"));
        System.out.println(leet.countSubstrings2("abba"));
    }

    public int countSubstrings2(String s) {
        int res = 0;
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        dp[0][0] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)){
                    if (j - i <= 1){
                        res++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]){
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }

        return res;
    }

    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindromic(s, i ,j)){
                    res++;
                }
            }
        }

        return res;
    }

    public boolean isPalindromic(String s, int i, int j){
        if (i == j){
            return true;
        }

        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
