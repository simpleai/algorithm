package com.xiaoruiit.algorithm.dp;

/**
 *
 * @see LeetCode198
 * @author hanxiaorui
 * @date 2024/5/13
 */
public class LeetCode740 {
    public static void main(String[] args) {
        LeetCode740 leet = new LeetCode740();
        System.out.println(leet.deleteAndEarn(new int[]{3,4,2}));
        System.out.println(leet.deleteAndEarn(new int[]{2,2,3,3,3,4}));
        System.out.println(leet.deleteAndEarn(new int[]{1}));
        System.out.println(leet.deleteAndEarn(new int[]{1,1}));
        System.out.println(leet.deleteAndEarn(new int[]{1,2}));
    }


    public int deleteAndEarn(int[] nums) {
        int maxValue = 0;
        for (int i = 0; i < nums.length; i++) {
            maxValue = Math.max(maxValue, nums[i]);
        }

        maxValue = Math.max(maxValue, 2);

        int[] arr = new int[maxValue + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += nums[i];
        }

        int a = arr[0], b = Math.max(arr[0], arr[1]), max = 0;
        for (int i = 2; i < arr.length; i++) {
            max = Math.max(arr[i] + a, b);
            a = b;
            b = max;

        }

        return max;
    }

}
