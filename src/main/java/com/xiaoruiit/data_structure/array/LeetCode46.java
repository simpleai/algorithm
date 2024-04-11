package com.xiaoruiit.data_structure.array;

import java.util.*;

/**
 * 全排列
 * tags: ['数据','回溯']
 */
public class LeetCode46 {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3,4}));
    }
    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        boolean[] booleans = new boolean[nums.length];
        addList(nums, new ArrayList<>(), booleans);

        return result;
    }

    private static void addList(int[] nums, List<Integer> temp,boolean[] used) {
        if (temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;

                addList(nums, temp,used);

                used[i] = false;
                temp.remove(temp.size() - 1);
            }

        }
    }
}
