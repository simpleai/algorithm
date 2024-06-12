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
        leet.res = new ArrayList<>();
        System.out.println(leet.combinationSum3(3, 9));
        leet.res = new ArrayList<>();
        System.out.println(leet.combinationSum3(4, 1));

        LeetCode216 leet2 = new LeetCode216();
        leet2.res = new ArrayList<>();
        System.out.println(leet2.combinationSum32(3, 7));// 三个1-9的数和为7
        leet2.res = new ArrayList<>();
        System.out.println(leet2.combinationSum32(3, 9));
        leet2.res = new ArrayList<>();
        System.out.println(leet2.combinationSum32(4, 1));
        System.out.println("---------");
        leet2.res = new ArrayList<>();
        System.out.println(leet2.combinationSum32(2, 18));
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
        recursion(k - 1, n, start + 1, list);
        list.remove(list.size() - 1);

        recursion(k, n , start + 1, list);
    }

    public List<List<Integer>> combinationSum32(int k, int n) {
        target = n;
        recursion3(k, n, 1, new ArrayList<Integer>());

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

        for (int i = start; i < n && i <= 9; i++) {
            list.add(i);
            recursion2(k - 1, n, i + 1, list);
            list.remove(list.size() - 1);

        }
    }

    int target = 0;
    public void recursion3(int k, int n, int start, List<Integer> list){
        if (k == 0){
            if (0 == n) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = start;  i <= 9 && i < target; i++) {
            list.add(i);
            recursion3(k - 1, n - i, i + 1, list);
            list.remove(list.size() - 1);

        }
    }
}
