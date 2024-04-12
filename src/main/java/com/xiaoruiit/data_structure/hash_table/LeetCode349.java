package com.xiaoruiit.data_structure.hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author hanxiaorui
 * @date 2024/4/12
 */
public class LeetCode349 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1,2,2,2,1}, new int[]{2,2,3,3})));
        System.out.println(Arrays.toString(intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] arr = new int[1000];
        for (int i = 0; i < nums1.length; i++) {
            if (arr[nums1[i]] == 0){
                arr[nums1[i]]++;
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (arr[nums2[i]] == 1){
                arr[nums2[i]]++;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2){
                list.add(i);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
