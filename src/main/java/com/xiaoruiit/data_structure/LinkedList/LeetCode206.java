package com.xiaoruiit.data_structure.LinkedList;


import com.xiaoruiit.util.ListNode;
import com.xiaoruiit.util.MyLinkedList;

/**
 * 反转单链表
 * 简单
 * tags: ['链表','双指针']
 */
public class LeetCode206 {

    public static void main(String[] args) {
        ListNode.printList(reverseList(ListNode.constructList(new int[]{1,2,3,4})));

        MyLinkedList.print(reverseList2(new MyLinkedList().init()));
    }

    /**
     * LeetCode206 反转链表
     * null a -> b -> c -> d
     * a -> null  b -> c -> d
     * 先拿到b，然后a就可以指向null，null变为a,a变为b
     * 先拿到下一个节点，然后当前节点就可以指向前一个节点，前一个节点变为当前节点，当前节点变为下一个节点；
     */


    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


    /**
     * LeetCode 简单 206.反转单链表
     * 思路：需要先拿到需要翻转指向的next,防止丢失下一个位置。
     *
     * 1 → 2 → 3
     * null ← 1 → 2 → 3
     * null ← 1 ← 2 → 3
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
