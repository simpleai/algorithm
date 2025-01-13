package com.xiaoruiit.algorithm.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 面试题 04.01. 节点间通路
 * https://leetcode.cn/problems/route-between-nodes-lcci/solutions/?envType=problem-list-v2&envId=graph
 */
public class LeetCode {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1},
                {0, 2},
                {1, 2},
                {1, 2}
        };

        boolean whetherExistsPath = findWhetherExistsPath(3, graph, 0, 2);
        System.out.println(whetherExistsPath);

        int[][] graph2 = {
                {0, 1},
                {0, 2},
                {0, 4},
                {0, 4},
                {0, 1},
                {1, 3},
                {1, 4},
                {1, 3},
                {2, 3},
                {3, 4}
        };
        boolean whetherExistsPath2 = findWhetherExistsPath(5, graph2, 0, 3);
        System.out.println(whetherExistsPath2);

        boolean whetherExistsPath3 = findWhetherExistsPath(5, graph2, 1, 2);
        System.out.println(whetherExistsPath3);
    }

    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 构建图-邻接矩阵
        DirectGraph directGraph = new DirectGraph();
        for (int[] ints : graph) {
            directGraph.nodes.add(ints[0]);
            directGraph.nodes.add(ints[1]);

            Set<Integer> orDefault = directGraph.edgesMap.get(ints[0]);
            if (orDefault != null){
                orDefault.add(ints[1]);
                directGraph.edgesMap.put(ints[0], orDefault);
            } else {
                orDefault = new HashSet<>();
                orDefault.add(ints[1]);
                directGraph.edgesMap.put(ints[0], orDefault);
            }
        }

        // 防止环
        Map<Integer, Boolean> isVisitedMap = new HashMap<>();
        for (Integer node : directGraph.nodes) {
            isVisitedMap.put(node, false);
        }

        // 广度优先遍历找通路
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll == target) {
                return true;
            }

            if (isVisitedMap.get(poll)){
                continue;
            } else {
                isVisitedMap.put(poll, true);
            }

            Set<Integer> integers = directGraph.edgesMap.get(poll);
            if (integers != null) {
                for (Integer integer : integers) {
                    queue.add(integer);
                }
            }
        }

        return false;
    }
}


class DirectGraph {
    public Set<Integer> nodes = new HashSet<>();
    public Map<Integer, Set<Integer>> edgesMap = new HashMap<>();
}
