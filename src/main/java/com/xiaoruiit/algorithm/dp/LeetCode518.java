package com.xiaoruiit.algorithm.dp;

/**
 * 零钱兑换 II
 * 组合：重复的算同一种
 * f(n) += f(n-coin[i)
 * tags: ['完全背包','动态规划']
 */
public class LeetCode518 {
    public static void main(String[] args) {
        LeetCode518 leet = new LeetCode518();
        System.out.println(leet.change(5, new int[]{1,2,5}));
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

}
