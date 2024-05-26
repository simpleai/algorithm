package com.xiaoruiit.algorithm.dp;

/**
 * 一和零
 * tags: ['01背包','动态规划']
 */
public class LeetCode474 {
    public static void main(String[] args) {
        LeetCode474 leet = new LeetCode474();
        System.out.println(leet.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        // i:数组长度；j:0的容量；k:1的容量
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 1; i < strs.length + 1; i++) {
            String str = strs[i - 1];
            int zeros = getChs(str, '0');
            int ones = getChs(str, '1');

            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (j < zeros || k < ones){
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1); // 不选 和 选择 + 1 哪个大
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    public static int getChs(String str, char ch){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch){
                count++;
            }
        }
        return count;
    }
}
