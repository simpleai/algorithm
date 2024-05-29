package com.xiaoruiit.algorithm.dp;

/**
 * 两个字符串的删除操作
 * 先求出最长公共子序列；res = word1.length() + word2.length() - 2 * 最长公共子序列
 * tags: ['子序列','动态规划']
 */
public class LeetCode583 {

    public static void main(String[] args) {
        LeetCode583 leet = new LeetCode583();
        System.out.println(leet.minDistance("sea", "eat"));
        System.out.println(leet.minDistance("leetcode","etco"));
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i < word1.length() + 1; i++) {
            char ch1 = word1.charAt(i - 1);
            for (int j = 1; j < word2.length() + 1; j++) {
                char ch2 = word2.charAt(j - 1);
                if (ch1 == ch2){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
}
