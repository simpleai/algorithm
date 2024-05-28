package com.xiaoruiit.algorithm.dp;

/**
 * 最长递增子序列
 * tags: ['子序列','动态规划']
 * 递推公式： dp[i] = max(dp( 0至(i - 1)) + 1
 * @author hanxiaorui
 * @date 2024/5/28
 */
public class LeetCode300 {
    public static void main(String[] args) {
        LeetCode300 leet = new LeetCode300();
//        System.out.println(leet.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
//        System.out.println(leet.lengthOfLIS(new int[]{0,1,0,3,2,3}));
//        System.out.println(leet.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(leet.lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];// 位置i的最大子序列长度
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);// 位置i的最长子序列 = 从0到i-1各个位置最长升序子序列+1 中的最大值
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
