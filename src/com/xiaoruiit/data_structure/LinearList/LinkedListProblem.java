package com.xiaoruiit.data_structure.LinearList;

/**
 * 链表算法题
 */
public class LinkedListProblem {

    /**
     * 反转单链表
     */
    public static Node reverserLinkedList(Node node) {
        if (node == null) {
            return null;
        }
        Node pre = null;
        Node current = node;
        Node next = current.next;
        // 1 → 2 → 3
        // null ← 1 → 2 → 3
        // null ← 1 ← 2 → 3

        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    /**
     * 奇数个元素的链表，查找出这个链表中间位置的结点。
     */
    public static int getOddLinkedListMiddleNum(Node node) {
        if (node == null) {
            return -1;
        }
        /*if (MyLinkedList.getLength(node) % 2 == 0){
            throw new MyException("链表长度是偶数");
        }*/
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return (int) slow.data;
    }

    /**
     * 判断链表是否有环
     */
    public static boolean judgeLinkedListLoop(Node node) {
        if (node == null) {
            return false;
        }
        /*if (MyLinkedList.getLength(node) % 2 == 0){
            throw new MyException("链表长度是偶数");
        }*/
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /**
     * LeetCode 第 25 题：给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     */

    public static Node leetCode25(Node head, int k) {
        Node hair = new Node();
        hair.next = head;

        Node current = head;
        Node pre = hair;// k个节点的前一个元素

        while (current != null) {

            // 剩余节点不是k的倍数
            Node kTail = pre;
            for (int i = 0; i < k; i++) {
                kTail = kTail.next;
                if (kTail.next == null) {
                    return hair.next;
                }
            }

            Node kNext = kTail.next;// k个节点的后一个元素
            Node[] nodes = new Node[2];// 记录k个节点的头和尾

            nodes[0] = kTail;// 翻转k个节点后，节点中的第一个元素
            nodes[1] = current; // 翻转k个节点后，节点中的最后一个元素

            reverseNode(current, kTail);

            // k 个节点链接回原链表
            pre.next = nodes[0];
            nodes[1].next = kNext;

            pre = nodes[1];// pre变为翻转后k个结点的尾部
            current = current.next;// current变为翻转后k个结点的下一个结点
        }

        return hair.next;
    }

    public static void reverseNode(Node current, Node kTail) {
        Node cPre = current;
        current = current.next;
        while (cPre != kTail){
            Node nex = current.next;
            current.next = cPre;
            cPre = current;
            current = nex;
        }

    }


}
