package com.xiaoruiit.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后
 * @author hanxiaorui
 * @date 2024/4/22
 */
public class LeetCode51 {
    public static void main(String[] args) {
        LeetCode51 leet = new LeetCode51();

        System.out.println(leet.solveNQueens(4));
        System.out.println(leet.solveNQueens2(4));
    }

    List<List<String>> res2 = new ArrayList<>();
    public List<List<String>> solveNQueens2(int n) {

        recursion2(n, new int[n], new boolean[n][n]);

        return res2;
    }

    public void recursion2(int n, int[] queue, boolean[][] flag){
        if (n == 0){
            res2.add(gene(queue));
            return;
        }

        for (int tempStart = 0; tempStart < flag.length; tempStart++) {
            if (!canQueen(n, tempStart, flag)){
                continue;
            }


            queue[n - 1] = tempStart;
            flag[n - 1][tempStart] = true;

            recursion2(n - 1,queue, flag);

            flag[n - 1][tempStart] = false;
//            queue[n - 1] = -1;
        }
    }

    private List<String> gene(int[] queue) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queue.length; i++) {
            char[] ch = new char[queue.length];
            Arrays.fill(ch, '.');
            ch[queue[i]] = 'Q';
            list.add(new String(ch));
        }
        return list;
    }

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {

        recursion(n, new ArrayList<>(), new boolean[n][n]);

        return res;
    }

    public void recursion(int n, List<String> list, boolean[][] flag){
        if (n == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int tempStart = 0; tempStart < flag.length; tempStart++) {
            if (!canQueen(n, tempStart, flag)){
                continue;
            }

            String str = "";
            for (int i = 0; i < flag.length; i++) {
                if (i != tempStart){
                    str += ".";
                } else {
                    str += "Q";
                }
            }
            list.add(str);
            flag[n - 1][tempStart] = true;

            recursion(n - 1,list, flag);

            flag[n - 1][tempStart] = false;
            list.remove(list.size() - 1);
        }
    }

    private boolean canQueen(int n, int start, boolean[][] flag) {
        for (int i = 0; i < flag.length; i++) {// 竖
            if(flag[i][start] == true) {
                return false;
            }
        }

        for (int i = n - 1, j = start; i < flag.length && j < flag.length; i++, j++) {// 右下斜
            if(flag[i][j] == true) {
                return false;
            }
        }
        for (int i = n - 1, j = start; i < flag.length && j >= 0; i++, j--) {// 左下斜
            if(flag[i][j] == true) {
                return false;
            }
        }

        return true;
    }
}
