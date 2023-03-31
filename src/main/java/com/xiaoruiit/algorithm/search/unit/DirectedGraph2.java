package com.xiaoruiit.algorithm.search.unit;

import java.util.*;

/**
 * 定义图类
 * @author hanxiaorui
 * @date 2023/3/31
 */
public class DirectedGraph2 {
    private Set<Node> nodes;
    private Map<Node, List<Edge2>> edges;

    public DirectedGraph2() {
        nodes = new HashSet<>();
        edges = new HashMap<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
        edges.put(node, new ArrayList<>());
    }

    public void addEdge(Edge2 edge) {
        edges.get(edge.getSource()).add(edge);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public List<Edge2> getEdges(Node node) {
        return edges.get(node);
    }
}
