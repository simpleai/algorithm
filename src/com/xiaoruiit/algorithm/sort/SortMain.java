package com.xiaoruiit.algorithm.sort;

import java.util.Arrays;

public class SortMain {

    public static void main(String[] args) {
        int [] arr = {1,3,2,6,4,8};

        // 冒泡
        int[] bubbleOrder = BubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(bubbleOrder));



    }
}
