package com.xiaoruiit.algorithm.dp;

/**
 * 最大子数组和
 * @author hanxiaorui
 * @date 2024/4/8
 */
public class LeetCode53 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{-2, 1}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));

        System.out.println(maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray2(new int[]{1}));
        System.out.println(maxSubArray2(new int[]{-2, 1}));
        System.out.println(maxSubArray2(new int[]{5,4,-1,7,8}));

        System.out.println(maxSubArray3(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray3(new int[]{1}));
        System.out.println(maxSubArray3(new int[]{-2, 1}));
        System.out.println(maxSubArray3(new int[]{5,4,-1,7,8}));
    }

    public static int maxSubArray2(int[] nums) {
        int res = Integer.MIN_VALUE;

        int preMax = 0;
        for (int i = 0; i < nums.length; i++) {
            preMax = Math.max(preMax + nums[i], nums[i]);// 前缀和最大值
            res = Math.max(res, preMax);
        }

        return res;
    }
    public static int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;

        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
            res = Math.max(res, dp[i][i]);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = dp[i][j - 1] + dp[j][j];
                res = Math.max(res, dp[i][j]);
            }
        }


        return res;
    }
    public static int maxSubArray3(int[] nums) {
        int preMax = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMax = Math.max(preMax + nums[i], nums[i]);
            res = Math.max(preMax, res);
        }

        return res;
    }
}
