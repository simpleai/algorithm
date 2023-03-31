package com.xiaoruiit.algorithm.search.unit;

import java.util.*;

/**
 * @author hanxiaorui
 * @date 2023/3/31
 */
public class UnitConversionTest {

    public static void main(String[] args) {
        // 构建有向图
        // 创建节点
        Node boxNode = new Node("箱");
        Node heNode = new Node("盒");
        Node packageNode = new Node("包");
        Node smallPackageNode = new Node("小包");

        // 创建边
        Edge heToSmallPackage = new Edge(heNode, smallPackageNode, 10000);
        Edge smallPackageToHe = new Edge(smallPackageNode, heNode, 1 / 10000.0);

        Edge packageToSmallPackage = new Edge(packageNode, smallPackageNode, 100);
        Edge smallPackageToPackage = new Edge(smallPackageNode, packageNode, 1 / 100.0);

        Edge boxToPackage = new Edge(boxNode, packageNode, 10000);
        Edge packageToBox = new Edge(packageNode, boxNode, 1 / 10000.0);

        // 将节点和边组成有向图
        DirectedGraph graph = new DirectedGraph();
        graph.addNode(boxNode);
        graph.addNode(heNode);
        graph.addNode(packageNode);
        graph.addNode(smallPackageNode);

        graph.addEdge(heToSmallPackage);
        graph.addEdge(smallPackageToHe);
        graph.addEdge(packageToSmallPackage);
        graph.addEdge(smallPackageToPackage);
        graph.addEdge(boxToPackage);
        graph.addEdge(packageToBox);

        double v = depthFirstSearch(graph, new Node("箱"), new Node("盒"));
        System.out.println(v);
        // 求最短路径，优先用广度优先搜索
        double v2 = getExchangeRate(graph, new Node("箱"), new Node("盒"));
        System.out.println("-----");
        System.out.println(v2);
    }

    public static double depthFirstSearch(DirectedGraph graph, Node startNode, Node endNode) {
        Map<Node, Boolean> visited = new HashMap<>();
        for (Node node : graph.getNodes()) {
            visited.put(node, false);
        }
        double v = depthFirstSearchHelper(graph, startNode, endNode, visited);
        if(v > 0){
            return v;
        }else {
            throw new IllegalArgumentException ("无法计算出" + startNode.getLabel() + "到" + endNode.getLabel() + "的换算关系");
        }
    }

    private static double depthFirstSearchHelper(DirectedGraph graph, Node currentNode, Node endNode, Map<Node, Boolean> visited) {
        visited.put(currentNode, true);
        if (currentNode.equals(endNode)) {
            return 1;
        }
        for (Edge edge : graph.getEdges(currentNode)) {
            Node neighbor = edge.getDestination();
            if (!visited.get(neighbor)) {
                double distance = depthFirstSearchHelper(graph, neighbor, endNode, visited);
                if (distance > 0) {
                    return edge.getWeight() * distance;
                }
            }
        }
        return -1;
    }

    /**
     * 计算从起始节点到终止节点的换算关系。使用广度优先搜索
     * @param graph 有向图
     * @param startNode 起始节点
     * @param endNode 终止节点
     * @return 换算关系
     */
    public static double getExchangeRate(DirectedGraph graph, Node startNode, Node endNode) {
        Map<Node, Boolean> visited = new HashMap<>();
        for (Node node : graph.getNodes()) {
            visited.put(node, false);
        }
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Double> distances = new HashMap<>(); // 存储节点到起点的系数
        queue.add(startNode);
        visited.put(startNode, true);
        distances.put(startNode, 1.0); // 起始节点到自己的系数为1

        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            if (currentNode.equals(endNode)) { // 找到终止节点，直接返回
                return distances.get(currentNode);
            }
            for (Edge edge : graph.getEdges(currentNode)) {
                Node neighbor = edge.getDestination();
                if (!visited.get(neighbor)) {
                    double distance = distances.get(currentNode) * edge.getWeight();
                    distances.put(neighbor, distance); // 更新邻居节点的系数
                    queue.add(neighbor);
                    visited.put(neighbor, true);
                }
            }
        }

        throw new IllegalArgumentException("无法计算出" + startNode.getLabel() + "到" + endNode.getLabel() + "的换算关系");
    }

}
