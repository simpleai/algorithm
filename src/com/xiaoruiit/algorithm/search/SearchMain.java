package com.xiaoruiit.algorithm.search;

public class SearchMain {

    public static void main(String[] args) {

        // 二分查找
        int [] arr = {1,2,3,4,5,6};
        System.out.println(BinarySearch.binary(arr, 5));

        // 有序数组中，第一个大于data的数组下标
        int [] arr2 = {1,2,3,4,5,6,7,8,9};
        System.out.println(BinarySearch.greaterThan(arr2, 5));
    }

}
