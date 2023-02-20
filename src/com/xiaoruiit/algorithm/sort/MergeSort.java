package com.xiaoruiit.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 */

public class MergeSort {

    /**
     * 归并排序
     * <p>
     * 时间复杂度：
     * 最好：O(nlogn) 二分logn次，每次合并时须比较n-1次
     * 最坏：O(nlogn) 二分logn次，每次合并时须比较n-1次
     * 空间复杂度：
     * O(n)
     * <p>
     * 稳定
     * <p>
     * 思想：
     * 1.将数组不断二分，直到只有1个元素
     * 2.相邻部分排序后合并
     *
     * @param arr
     * @return
     */
    public static void mergeSort(int arr[]) {
        // 校验
        if (arr == null || arr.length == 0) {
            return;
        }

        int start = 0, end = arr.length - 1;
        execMergeSort(arr, start, end);
    }

    private static void execMergeSort(int[] result, int start, int end) {
        if (start < end){
            int middle = start + (end - start) / 2;
            execMergeSort(result, start, middle);// 递归左边，直到只剩一个元素
            execMergeSort(result,  middle + 1, end); //递归右边，直到只剩一个元素
            mergerArr(result, start,middle,end);// 排序后合并
        }

    }

    private static void mergerArr(int[] result, int start, int middle, int end) {
        int[] temp = Arrays.copyOf(result, result.length);
        // result[start] 到 result[middle] 是左边的数组， result[middle+1] 到 result[end] 是左边的数组
        int left = start;// 左数组起点
        int right = middle+1;// 右数组起点
        int k = start;// temp起点
        while(left <= middle && right <= end){// 对已排序的两个数组 排序合并，直到某个数组结束
            if (temp[left] <= temp[right]){
                result[k++] = temp[left++];
            } else {
                result[k++] = temp[right++];
            }
        }
        // 处理上个循环中一个数组遍历结束，另一个数组剩余的元素
        while (left <= middle){// 左数组未结束，拷贝剩余的左边数组元素到temp
            result[k++] = temp[left++];
        }
        while (right <= end){// 右数组未结束，拷贝剩余的右边数组元素到temp
            result[k++] = temp[right++];
        }
    }


    public static void mergeSort2(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }

        divide(arr, 0, arr.length - 1);
    }

    private static void divide(int[] arr, int start, int end) {
        if (start >= end){
            return;
        }

        int middle = start + (end - start) / 2;
        divide(arr, start, middle);
        divide(arr, middle + 1, end);
        merge(arr, start, middle, end);
    }

    private static void merge(int[] arr, int start, int middle, int end) {
        int[] result = Arrays.copyOf(arr, end - start + 1);

        int left = start, right = middle + 1;
        int count = 0;

        while(left <= middle && right <= end){
            if (arr[left] <= arr[right]){
                result[count++] = arr[left++];
            } else {
                result[count++] = arr[right++];
            }
        }

        if(left <= middle){
            while(left <= middle){
                result[count++] = arr[left++];
            }
        }
        if(right <= end){
            while(right <= end){
                result[count++] = arr[right++];
            }
        }

        // 排好序的result数组 复制回arr数组
        for (int i = 0; i < count; i++) {
            arr[start++] = result[i];
        }
    }


}
