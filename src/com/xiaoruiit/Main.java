package com.xiaoruiit;

import com.xiaoruiit.sort.BubbleSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [] arr = {1,3,2,6,4,8};

        // 冒泡
        int[] bubbleOrder = BubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(bubbleOrder));



    }
}
