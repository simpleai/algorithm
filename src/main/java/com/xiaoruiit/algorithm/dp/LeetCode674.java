package com.xiaoruiit.algorithm.dp;

/**
 * 最长连续递增序列
 * tags: ['子序列']
 * 递推公式：
 * @author hanxiaorui
 * @date 2024/5/28
 */
public class LeetCode674 {
    public static void main(String[] args) {
        LeetCode674 leet = new LeetCode674();
        System.out.println(leet.findLengthOfLCIS(new int[]{1,3,5,4,7}));
        System.out.println(leet.findLengthOfLCIS(new int[]{2,2,2,2,2}));
    }

    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]){
                temp++;
                max = Math.max(max, temp);
            } else {
                temp = 1;
            }
        }

        return max;
    }
}
