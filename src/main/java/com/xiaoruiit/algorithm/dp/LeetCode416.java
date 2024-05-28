package com.xiaoruiit.algorithm.dp;

/**
 * 选择一些元素，使得和 = sum(nums) / 2
 * tags: ['01背包','动态规划']
 */
public class LeetCode416 {
    public static void main(String[] args) {
        LeetCode416 leet = new LeetCode416();
        System.out.println(leet.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(leet.canPartition(new int[]{1, 2, 3, 5}));
    }

    public boolean canPartition(int[] nums) {
        if (nums.length == 1){
            return false;
        }

        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(nums[i], max);
        }
        if (sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        if (target < max){
            return false;
        }

        boolean[][] dp = new boolean[nums.length][target + 1];// 从下标[0-i]中任意选数，和为j，是否可以实现。
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;// n个数都不选，和为0的结果
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j < nums[i]){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]]; // 0到i-1的和 = j,或 0到i-1的和为 j-nums[i]时，0到i的和可以为j
                }
            }
        }

        return dp[nums.length - 1][target];
    }
}
