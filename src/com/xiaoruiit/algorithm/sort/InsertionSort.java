package com.xiaoruiit.algorithm.sort;

import java.util.Arrays;

/**
 * @author hanxiaorui
 * @date 2023/2/17
 * 插入排序
 */
public class InsertionSort {

    public static int[] insertionSort(int[] sortArray){
        if (sortArray == null || sortArray.length == 0){
            return sortArray;
        }

        int[] result = Arrays.copyOf(sortArray, sortArray.length);

        for (int i = 1; i < result.length; i++) {
            int temp = result[i];
            int j = i - 1;

            // 一遍遍历，
            while (j > -1){
                if (temp < result[j]){
                    result[j + 1] = result[j];
                } else {
                    break;
                }
                j--;
            }

            result[j + 1] = temp;
        }
        return result;
    }
}
