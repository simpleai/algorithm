package com.xiaoruiit.util;

/**
 * 单链表
 */
public class MyLinkedList<T> {
    public ListNode head;

    public ListNode current;
    /**
     * 添加结点
     *
     * @param data
     */
    public void add(int data) {
        if (head == null){
            head = new ListNode(data);
            current = head;
        } else {
            current.next = new ListNode(data);
            current = current.next;
        }
    }

    /**
     * 打印链表
     *
     * @param node
     */
    public static void print(ListNode node) {
        if(node == null) {
            return;
        }

        ListNode current = node;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println("\n");
    }

    /**
     * 初始化链表,并且返回表头
     *
     * @return 头结点
     */
    public ListNode init() {
        for(int i=0; i<9; i++) {
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
    public static int getLength(ListNode head) {
        if (head == null) {
            return -1;
        }

        int length = 0;
        ListNode current = head;
        while(current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

}
