package com.xiaoruiit.algorithm.sort;

import java.util.Arrays;

public class SortMain {

    public static void main(String[] args) {
        // 冒泡
        int [] arr = {1,3,2,6,4,8};
        System.out.println(Arrays.toString(BubbleSort.bubbleSort(arr)));

        // 快排
        int [] arr2 = {1,3,2,6,4,8};
        QuickSort.quickSort(arr2);
        System.out.println(Arrays.toString(arr2));

        // 归并
        int [] arr3 = {1,3,2,6,4,8};
        MergeSort.mergeSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
