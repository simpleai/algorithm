package com.xiaoruiit.algorithm.search;

/**
 * 二分查找
 */
public class BinarySearch {

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
     * 求有序数组中，第一个大于data的数组下标
     * @param arr 有序数组
     * @param data
     * @return
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
