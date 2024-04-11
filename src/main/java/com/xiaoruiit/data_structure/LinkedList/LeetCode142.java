package com.xiaoruiit.data_structure.LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 环形链表 II
 * @author hanxiaorui
 * @date 2024/4/11
 */
public class LeetCode142 {

    public static void main(String[] args) {

    }
    public static ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                slow = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode pre = new ListNode(-1, head);
        Set<ListNode> set = new HashSet<>();
        while (pre.next != null){
            pre = pre.next;
            if (set.contains(pre)){
                return pre;
            } else {
                set.add(pre);
            }
        }

        return null;
    }
}
