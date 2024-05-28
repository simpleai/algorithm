package com.xiaoruiit.algorithm.dp;

/**
 * 最长重复子数组
 * tags: ['子序列', '动态规划']
 * dp数组: dp[i][j] 数组nums1[0到i],nums2[0到j]的相同序列长度
 * 递推公式：
 *  nums1[i] == nums2[j] 时，dp[i][j] = dp[i - 1][j - 1]  + 1
 *  否则 nums1[i] != nums2[j]  dp[i][j] = 0;
 * @author hanxiaorui
 * @date 2024/5/28
 */
public class LeetCode718 {
    public static void main(String[] args) {
        LeetCode718 leet = new LeetCode718();
        System.out.println(leet.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
        System.out.println(leet.findLength(new int[]{0,0,0,0,0}, new int[]{0,0,0,0,0}));
        System.out.println(leet.findLength(new int[]{0,0,0,0,1}, new int[]{1,0,0,0,0}));
        System.out.println(leet.findLength(new int[]{0,0,0,0,0,0,1,0,0,0}, new int[]{0,0,0,0,0,0,0,1,0,0}));

        System.out.println("-----");

        System.out.println(leet.findLength2(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
        System.out.println(leet.findLength2(new int[]{0,0,0,0,0}, new int[]{0,0,0,0,0}));
        System.out.println(leet.findLength2(new int[]{0,0,0,0,1}, new int[]{1,0,0,0,0}));
        System.out.println(leet.findLength2(new int[]{0,0,0,0,0,0,1,0,0,0}, new int[]{0,0,0,0,0,0,0,1,0,0}));
    }

    public int findLength(int[] nums1, int[] nums2) {
        int maxequalLength = 0;
        int equalLength = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length && i < nums1.length; j++) {
                int k = 0;
                while (i + k < nums1.length && j + k < nums2.length && nums1[i + k] == nums2[j + k]){
                    equalLength++;
                    k++;
                }
                maxequalLength = Math.max(maxequalLength, equalLength);
                equalLength = 0;
            }
        }

        return maxequalLength;
    }

    public int findLength2(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int maxequalLength = 0;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxequalLength = Math.max(maxequalLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxequalLength;
    }
}
