package com.xiaoruiit.algorithm.dp;

import java.util.PriorityQueue;

/**
 * @author hanxiaorui
 * @date 2024/5/28
 */
public class LeetCode407C {
    public static void main(String[] args) {
        LeetCode407C leet = new LeetCode407C();
        System.out.println(leet.trapRainWater(new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}}));
        System.out.println(leet.trapRainWater(new int[][]{{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}}));
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        if (m <= 2 || n <= 2){
            return 0;
        }

        boolean[][] visit = new boolean[m][n];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);// 用于找木桶的最短板
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1){
                    priorityQueue.offer(new int[]{i, j, heightMap[i][j]});// 外层加入到队列中
                    visit[i][j] = true;// 外层无需访问
                }
            }
        }

        int res = 0;
        while (!priorityQueue.isEmpty()){// 四个方向依次接水和更新木桶的板
            int[] poll = priorityQueue.poll();

            int lx = poll[0], ly = poll[1] - 1;
            if (ly > 0 && !visit[lx][ly]){// 是否合法，是否已访问过
                if (heightMap[lx][ly] < poll[2]){
                    res += poll[2] - heightMap[lx][ly];// 接水
                }

                priorityQueue.offer(new int[]{lx, ly, Math.max(poll[2], heightMap[lx][ly])});// 更新木桶的板：高度更新为当前列或原木桶短板中的最高
                visit[lx][ly] = true;
            }

            int rx = poll[0], ry = poll[1] + 1;
            if (ry < n - 1 && !visit[rx][ry]){
                if (heightMap[rx][ry] < poll[2]) {
                    res += poll[2] - heightMap[rx][ry];
                }

                priorityQueue.offer(new int[]{rx, ry, Math.max(poll[2], heightMap[rx][ry])});
                visit[rx][ry] = true;
            }

            int upx = poll[0] - 1, upy = poll[1];
            if (upx > 0 && !visit[upx][upy]){
                if (heightMap[upx][upy] < poll[2]){
                    res += poll[2] - heightMap[upx][upy];

                }
                priorityQueue.offer(new int[]{upx, upy, Math.max(poll[2], heightMap[upx][upy])});
                visit[upx][upy] = true;
            }

            int belowx = poll[0] + 1, belowy = poll[1];
            if (belowx < m - 1 && !visit[belowx][belowy]){
                if (heightMap[belowx][belowy] < poll[2]){
                    res += poll[2] - heightMap[belowx][belowy];
                }

                priorityQueue.offer(new int[]{belowx, belowy, Math.max(poll[2], heightMap[belowx][belowy])});
                visit[belowx][belowy] = true;
            }
        }

        return res;
    }
}
