package com.xiaoruiit.data_structure.LinkedList;


import com.xiaoruiit.algorithm.leetcode.ListNode;

/**
 *
 */
public class LeetCode206 {

    public static void main(String[] args) {
        ListNode.printList(reverseList(ListNode.constructList(new int[]{1,2,3,4})));
    }

    /**
     * LeetCode206 反转链表
     * null a -> b -> c -> d
     * a -> null  b -> c -> d
     * 先拿到b，然后a就可以指向null，null变为a,a变为b
     * 先拿到下一个节点，然后当前节点就可以指向前一个节点，前一个节点变为当前节点，当前节点变为下一个节点；
     */


    public static ListNode reverseList(com.xiaoruiit.algorithm.leetcode.ListNode head) {
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
}
