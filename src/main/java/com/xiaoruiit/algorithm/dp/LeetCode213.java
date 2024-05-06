package com.xiaoruiit.algorithm.dp;

/**
 * 打家劫舍 II
 * @author hanxiaorui
 * @date 2024/4/25
 */
public class LeetCode213 {
    public static void main(String[] args) {
        LeetCode213 leet = new LeetCode213();
//        System.out.println(leet.rob(new int[]{2,3,2}));
//        System.out.println(leet.rob(new int[]{1,2,3,1}));
//        System.out.println(leet.rob(new int[]{1,2,1,1}));
//        System.out.println(leet.rob(new int[]{2,1,1,2}));
        System.out.println(leet.rob(new int[]{1,3,1,3,100}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        } else if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3){
            return Math.max(nums[2], Math.max(nums[0], nums[1]));
        }

        int p = nums[0];
        int q = Math.max(nums[0], nums[1]);
        int max1 = 0;

        for (int i = 2; i < nums.length - 1; i++) {
            max1 = Math.max(p + nums[i], q);
            p = q;
            q = max1;
        }

        p = nums[1];
        q = Math.max(nums[1], nums[2]);
        int max2 = 0;
        for (int i = 3; i < nums.length; i++) {
            max2 = Math.max(p + nums[i], q);
            p = q;
            q = max2;
        }

        return Math.max(max1, max2);
    }
}
