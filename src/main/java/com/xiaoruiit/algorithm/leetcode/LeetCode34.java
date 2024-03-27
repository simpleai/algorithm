package com.xiaoruiit.algorithm.leetcode;

import java.util.Arrays;

public class LeetCode34 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 0)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));

        System.out.println(Arrays.toString(searchRange2(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange2(new int[]{2,2}, 2)));
        System.out.println(Arrays.toString(searchRange2(new int[]{1}, 0)));
        System.out.println(Arrays.toString(searchRange2(new int[]{1}, 1)));
    }

    /**
     * LeetCode34 在排序数组中查找元素的第一个和最后一个位置
     * 两次二分算法，分别查找最低位和最高位
     * tags: ['二分查找','数组']
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if (nums == null || nums.length == 0){
            return result;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int middle = low + (high - low) / 2;
            if (nums[middle] == target && (middle == 0 || nums[middle - 1] < target)){
                result[0] = middle;
                break;
            } else if (nums[middle] < target){
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        int low2 = 0;
        int high2 = nums.length - 1;
        while (low2 <high2){
            int middle = low2 + (high2 - low2) / 2;
            if (nums[middle] == target && (middle == nums.length - 1 || nums[middle + 1] > target)){
                result[1] = middle;
                break;
            } else if (nums[middle] <= target){
                low2 = middle + 1;
            } else {
                high2 = middle - 1;
            }
        }

        return result;
    }


    /**
     * LeetCode34 在排序数组中查找元素的第一个和最后一个位置
     * 两次二分算法，分别查找最低位和最高位
     * tags: ['二分查找','数组']
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange2(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if (nums == null || nums.length == 0){
            return result;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int middle = low + (high - low) / 2;
            if (nums[middle] == target){
                result[0] = middle;
                high = middle - 1;
            } else if (nums[middle] < target){
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        int low2 = 0;
        int high2 = nums.length - 1;
        while (low2 <high2){
            int middle = low2 + (high2 - low2) / 2;
            if (nums[middle] == target){
                result[1] = middle;
                low2 = middle + 1;
            } else if (nums[middle] < target){
                low2 = middle + 1;
            } else {
                high2 = middle - 1;
            }
        }

        return result;
    }

}
