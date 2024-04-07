package com.xiaoruiit.data_structure.array;

import java.util.*;

/**
 * 多个数组求交集
 */
public class LeetCode2248 {

    public static void main(String[] args) {
        System.out.println(intersection2(new int[][]{{3,1,2,4,5}, {1,2,3,4}, {3,4,5,6}}));;
    }
    public static List<Integer> intersection2(int[][] nums) {
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[1001];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                arr[nums[i][j]]++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == nums.length){
                result.add(i);
            }
        }

        return result;
    }

    public List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                map.put(nums[i][j], map.getOrDefault(nums[i][j], 0) + 1);
            }
        }

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == nums.length){
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);
        return list;
    }
}
