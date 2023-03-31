package com.xiaoruiit.algorithm.search.unit;

/**
 * 定义节点类
 * @author hanxiaorui
 * @date 2023/3/31
 */
public class Node {
    private String label; // 节点标签

    public Node(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Node)) {
            return false;
        }

        Node other = (Node) obj;
        return this.label.equals(other.getLabel());
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }
}
