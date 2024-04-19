package com.xiaoruiit.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 分割回文串
 * @author hanxiaorui
 * @date 2024/4/19
 */
public class LeetCode131 {

    public static void main(String[] args) {
        LeetCode131 leet = new LeetCode131();
//        System.out.println(leet.partition("aab"));

//        leet.part = new ArrayList<>();
//        leet.res = new ArrayList<>();
//        System.out.println(leet.partition("bb"));


//        System.out.println(leet.partition2("bb"));
        System.out.println("aab".substring(0, 3));
        System.out.println(leet.partition2("aab"));
    }

    List<List<String >> res = new ArrayList<>();

    List<List<Integer >> part = new ArrayList<>();

    public List<List<String>> partition(String s) {
        for (int i = 1; i < s.length(); i++) {// 分隔的种类
            recursion(s.length(),i, 1,  new ArrayList<>());
        }

        for (List<Integer> integers : part) {
            boolean flag = true;
            int begin = 0;
            List<String> list = new ArrayList<>();
            for (Integer integer : integers) {
                String substring = s.substring(begin, integer);
                if (!isPalindromic(substring)){
                    flag = false;
                    break;
                }
                list.add(substring);
                begin = integer;
            }
            String substring = s.substring(begin, s.length());
            if (!isPalindromic(substring)){
                flag = false;
            }
            list.add(substring);

            if (flag){
                res.add(list);
            }
        }

        if (isPalindromic(s)){// 整个字符串是回文串，加入结果集
            List<String> list = new ArrayList<>();
            list.add(s);
            res.add(list);
        }

        return res;
    }

    public void recursion(Integer length,int k, int start, List<Integer> starts){
        if (k == 0){
            part.add(new ArrayList<>(starts));
        }

        for (int i = start; i < length ; i++) {
            starts.add(i);
            recursion(length, k - 1, i + 1, starts);
            starts.remove(starts.size() - 1);
        }
    }

    private boolean isPalindromic(String str) {// 是否回文串
        if (str.length() == 1){
            return true;
        }
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }

    /**
     * aab
     * 0,1;1,3
     * 0,2;2,3
     * 0,3
     * 0,1;1,2;2,3
     * @param s
     * @return
     */

    List<List<String >> res2 = new ArrayList<>();
    List<List<int[]>> part2 = new ArrayList<>();
    public List<List<String>> partition2(String s) {
        recursion2(s, 0, new ArrayList<>());

        boolean[][] flag = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(flag[i], true);
        }

        for (int i = 0; i < s.length(); i++) {// 动态规划确定连续子元素是否回文串
            for (int j = i + 1; j < s.length(); j++) {
                flag[i][j] = (s.charAt(i) == s.charAt(j)) && flag[i + 1][j - 1];
            }
        }

        for (List<int[]> strings : part2) {
            List<String> list = new ArrayList<>();
            boolean f = true;
            for (int[] arr : strings) {
                list.add(s.substring(arr[0], arr[1]));
                if (!flag[arr[0]][arr[1] - 1]){
                    f= false;
                    break;
                }
            }
            if (f){
                res2.add(list);
            }
        }

        return res2;
    }

    public void recursion2(String s,int start, List<int[]> starts){
        if (start == s.length()){
            part2.add(new ArrayList<>(starts));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            starts.add(new int[]{start, i + 1});
            recursion2(s, i + 1, starts);
            starts.remove(starts.size() - 1);
        }
    }
}
