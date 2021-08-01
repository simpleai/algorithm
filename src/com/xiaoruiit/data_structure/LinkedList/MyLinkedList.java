package com.xiaoruiit.data_structure.LinkedList;

/**
 * 单链表
 */
public class MyLinkedList<T> {
    public Node head;

    public Node current;
    /**
     * 添加结点
     *
     * @param data
     */
    public void add(int data) {
        if (head == null){
            head = new Node(data);
            current = head;
        } else {
            current.next = new Node(data);
            current = current.next;
        }
    }

    /**
     * 打印链表
     *
     * @param node
     */
    public static void print(Node node) {
        if(node == null) {
            return;
        }

        Node current = node;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("\n");
    }

    /**
     * 初始化链表,并且返回表头
     *
     * @return 头结点
     */
    public Node init() {
        for(int i=0; i<10; i++) {
            this.add(i);
        }
        return head;
    }

    //

    /**
     * 获取链表长度
     *
     * @param head 链表头结点
     * @return 链表长度
     */
    public static int getLength(Node head) {
        if (head == null) {
            return -1;
        }

        int length = 0;
        Node current = head;
        while(current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

}