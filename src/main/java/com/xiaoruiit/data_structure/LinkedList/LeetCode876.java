package com.xiaoruiit.data_structure.LinkedList;

import com.xiaoruiit.util.ListNode;
import com.xiaoruiit.util.MyLinkedList;

/**
 * @author hanxiaorui
 * @date 2024/4/11
 */
public class LeetCode876 {

    public static void main(String[] args) {
        // LeetCode 简单 876.链表的中间结点
        MyLinkedList list876 = new MyLinkedList();
        System.out.println("876.链表的中间结点：" + middleNode(list876.init()).val);
    }
    /**
     * LeetCode 简单 876. 链表的中间结点
     */
    public static ListNode middleNode(ListNode head) {
        ListNode hummy = new ListNode();
        hummy.next = head;

        ListNode slow = hummy;
        ListNode fast = hummy;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.next;
    }
}
