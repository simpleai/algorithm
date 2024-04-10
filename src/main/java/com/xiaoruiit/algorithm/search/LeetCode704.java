package com.xiaoruiit.algorithm.search;

/**
 * tags: ['二分查找']
 * 二分查找,存在返回下标，否则返回 -1。
 * @author hanxiaorui
 * @date 2024/4/10
 */
public class LeetCode704 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch2(arr, 5));
    }

    public static int binarySearch2(int[] arr, int target){
        if (arr == null || arr.length == 0){
            return -1;
        }

        int low = 0, high = arr.length - 1;

        while(low <= high){
            int middle = low + ((high - low) >> 1);

            if (arr[middle] == target){
                return middle;
            } else if (arr[middle] > target){
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }
}
