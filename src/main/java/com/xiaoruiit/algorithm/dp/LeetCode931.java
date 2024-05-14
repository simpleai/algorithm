package com.xiaoruiit.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * f(i.j) += min(f(i - 1. j - 1).  f(i - 1. j). f(i - 1. j + 1))
 * @author hanxiaorui
 * @date 2024/5/14
 */
public class LeetCode931 {
    public static void main(String[] args) {
        LeetCode931 leet = new LeetCode931();

        int[][] arr = new int[][]{{1,3,1},{1,5,1},{4,2,1}};

        System.out.println(leet.minFallingPathSum(arr));

        int[][] arr2 = new int[][]{{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(leet.minFallingPathSum(arr2));
    }

    public int minFallingPathSum(int[][] matrix) {
        for(int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0){
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                } else if (j == matrix[i].length - 1){
                    matrix[i][j] += Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]);
                } else {
                    matrix[i][j] += Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]));
                }
            }
        }

        int min = matrix[matrix.length - 1][0];
        for (int i = 1; i < matrix.length; i++) {
            min = Math.min(min, matrix[matrix.length - 1][i]);
        }

        return min;
    }
}
