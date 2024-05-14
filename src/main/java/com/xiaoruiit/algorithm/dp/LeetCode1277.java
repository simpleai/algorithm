package com.xiaoruiit.algorithm.dp;

/**
 * i = 0 || j = 0; f(i,j) == f(i,j)
 * f(i,j) == 0;  f(i,j) = 0;
 * f(i,j) == 1; f(i,j) = min(f(i-1,j), f(i-1,j-1), f(i,j-1)) + 1;
 * @author hanxiaorui
 * @date 2024/5/14
 */
public class LeetCode1277 {
    public static void main(String[] args) {
        LeetCode1277 leet = new LeetCode1277();
        int[][] arr = new int[][]{{1,0,1},{1,1,0},{1,1,0}};
        System.out.println(leet.countSquares(arr));

        int[][] arr2 = new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(leet.countSquares(arr2));
    }

    public int countSquares(int[][] matrix) {
        int count = 0;
        int[][] arr = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            int length = matrix[i].length;
            arr[i] = new int[length];
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || j == 0){
                    arr[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0){
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = Math.min(arr[i - 1][j], Math.min(arr[i - 1][j - 1], arr[i][j - 1])) + 1;

                }
                count += arr[i][j];
            }
        }

        return count;
    }
}
