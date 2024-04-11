package com.xiaoruiit.data_structure.LinkedList;

import java.util.Stack;

/**
 * @author hanxiaorui
 * @date 2024/4/11
 */
public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dum = new ListNode(-1, head);
        ListNode pre = dum;

        while (pre.next != null && pre.next.next != null) {
            ListNode one = pre.next;
            ListNode two = pre.next.next;
            one.next = two.next;
            two.next = one;
            pre.next = two;
            pre = one;
        }
        return dum.next;
    }
}
