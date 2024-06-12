package com.xiaoruiit.algorithm.dp;

/**
 * 最长回文子序列
 * tags: ['动态规划','子序列']
 * @author hanxiaorui
 * @date 2024/5/30
 */
public class LeetCode516 {

    public static void main(String[] args) {
        LeetCode516 leet = new LeetCode516();
        System.out.println(leet.longestPalindromeSubseq("bbbab"));
        System.out.println(leet.longestPalindromeSubseq("cbbd"));
        System.out.println(leet.longestPalindromeSubseq("c"));

    }

    public int longestPalindromeSubseq(String s) {
         int[][] dp = new int[s.length()][s.length()];
         int res = 0;

        for (int i = s.length() - 1; i >= 0; i--) {// 从下到上
            for (int j = i; j < s.length(); j++) {// 从左到右
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i){
                        dp[i][j] = 1;
                    } else if (j - i == 1){
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}
