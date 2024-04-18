package com.xiaoruiit.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanxiaorui
 * @date 2024/4/18
 */
public class LeetCode39 {
    public static void main(String[] args) {
        LeetCode39 leet = new LeetCode39();
        System.out.println(leet.combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(leet.combinationSum2(new int[]{2,3,6,7}, 7));
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        recursion(candidates, target, 0, new ArrayList<>());

        return res;
    }

    public void recursion(int[] candidates, int target, int start, List<Integer> list){
        if (start > candidates.length - 1){
            return;
        }

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        if (sum == target){
            res.add(new ArrayList<>(list));
            return;
        } else if (sum < target){// 选择当前数
            list.add(candidates[start]);
            recursion(candidates, target, start, list);
            list.remove(list.size() - 1);
        }

        // 选择下一个数
        recursion(candidates, target, start + 1, list);
    }


    List<List<Integer>> res2 = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        recursion2(candidates, target, 0, new ArrayList<>());

        return res2;
    }
    public void recursion2(int[] candidates, int target, int start, List<Integer> list){
        if (start > candidates.length - 1){
            return;
        }

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        if (sum == target){
            res2.add(new ArrayList<>(list));
            return;
        } else if (sum < target){// 选择当前数
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                recursion2(candidates, target, i, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
