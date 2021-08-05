package com.xiaoruiit.algorithm.search;

import java.util.LinkedList;

/**
 * 广度优先搜索
 */
public class BFSSearch {
    public static void main(String[] args) {

        int[][] maze = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, -1, 0, 0, 0},
                {0, 0, -1, 0, 0, 0},
                {0, 0, -1, -1, 0, 0},
                {0, -1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, -1}
        };
        int[] a = {0, 2};
        int[] b = {2, 4};
        System.out.println(bfs(maze, a[0], a[1]));

        // 最短路径长度
        int[][] maze2 = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, -1, 0, 0, 0},
                {0, 0, -1, 0, 0, 0},
                {0, 0, -1, -1, 0, 0},
                {0, -1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, -1}
        };
        System.out.println(shortestPath(maze2, 0, 2));
    }

    /**
     * 队列实现
     *
     * @param maze
     * @param x
     * @param y
     * @return
     */
    public static boolean bfs(int[][] maze, int x, int y){
        LinkedList<int[]> queue = new LinkedList();
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        queue.offerFirst(new int[] {x,y});
        maze[x][y] = -1;

        while (!queue.isEmpty()){
            int[] ints = queue.pollLast();
            x = ints[0];
            y = ints[1];
            if (x == 2 && y == 4){
                return true;
            }
            // 四个方向
            for (int d = 0; d < 4; d++) {
                int i = x + dx[d];
                int j = y + dy[d];
                if (isSafe(maze, i ,j)){
                    queue.offerFirst(new int[]{i,j});
                    maze[i][j] = -1;
                }
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] maze, int x, int y) {
        if (x < 0 || y < 0 || x > 5 || y > 5) {// 边界判断
            return false;
        }
        if (maze[x][y] == -1 || maze[x][y] != 0 || (x == 0 && y ==2)) {// 陷阱和已经过的点
            return false;
        }
        return true;
    }

    /**
     * 最短路径长度
     */
    public static int shortestPath(int[][] maze, int x, int y){
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offerFirst(new int[]{0,2});
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        while (!queue.isEmpty()){
            int[] ints = queue.pollLast();
            x = ints[0];
            y = ints[1];

            for (int d = 0; d < 4; d++) {
                int i = x + dx[d];
                int j = y + dy[d];
                if (isSafe(maze, i, j)){
                    maze[i][j] = maze[x][y] + 1;
                    queue.offerFirst(new int[] {i,j});
                    if (i == 4 && j == 2){
                        return maze[x][y];
                    }
                }
            }
        }
        return -1;
    }
}
