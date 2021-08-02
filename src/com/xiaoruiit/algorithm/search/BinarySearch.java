package com.xiaoruiit.algorithm.search;

/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {

        // 二分查找
        int [] arr = {1,2,3,4,5,6};
        System.out.println(BinarySearch.binary(arr, 5));
        // 二分查找递归
        int [] arr2 = {1,2,3,4,5,6};
        System.out.println(BinarySearch.binaryRecursion(arr, 5));


        // 有序数组中，第一个大于data的数组下标
        int [] arr3 = {1,2,3,4,5,6,7,8,9};
        System.out.println(BinarySearch.greaterThan(arr3, 5));
    }

    /**
     * 非递归写法
     *
     * @param arr
     * @param data
     * @return
     */
    public static boolean binary(int[] arr, int data){
        if (arr == null || arr.length < 1){
            return false;
        }

        int low = 0;
        int high = arr.length - 1;
        int middle = 0;

        while (low <= high){
            middle = low + (high - low)/2 ;// 防止 hign + low 溢出
            if (arr[middle] == data){
                return true;
            } else if (arr[middle] > data){
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
    public static int  binaryRecursion(int[] arr, int target){

        int low = 0;
        int high = arr.length-1;
        return binaryRecursionExec(arr, target, low, high);
    }

    private static int binaryRecursionExec(int[] arr, int target, int low, int high) {
        if (low > high){
            return -1;
        }

        int middle = low + (high-low) /2 ;

        if (arr[middle] == target){
            return middle;
        } else if (arr[middle] > target){
            return binaryRecursionExec(arr, target, low, middle - 1);
        } else {
            return binaryRecursionExec(arr, target, middle + 1, high);
        }
    }

    /**
     * 求有序数组中，第一个大于data的数组下标
     *
     * @param arr 有序数组
     * @param data
     * @return
     *
     * 分析：有序数组第一个大于data，即二分中间的数大于data,中间的前一个数小于data.
     */
    public static int greaterThan(int[] arr, int data){
        if (arr == null || arr.length < 1){
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        int middle = 0;

        while (low <= high){
            middle = low + (high - low)/2 ;// 防止 hign + low 溢出
            if (arr[middle] > data &&(middle == 0 || arr[middle - 1] <= data)) {// 中间的数大于data，并且中间的前一个数小于data
                return middle;
            } else if (arr[middle] > data){
                high = middle - 1;

            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
