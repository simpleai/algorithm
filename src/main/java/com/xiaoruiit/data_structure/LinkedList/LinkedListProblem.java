package com.xiaoruiit.data_structure.LinkedList;


import com.xiaoruiit.util.ListNode;
import com.xiaoruiit.util.MyLinkedList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 链表算法题
 */
public class LinkedListProblem {

    public static void main(String[] args) {

    }

    /**
     * 奇数个元素的链表，查找出这个链表中间位置的结点。
     */
    public static int getOddLinkedListMiddleNum(ListNode head) {
        if (head == null) {
            return -1;
        }
        /*if (MyLinkedList.getLength(head) % 2 == 0){
            throw new MyException("链表长度是偶数");
        }*/
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return (int) slow.val;
    }

}
