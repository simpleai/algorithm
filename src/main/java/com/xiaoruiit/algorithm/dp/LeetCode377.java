package com.xiaoruiit.algorithm.dp;

/**
 * 组合总和 Ⅳ
 * 排列：相同数，不同顺序，不算同一种
 * tags: ['完全背包','动态规划']
 */
public class LeetCode377 {
    public static void main(String[] args) {
        LeetCode377 leet = new LeetCode377();
        System.out.println(leet.combinationSum4(new int[]{1,2,3}, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if(i >= nums[j]){
                    sum += dp[i - nums[j]];
                }
            }
            dp[i] = sum;
        }

        return dp[target];
    }
}
