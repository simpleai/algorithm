package com.xiaoruiit.data_structure.LinkedList;

import com.xiaoruiit.util.ListNode;

/**
 * 移除链表元素
 * @author hanxiaorui
 * @date 2024/4/11
 */
public class LeetCode203 {

    public static void main(String[] args) {
        ListNode.printList(removeElements(ListNode.constructList(new int[]{1,2,6,3,4,5,6}), 6));
        ListNode.printList(removeElements(ListNode.constructList(new int[]{7,7,7,7}), 7));
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dum = new ListNode(-1, head);
        dum.next = head;

        ListNode pre = dum;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }

        return dum.next;
    }
}
