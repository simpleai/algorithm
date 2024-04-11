package com.xiaoruiit.data_structure.array;

/**
 * tags: ['滑动窗口']
 * 长度最小的子数组
 * @author hanxiaorui
 * @date 2024/4/11
 */
public class LeetCode209 {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;

        int start = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target){
                res = Math.min(res, i - start + 1);
                sum-= nums[start];
                start++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
