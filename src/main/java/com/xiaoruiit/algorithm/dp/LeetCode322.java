package com.xiaoruiit.algorithm.dp;

import java.util.Arrays;

/**
 * 零钱兑换
 * tag: ['动态规划','完全背包']
 * @author hanxiaorui
 * @date 2024/5/15
 */
public class LeetCode322 {
    public static void main(String[] args) {
        LeetCode322 leet = new LeetCode322();
        System.out.println(leet.coinChange(new int[]{1,2,5}, 11));
        System.out.println(leet.coinChange2(new int[]{2,1,5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

}
