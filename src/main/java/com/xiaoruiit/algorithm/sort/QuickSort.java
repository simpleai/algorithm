package com.xiaoruiit.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    /**
     * 快排，从小到大
     *
     * 总结：
     *  时间复杂度：
     *      最好:O(nlogn) 二分logn次数组，每次二分，比较n次
     *      平均：O(nlogn)
     *      最坏：O(n²) 二分 n-1 次数组（每次只分出去1个元素），每次二分，比较n次
     *  空间复杂度：O(log n)
     *  不稳定
     *
     * 思想：
     *  1．先从数列中取出一个数作为基准数。
     *  2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     *  3．再对左右区间重复第二步，直到各区间只有一个数。
     *
     * @param arr
     * @return
     */
    public static void quickSort(int[] arr) {
        // 校验
        if (arr == null || arr.length == 0){
            return;
        }

        int start = 0, end = arr.length - 1;
        execQuickSort(arr, start, end);
    }

    private static void execQuickSort(int[] arr, int start, int end) {
        if (start >= end ){// 递归结束条件
            return;
        }
        int standard = arr[start];// 基准值，默认为数组的一个数
        int i = start;
        int j = end;
        while (i < j) {
            while (j > i) {// 从右往左找比 基准值 小的数放入坑位
                if (arr[j] < standard) {
                    arr[i] = arr[j];
                    i++;
                    break;
                }
                j--;
            }
            while (i < j) {// 从左往右找比 基准值 大的数放入坑位
                if (arr[i] > standard) {
                    arr[j] = arr[i];
                    j--;
                    break;
                }
                i++;
            }
        }
        arr[i] = standard;// 基准值的位置，此时基准值左边的数都比基准值小，基准值右边的数都比基准值大

        execQuickSort(arr, start, i - 1);// 递归排好位置的基准值左边的数组
        execQuickSort(arr, i + 1, end);// 递归排好位置的基准值右边的数组
    }



























    public static void quickSort2(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }

        recursion(arr, 0, arr.length - 1);
    }

    private static void recursion(int[] arr, int start, int end) {
        if (start >= end){// 结束条件
            return;
        }

        int i = start, j = end;
        int standard = arr[start];

        while (i < j){
            while (j > i){
                if (standard > arr[j]){
                    arr[i] = arr[j];
                    i++;
                    break;
                }
                j--;
            }
            while (i < j){
                if (standard < arr[i]){
                    arr[j] = arr[i];
                    j--;
                    break;
                }
                i++;
            }
        }

        arr[i] = standard;

        recursion(arr, start, i - 1);
        recursion(arr, i + 1, end);
    }

}
