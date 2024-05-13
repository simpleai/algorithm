package com.xiaoruiit.algorithm.dp;

/**
 * f(i, j) = f(i-1,j) + f(i, j-1)，压缩为一维滚动数组：f[j] = f[j] + f[j - 1]
 * @author hanxiaorui
 * @date 2024/5/13
 */
public class LeetCode62 {
    public static void main(String[] args) {
        LeetCode62 leet = new LeetCode62();
        System.out.println(leet.uniquePaths(3, 7));
        System.out.println(leet.uniquePaths(3, 2));
    }

    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = arr[i][j - 1] + arr [i - 1][j];
            }
        }

        return arr[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[j] = arr[j - 1] + arr[j];
            }
        }

        return arr[n - 1];
    }
}
