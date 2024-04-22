package com.xiaoruiit.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * @author hanxiaorui
 * @date 2024/4/22
 */
public class LeetCode78 {
    public static void main(String[] args) {
        LeetCode78 leet = new LeetCode78();
        System.out.println(leet.subsets(new int[]{1,2,3}));
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            recusion(nums, i, 0, new ArrayList<>());
        }

        return res;
    }

    public void recusion(int[] nums, int length, int start, List<Integer> list){
        if (length == 0){
            res.add(new ArrayList<>(list));
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);

            recusion(nums, length - 1, i + 1, list);

            list.remove(list.size() - 1);
        }
    }
}
