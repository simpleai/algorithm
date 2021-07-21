package com.xiaoruiit.data_structure.LinearList;

/**
 * 链表结点定义
 * @param <T>
 */
class Node<T> {

    public T data;
    public Node next;

    public Node (){}
    public Node(T data) {
        this.data = data;
    }

}