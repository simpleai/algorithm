package com.xiaoruiit.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * f(i,j) = min(f(i - 1, j - 1),f(i - 1, j) + f(i, j)
 * @author hanxiaorui
 * @date 2024/5/13
 */
public class LeetCode120 {
    public static void main(String[] args) {
        LeetCode120 leet = new LeetCode120();

        int[][] arr = new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                tempList.add(arr[i][j]);
            }
            list.add(tempList);
        }
        System.out.println(leet.minimumTotal(list));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] arr = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                arr[i][j] = triangle.get(i).get(j);
            }
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i][0] += arr[i - 1][0];
        }

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 1; j < triangle.get(i).size(); j++) {
                arr[i][j] += Math.min(arr[i - 1][j - 1], arr[i - 1][j]);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[arr.length - 1][i], min);
        }

        return min;
    }
}
