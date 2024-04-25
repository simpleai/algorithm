package com.xiaoruiit.algorithm.dp;

/**
 * 使用最小花费爬楼梯
 * tags: ['动态规划', '滚动数组']
 * @author hanxiaorui
 * @date 2024/4/23
 */
public class LeetCode746 {
    public static void main(String[] args) {
        LeetCode746 leet = new LeetCode746();
        System.out.println(leet.minCostClimbingStairs(new int[] {10,15,20}));
        System.out.println(leet.minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}));

        System.out.println(leet.minCostClimbingStairs2(new int[] {10,15,20}));
        System.out.println(leet.minCostClimbingStairs2(new int[] {1,100,1,1,1,100,1,1,100,1}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }

    /**
     * 滚动数组
     * @param cost
     * @return
     */
    public int minCostClimbingStairs2(int[] cost) {
        int curr = 0 , pre = 0, next = 0;
        for (int i = 2; i <= cost.length; i++) {
            next = Math.min(curr + cost[i - 1], pre + cost[i - 2]);
            pre= curr;
            curr = next;
        }

        return next;
    }
}
