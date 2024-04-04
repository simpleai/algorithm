package com.xiaoruiit.data_structure.array;

import java.util.Arrays;

/**
 * 合并两个有序数组 https://leetcode.cn/problems/merge-sorted-array/description/
 * @author hanxiaorui
 * @date 2024/4/3
 */
public class LeetCode88 {

    public static void main(String[] args) {
        LeetCode88 leet = new LeetCode88();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        leet.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = Arrays.copyOf(nums1, nums1.length);
        int k = 0;
        int i = 0, j= 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]){
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }

        while (i < m){
            temp[k++] = nums1[i++];
        }

        while (j < n){
            temp[k++] = nums2[j++];
        }
        for (int l = 0; l < k; l++) {
            nums1[l] = temp[l];
        }
    }
}
