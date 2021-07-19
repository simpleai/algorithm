package com.xiaoruiit.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author hxr
 *
 */
public class BubbleSort {
    /**
     * 整型排序
     *
     * @param sourceArray 整型数组
     * @return 排序后的数组
     */
    public static int[] bubbleSort(int[] sourceArray){
        if (sourceArray == null || sourceArray.length == 0){
            return sourceArray;
        }
        // 复制数组内容，int[] arr = sourceArray 排序后会改变原数组内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {
            // 若循环没有做交换，则数组有序。
            boolean flag = true;
            for (int j = 0; j < arr.length-i; j++) {// 终止条件：每次循环数组会将一个最大的数放在数组末尾，所以循环减少1次，即 length-i
                if (arr[j] < arr[j+1]) {// 交换
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
            }
            if (flag) {// 内循环没有交换，说明数据已经有序
                break;
            }
        }
        return arr;
    }
}
