package com.xiaoruiit.algorithm.dp;

import java.util.Arrays;

/**
 * 抽象成01背包：分成重量最接近的两堆
 * tags: ['01背包','动态规划']
 */
public class LeetCode1049 {
    public static void main(String[] args) {
        LeetCode1049 leet = new LeetCode1049();
        System.out.println(leet.lastStoneWeightII(new int[]{2,7,4,1,8,1}));
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;

        int[][] dp = new int[stones.length + 1][target + 1];// 从 0到i中选择任意数，重量为j时的最大重量

        for (int i = 1; i < stones.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j < stones[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }

        return sum - 2 * dp[stones.length][target];
    }
}
