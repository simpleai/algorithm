package com.xiaoruiit.algorithm.search;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {

        // 二分查找
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(BinarySearch.binary(arr, 5));
        // 二分查找递归
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        System.out.println(BinarySearch.binaryRecursion(arr, 5));

        // 有序数组中，第一个大于data的数组下标
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(BinarySearch.greaterThan(arr3, 5));

        // leetCode 34.在排序数组中查找元素的第一个和最后一个位置
        System.out.println(Arrays.toString(BinarySearch.leetCode34(new int[]{5,7,7,8,8,10}, 6)));

        // leetCode 33.搜索旋转排序数组
        System.out.println(BinarySearch.leetCode33(new int[]{1,3}, 3));

    }

    /**
     * 非递归写法
     *
     * @param arr
     * @param data
     * @return
     */
    public static boolean binary(int[] arr, int data) {
        if (arr == null || arr.length < 1) {
            return false;
        }

        int low = 0;
        int high = arr.length - 1;
        int middle = 0;

        while (low <= high) {
            middle = low + (high - low) / 2;// 防止 hign + low 溢出
            if (arr[middle] == data) {
                return true;
            } else if (arr[middle] > data) {
                high = middle - 1;

            } else {
                low = middle + 1;
            }
        }
        return false;
    }

    /**
     * 递归写法
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binaryRecursion(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        return binaryRecursionExec(arr, target, low, high);
    }

    private static int binaryRecursionExec(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;

        if (arr[middle] == target) {
            return middle;
        } else if (arr[middle] > target) {
            return binaryRecursionExec(arr, target, low, middle - 1);
        } else {
            return binaryRecursionExec(arr, target, middle + 1, high);
        }
    }

    /**
     * 求有序数组中，第一个大于data的数组下标
     *
     * @param arr  有序数组
     * @param data
     * @return 分析：有序数组第一个大于data，即二分中间的数大于data,中间的前一个数小于data.
     */
    public static int greaterThan(int[] arr, int data) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        int middle = 0;

        while (low <= high) {
            middle = low + (high - low) / 2;// 防止 hign + low 溢出
            if (arr[middle] > data && (middle == 0 || arr[middle - 1] <= data)) {// 中间的数大于data，并且中间的前一个数小于data
                return middle;
            } else if (arr[middle] > data) {
                high = middle - 1;

            } else {
                low = middle + 1;
            }
        }
        return -1;
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

    /**
     * leetCode 33.搜索旋转排序数组
     *
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     *
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     *
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     *
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     *
     * O(log n)
     */
    public static int leetCode33(int[] nums, int target) {
        // 校验
        if (nums == null || nums.length ==0){
            return -1;
        }
        /*if (nums [0] == target){
            return 0;
        }
        if (nums.length > 1 && nums[1] == target){
            return 1;
        }*/

        int low = 0;
        int high = nums.length - 1;
        return leetCode33Recursion(nums, target, low, high);
    }

    private static int leetCode33Recursion(int[] nums, int target, int low, int high) {
        if (low > high){
            return -1;
        }
        int middle = low + (high - low) / 2;
        if (nums[middle] == target){
            return middle;
        } else if (nums[low] <= nums[middle]){// 左边有序
            if (target >= nums[low] && target < nums[middle]){// 在左边
                return leetCode33Recursion(nums, target, low, middle- 1);
            } else{// 在右边
                return leetCode33Recursion(nums, target, middle + 1, high);
            }
        } else {// 右边有序
            if (target > nums[middle] && target <= nums[high]){// 在右边
                return leetCode33Recursion(nums, target, middle + 1, high);
            } else {// 在左边
                return leetCode33Recursion(nums, target, low, middle- 1);
            }
        }
    }



}
