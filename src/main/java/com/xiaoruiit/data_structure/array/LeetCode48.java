package com.xiaoruiit.data_structure.array;

/**
 * 旋转图像 https://leetcode.cn/problems/rotate-image/description/
 * @author hanxiaorui
 * @date 2024/4/3
 */
public class LeetCode48 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        LeetCode48 leet = new LeetCode48();
        leet.rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        int[][] matrix2 = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        leet.rotate(matrix2);

        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                System.out.print(matrix2[i][j] + ",");
            }
            System.out.println();
        }
    }
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < (matrix.length + 1) / 2; j++) {
                swap(matrix, i , j);
            }
        }

    }

    private void swap(int[][] matrix, int x, int y) {
        int tempValue = matrix[x][y];
        matrix[x][y] = matrix[matrix.length - 1 - y][x];
        matrix[matrix.length - 1- y][x] = matrix[matrix.length - 1- x][matrix.length - 1 - y];
        matrix[matrix.length - 1- x][matrix.length - 1 - y] = matrix[y][matrix.length - 1 - x];
        matrix[y][matrix.length - 1 - x] = tempValue;
    }
}
