package com.xiaoruiit.algorithm.dp;

/**
 * i = 0 || j = 0; f(i,j) == f(i,j)
 * f(i,j) == 0;  f(i,j) = 0;
 * f(i,j) == 1; f(i,j) = min(f(i-1,j), f(i-1,j-1), f(i,j-1)) + 1;
 * @author hanxiaorui
 * @date 2024/5/14
 */
public class LeetCode221 {
    public static void main(String[] args) {

    }

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int[][] arr = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            int length = matrix[i].length;
            arr[i] = new int[length];
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || j == 0){
                    if (matrix[i][j] == '0'){
                        arr[i][j] = 0;
                    } else {
                        arr[i][j] = 1;
                    }
                } else if (matrix[i][j] == '0'){
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = Math.min(arr[i - 1][j], Math.min(arr[i - 1][j - 1], arr[i][j - 1])) + 1;
                }
                max = Math.max(max, arr[i][j]);
            }
        }

        return max * max;
    }
}
