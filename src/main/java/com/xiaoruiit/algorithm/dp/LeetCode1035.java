package com.xiaoruiit.algorithm.dp;

/**
 * 不相交的线
 * tags: ['子序列','动态规划']
 */
public class LeetCode1035 {
    public static void main(String[] args) {
        LeetCode1035 leet = new LeetCode1035();
        System.out.println(leet.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        System.out.println(leet.maxUncrossedLines(new int[]{1, 5, 3, 4}, new int[]{1, 3, 4, 5}));
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(dp[i][j], max);
            }
        }

        return max;
    }
}
