package com.xiaoruiit.algorithm.search;

import java.util.Stack;

/**
 * DFS 深度优先遍历
 */
public class DFSSearch {

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, -1, 0, 0, 0},
                {0, 0, -1, 0, 0, 0},
                {0, 0, -1, -1, 0, 0},
                {0, -1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, -1}
        };
        int[] A = {0, 2};
        int[] B = {2, 4};

        int[][] maze2 = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, -1, 0, 0, 0},
                {0, 0, -1, 0, 0, 0},
                {0, 0, -1, -1, 0, 0},
                {0, -1, 0, 0, 0, 0},
                {0, -1, 0, 0, 0, -1}
        };
        System.out.println(dfsRecursion(maze, 0, 2));
        System.out.println(dfsStack(maze2,0,2));
    }

    /**
     * 例子1
     * 给定一个二维矩阵代表一个迷宫，迷宫里面有通道，也有墙壁，通道由数字 0 表示，而墙壁由 -1 表示，有墙壁的地方不能通过，那么，能不能从 A 点走到 B 点。
     * <p>
     * 递归实现
     */
    public static boolean dfsRecursion(int[][] maze, int x, int y) {
        if (x == 2 && y == 4) {
            return true;
        }
        // 经过的点标记为-1
        maze[x][y] = -1;

        // 四个方向 （递归时一直向一个方向走，失败时向第二个方向，走到第二个方向时，接着向第一个方向）
        int i = x - 1; // 左
        if (isValidity(maze, i, y) && dfsRecursion(maze, i, y)) {
            return true;
        }
        int j = y + 1; // 下
        if (isValidity(maze, x, j) && dfsRecursion(maze, x, j)) {
            return true;
        }
        int k = x + 1; // 右
        if (isValidity(maze, k, y) && dfsRecursion(maze, k, y)) {
            return true;
        }
        int l = y - 1; // 上
        if (isValidity(maze, x, l) && dfsRecursion(maze, x, l)) {
            return true;
        }

        // 递归四个方向都没有到达B点
        return false;
    }

    private static boolean isValidity(int[][] maze, int x, int y) {
        if (x < 0 || y < 0 || x > 5 || y > 5) {// 边界判断
            return false;
        }
        if (maze[x][y] == -1) {// 陷阱和已经过的点
            return false;
        }
        return true;
    }

    /**
     * 例子2
     * 给定一个二维矩阵代表一个迷宫，迷宫里面有通道，也有墙壁，通道由数字 0 表示，而墙壁由 -1 表示，有墙壁的地方不能通过，那么，能不能从 A 点走到 B 点。
     * <p>
     * 栈实现
     */
    public static boolean dfsStack(int[][] maze, int x, int y) {
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        Stack<int[]> stack = new Stack();

        stack.push(new int[]{x, y});
        maze[x][y] = -1;

        while (!stack.empty()) {
            int[] cur = stack.peek();
            x = cur[0];
            y = cur[1];

            if (x == 4 && y == 2) {
                return true;
            }
            boolean isHaveWay = false;
            // 四个方向。一次走一个方向，没有路时回退，即弹出栈顶元素，尝试其他方向。每次循环判断栈顶元素是否到达终点
            for (int d = 0; d < 4; d++) {
                int i = x + dx[d];
                int j = y + dy[d];
                if (isValidity(maze, i, j)) {
                    stack.push(new int[]{i, j});
                    maze[i][j] = -1;
                    isHaveWay = true;
                    break;

                }
            }
            if(!isHaveWay){// 没有路时弹出栈顶元素，回退尝试其他方向
                stack.pop();
            }
        }
        return false;
    }

    /**
     * 例子2
     * 给定一个二维矩阵代表一个迷宫，迷宫里面有通道，也有墙壁，通道由数字 0 表示，而墙壁由 -1 表示，有墙壁的地方不能通过，那么，能不能从 A 点走到 B 点。
     * <p>
     * 栈实现
     */
    public static boolean dfsStack2(int[][] maze, int x, int y) {
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        Stack<int[]> stack = new Stack();

        stack.push(new int[]{x, y});
        maze[x][y] = -1;

        while (!stack.empty()) {
            int[] cur = stack.pop();
            x = cur[0];
            y = cur[1];

            if (x == 4 && y == 2) {
                return true;
            }
            // 四个方向。一次走四个方向，将合法值都存入栈中。每次合法值出栈时判断是否到达了终点。
            for (int d = 0; d < 4; d++) {
                int i = x + dx[d];
                int j = y + dy[d];
                if (isValidity(maze, i, j)) {
                    stack.push(new int[]{i, j});
                    maze[i][j] = -1;
                    break;

                }
            }

        }
        return false;
    }
}
