package com.xiaoruiit.algorithm.dp;

/**
 * f(i, j) = f(i-1,j) + f(i, j-1)，压缩为一维滚动数组：f[j] = f[j] + f[j - 1]
 * @author hanxiaorui
 * @date 2024/5/13
 */
public class LeetCode63 {
    public static void main(String[] args) {
        LeetCode63 leet = new LeetCode63();
//        System.out.println(leet.uniquePathsWithObstacles(new int[][]{{0,0}, {0, 1}}));
        System.out.println(leet.uniquePathsWithObstacles(new int[][]{{0,1}, {1, 0}}));
        System.out.println(leet.uniquePathsWithObstacles2(new int[][]{{0,1,0}, {0, 0, 0}}));
//        System.out.println(leet.uniquePathsWithObstacles2(new int[][]{{0,1}, {0, 0}}));

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] != -1){
                obstacleGrid[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] != -1){
                obstacleGrid[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == -1){
                    continue;
                }

                if (obstacleGrid[i][j - 1] == -1 && obstacleGrid[i - 1][j] == -1){

                } else if (obstacleGrid[i][j - 1] == -1){
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                } else if (obstacleGrid[i - 1][j] == -1){
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                }
            }
        }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        for (int i = 1; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
