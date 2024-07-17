package com.xiaoruiit.algorithm.search.unit2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author hanxiaorui
 * @date 2024/6/14
 */
public class Main {
    public static void main(String[] args) {

    }

    public static List<Edge> calc(DirectedGraph graph) {
        List<Edge> result = new ArrayList<>();

        for (Node left : graph.nodes) {
            for (Node right : graph.nodes) {
                if (left != right){
                    double distance = dfs(graph, left, right);
                    System.out.println(left + "->" + right + ":" + distance);
                }
            }

        }

        return result;
    }

    public static double dfs(DirectedGraph graph, Node start, Node end) {
        Map<Node, Boolean> flag = new HashMap<>();
        for (Node node : graph.nodes) {
            flag.put(node, false);
        }

        Queue<Node> queue = new LinkedList();
        queue.add(start);
        Map<Node, Double> distanceMap = new HashMap<>();
        distanceMap.put(start, 1.0d);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.equals(end)){
                return distanceMap.get(current);
            }

            for (Edge edge : graph.edges.get(current)) {
                Node right = edge.right;
                while (!flag.get(right)) {
                    distanceMap.put(right, distanceMap.get(current) * edge.weight);
                    queue.add(right);
                    flag.put(right, true);
                }
            }

        }

        throw new IllegalArgumentException("无法计算");

    }
}
