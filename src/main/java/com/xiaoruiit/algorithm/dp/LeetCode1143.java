package com.xiaoruiit.algorithm.dp;

/**
 * 最长公共子序列
 * tags: ['字符串','动态规划']
 */
public class LeetCode1143 {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("abcbdab","bdcaba"));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < text1.length() + 1; i++) {
            char ch1 = text1.charAt(i - 1);
            for (int j = 1; j < text2.length() + 1; j++) {
                char ch2 = text2.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i] [j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
