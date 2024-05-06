package com.xiaoruiit.algorithm.dp;

/**
 * 打家劫舍
 * @author hanxiaorui
 * @date 2024/4/25
 */
public class LeetCode198 {

    public static void main(String[] args) {
        LeetCode198 leet = new LeetCode198();
        System.out.println(leet.rob(new int[]{1,2,3,1}));
        System.out.println(leet.rob(new int[]{2,7,9,3,1}));
    }

    /**
     * fn = max ( nums[n-1] + fn-3, fn-2)
     * 可改为滚动数组
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        } else if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

}
