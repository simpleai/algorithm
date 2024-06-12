package com.xiaoruiit.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和 III
 * 每个数字 最多使用一次
 * @author hanxiaorui
 * @date 2024/4/18
 */
public class LeetCode216 {

    public static void main(String[] args) {
        LeetCode216 leet = new LeetCode216();
        System.out.println(leet.combinationSum3(3, 7));// 三个1-9的数和为7
        System.out.println(leet.combinationSum3(3, 9));
        System.out.println(leet.combinationSum3(4, 1));

        LeetCode216 leet2 = new LeetCode216();
        leet2.res = new ArrayList<>();
        System.out.println(leet2.combinationSum3(3, 7));// 三个1-9的数和为7
        System.out.println(leet2.combinationSum3(3, 9));
        System.out.println(leet2.combinationSum3(4, 1));
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        recursion(k, n, 1, new ArrayList<Integer>());

        return res;
    }

    public void recursion(int k, int n, int start, List<Integer> list){
        if (k == 0){
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            if (sum == n) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (start > 9){
            return;
        }

        list.add(start);
        k--;
        recursion(k, n, start + 1, list);
        k++;
        list.remove(list.size() - 1);

        recursion(k, n , start + 1, list);
    }

    public List<List<Integer>> combinationSum32(int k, int n) {
        recursion2(k, n, 1, new ArrayList<Integer>());

        return res;
    }
    public void recursion2(int k, int n, int start, List<Integer> list){
        if (k == 0){
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            if (sum == n) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (start > 9){
            return;
        }

        for (int i = start; i < n; i++) {
            list.add(start);
            k--;
            recursion2(k, n, i + 1, list);
            k++;
            list.remove(list.size() - 1);

        }
    }
}
