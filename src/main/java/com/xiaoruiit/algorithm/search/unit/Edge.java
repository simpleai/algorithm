package com.xiaoruiit.algorithm.search.unit;

/**
 * 定义边类
 * @author hanxiaorui
 * @date 2023/3/31
 */
public class Edge {
    private Node source; // 起始节点
    private Node destination; // 终止节点
    private double weight; // 权重

    public Edge(Node source, Node destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
