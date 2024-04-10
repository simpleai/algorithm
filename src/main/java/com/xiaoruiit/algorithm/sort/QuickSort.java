package com.xiaoruiit.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

import static java.util.Collections.swap;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{2,1,3,4,5})));
    }

    /**
     * 快排，从小到大
     *
     * 总结：
     *  时间复杂度：
     *      最好:O(nlogn) 二分logn次数组，每次二分，比较n次
     *      平均：O(nlogn)
     *      最坏：O(n²) 二分 n-1 次数组（每次只分出去1个元素），每次二分，比较n次
     *
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
    public static int[] quickSort(int[] arr) {
        // 校验
        if (arr == null || arr.length == 0){
            return arr;
        }

        int start = 0, end = arr.length - 1;
        execQuickSort(arr, start, end);
        return arr;
    }

    private static void execQuickSort(int[] arr, int start, int end) {
        if (start >= end ){// 递归结束条件
            return;
        }

        if(end > start){
            int i = new Random().nextInt(end - start) + start;
            swap(arr, start, i);
        }
        int standard = arr[start];// 基准值
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

    private static void swap(int[] arr, int start, int i) {
        int temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
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

//    public static void main(String[] args) {
////        System.out.println(Arrays.toString(quickSort20240401(new int[]{1,2,3,4,5})));
//        System.out.println(Arrays.toString(quickSort20240401(new int[]{4,2,1,3,5})));
//    }
    public static int[] quickSort20240401(int[] arr){
        int[] result = Arrays.copyOf(arr, arr.length);

        doQuickSort(result, 0, result.length - 1);

        return result;
    }

    private static void doQuickSort(int[] result, int start, int end) {
        if (start >= end) {
            return;
        }

        int i = start;
        int j = end;
        int pointValue = result[i];// 基准值

        while (i < j) {
            while (j > i) {
                if (result[j] < pointValue) {
                    result[i] = result[j];
                    i++;
                    break;
                }
                j--;
            }

            while(i < j){
                if (result[i] > pointValue) {
                    result[j] = result[i];
                    j--;
                    break;
                }
                i++;
            }
        }
        result[i] = pointValue;

        doQuickSort(result, start, i - 1);
        doQuickSort(result, i + 1, end);
    }
}
