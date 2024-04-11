package com.xiaoruiit.data_structure.LinkedList;

import com.xiaoruiit.util.ListNode;
import com.xiaoruiit.util.MyLinkedList;

/**
 * @author hanxiaorui
 * @date 2024/4/11
 */
public class LeetCode141 {

    public static void main(String[] args) {
        // LeetCode 简单 141.环形链表
        MyLinkedList list141 = new MyLinkedList();
        System.out.println("141.环形链表：" + hasCycle(list141.init()));
    }
    /**
     * LeetCode 简单 141.环形链表
     * 思路：使用快慢指针；如果有环，在环中一快一慢，转多圈肯定会相遇
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){// 环中相遇
                return true;
            }
        }

        return false;
    }
}
