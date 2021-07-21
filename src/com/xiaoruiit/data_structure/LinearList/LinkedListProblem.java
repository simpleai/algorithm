package com.xiaoruiit.data_structure.LinearList;

/**
 * 链表算法题
 */
public class LinkedListProblem {

    /**
     * 反转单链表
     */
    public static Node reverserLinkedList(Node node){
        if (node == null){
            return null;
        }
        Node pre = null;
        Node current = node;
        Node next = current.next;
        // 1 → 2 → 3
        // null ← 1 → 2 → 3
        // null ← 1 ← 2 → 3

        while (current != null){
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
    public static int getOddLinkedListMiddleNum(Node node){
        if (node == null){
            return -1;
        }
        /*if (MyLinkedList.getLength(node) % 2 == 0){
            throw new MyException("链表长度是偶数");
        }*/
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return (int)slow.data;
    }

    /**
     * 判断链表是否有环
     */
    public static boolean judgeLinkedListLoop(Node node){
        if (node == null){
            return false;
        }
        /*if (MyLinkedList.getLength(node) % 2 == 0){
            throw new MyException("链表长度是偶数");
        }*/
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }

        return false;
    }


}
