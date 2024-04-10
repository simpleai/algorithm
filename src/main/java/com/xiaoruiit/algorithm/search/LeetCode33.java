package com.xiaoruiit.algorithm.search;

/**
 * tags: ['二分查找']
 * 中等
 * @author hanxiaorui
 * @date 2024/4/10
 */
public class LeetCode33 {
    public static void main(String[] args) {
        // leetCode 33.搜索旋转排序数组
        System.out.println(leetCode33(new int[]{1}, 0));
        System.out.println("leetCode33Two：" + leetCode33Two(new int[]{1}, 0));

        System.out.println("leetCode33_20240401：" + leetCode33_20240401(new int[]{1}, 0));
        System.out.println("leetCode33_20240401：" + leetCode33_20240401(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println("leetCode33_20240401：" + leetCode33_20240401(new int[]{3,5,1}, 3));
        System.out.println("leetCode33_20240401：" + leetCode33_20240401(new int[]{5,1,3}, 3));

    }

    public static int leetCode33_20240401(int arr[], int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int middle = low + (high -low) / 2;
            if (arr[middle] == target) {
                return middle;
            } else if(arr[low] == target){
                return low;
            } else if (arr[low] <= arr[middle]) {// 左边有序
                if (arr[low] < target && target < arr[middle]){// 在左边
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            } else {
                if (arr[middle + 1] <= target && target <= arr[high]){
                    low = middle + 1;
                }else {
                    high = middle - 1;
                }
            }
        }
        return -1;
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


    public static int leetCode33Two(int arr[], int target){
        if (arr == null || arr.length == 0){
            return -1;
        }

        int low = 0, high = arr.length - 1;

        while (low <= high){
            int middle = low + ((high - low) >> 2);

            if (arr[middle] == target){
                return middle;
            } else if (arr[low] <= arr[middle]){// 左边有序
                if (arr[low] <= target && target < arr[middle]){// 在左边
                    high = middle - 1;
                } else {// 在右边
                    low = middle + 1;
                }
            } else {// 右边有序
                if (arr[middle + 1] <= target && target <= arr[high]){// 在右边
                    low = middle + 1;
                } else {// 在右边
                    high = middle - 1;
                }
            }
        }

        return -1;
    }
}
