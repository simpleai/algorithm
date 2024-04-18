package com.xiaoruiit.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * @author hanxiaorui
 * @date 2024/4/18
 */
public class LeetCode77 {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine2(4, 2));
    }

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();

    /**
     * 1,2,3,4  3
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {

        dfs(1, n, k);

        return res;
    }

    public static void dfs(int cur, int n, int k) {
        if (k == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if (cur > n){
            return;
        }

        temp.add(cur);
        k--;
        dfs(cur + 1, n, k);
        k++;
        temp.remove(temp.size() - 1);

        dfs(cur + 1, n, k);
    }


    static List<List<Integer>> res2 = new ArrayList<>();
    public static List<List<Integer>> combine2(int n, int k) {

        dfs2(n, k, 1, new ArrayList<>());

        return res2;
    }

    public static void dfs2(int n, int k, int start, List<Integer> list) {
        if (k == 0){
            res2.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs2(n, k - 1, i + 1, list);
            list.remove(list.size() - 1);// 回溯
        }

    }
}
