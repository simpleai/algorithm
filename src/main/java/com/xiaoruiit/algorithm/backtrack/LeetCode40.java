package com.xiaoruiit.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和 II
 * 每个数字在每个组合中只能使用 一次 。
 * @author hanxiaorui
 * @date 2024/4/19
 */
public class LeetCode40 {

    public static void main(String[] args) {
        LeetCode40 leet = new LeetCode40();
        System.out.println(leet.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        leet.res = new ArrayList<>();
        System.out.println(leet.combinationSum2(new int[]{2,5,2,1,2}, 5));
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recursion(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }

    public void recursion(int[] candidates, int target, int start, List<Integer> list, int sum){
        if (start > candidates.length){
            return;
        }

        if (sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target){
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]){// 去除重复，需要排序
                continue;
            }
            if (sum > target){
                return;
            }

            list.add(candidates[i]);

            recursion(candidates, target, i + 1, list , sum + candidates[i]);// i + 1 选择后续的数（每个数只能用一次）

            list.remove(list.size() - 1);
        }
    }
}
