package com.xiaoruiit.algorithm.search.unit;

import java.math.BigDecimal;

/**
 * 定义边类
 * @author hanxiaorui
 * @date 2023/3/31
 */
public class Edge2 {
    private Node source; // 起始节点
    private Node destination; // 终止节点
    private BigDecimal weight; // 权重

    public Edge2(Node source, Node destination, BigDecimal weight) {
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

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
