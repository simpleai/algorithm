package com.xiaoruiit.algorithm.leetcode;

/**
 * 零钱兑换 II
 * 等于，结果++
 * 大于，return
 * 小于，增加数额
 */
public class LeetCode518 {

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1,2,5}));;
    }

    static int result = 0;
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    private static void dfs(int amount, int[] coins, int cur) {
        if (cur == amount){
            result++;
            return;
        } else if (cur > amount){
            return;
        } else {
            for (int i = 0; i < coins.length; i++) {
                cur = cur + coins[i];
                dfs(amount, coins, cur);
                cur = cur - coins[i];
            }
        }
    }
}
