package com.xiaoruiit.algorithm.dp;

/**
 * tags: ['子序列','动态规划']
 */
public class LeetCode115 {
    public static void main(String[] args) {
        LeetCode115 leet = new LeetCode115();
        System.out.println(leet.numDistinct("rabbbit", "rabbbit"));
        System.out.println(leet.numDistinct("babgbag", "bag"));
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
