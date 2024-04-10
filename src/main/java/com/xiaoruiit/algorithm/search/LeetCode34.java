package com.xiaoruiit.algorithm.search;

import java.util.Arrays;

/**
 * tags: ['二分查找']
 * @author hanxiaorui
 * @date 2024/4/10
 */
public class LeetCode34 {

    public static void main(String[] args) {
        // leetCode 34.在排序数组中查找元素的第一个和最后一个位置
        System.out.println(Arrays.toString(leetCode34(new int[]{5,7,7,8,8,10}, 6)));
    }

    /**
     * leetCode 34.在排序数组中查找元素的第一个和最后一个位置
     * <p>
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * <p>
     * 时间复杂度为 O(log n)
     */
    public static int[] leetCode34(int[] nums, int target) {
        int[] result = new int[2];
        // 校验
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]){
            return new int[] {-1,-1};
        }

        // 开始位置
        int low = 0;
        int high = nums.length - 1;
        result[0] = leetCode34RecursionStart(nums, target, low, high);

        // 结束位置
        result[1] = leetCode34RecursionEnd(nums, target, low, high);

        return result;
    }

    private static int leetCode34RecursionEnd(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = low + (high - low) / 2;
        if (nums[middle] == target&& (middle == nums.length-1 || nums[middle + 1] > target)) {
            return middle;
        } else if (nums[middle] > target) {
            return leetCode34RecursionEnd(nums, target, low, middle - 1);
        } else {
            return leetCode34RecursionEnd(nums, target, middle + 1, high);
        }
    }

    private static int leetCode34RecursionStart(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = low + (high - low) / 2;
        if (nums[middle] == target && (middle == 0 || nums[middle - 1] < target)) {
            return middle;
        } else if (nums[middle] >= target) {
            return leetCode34RecursionStart(nums, target, low, middle - 1);
        } else {
            return leetCode34RecursionStart(nums, target, middle + 1, high);
        }
    }
}
