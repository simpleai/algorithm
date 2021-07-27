package com.xiaoruiit.algorithm.sort;

import java.util.Arrays;

public class SortMain {

    public static void main(String[] args) {
        int [] arr = {1,3,2,6,4,8};

        // 冒泡
        System.out.println(Arrays.toString(BubbleSort.bubbleSort(arr)));

        // 快排
        System.out.println(Arrays.toString(QuickSort.quickSort(arr)));
    }
}
