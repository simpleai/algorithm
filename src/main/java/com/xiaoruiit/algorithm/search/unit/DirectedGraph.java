package com.xiaoruiit.algorithm.search.unit;

import java.util.*;

/**
 * 定义图类
 * @author hanxiaorui
 * @date 2023/3/31
 */
public class DirectedGraph {
    private Set<Node> nodes;
    private Map<Node, List<Edge>> edges;

    public DirectedGraph() {
        nodes = new HashSet<>();
        edges = new HashMap<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
        edges.put(node, new ArrayList<>());
    }

    public void addEdge(Edge edge) {
        edges.get(edge.getSource()).add(edge);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges(Node node) {
        return edges.get(node);
    }
}
