package com.xiaoruiit.data_structure.LinkedList;

import com.xiaoruiit.util.ListNode;

/**
 * @author hanxiaorui
 * @date 2024/4/11
 */
public class LeetCode21 {

    /**
     * LeetCode 21. 合并两个有序链表
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 边界
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }

        ListNode head = new ListNode();
        ListNode current = head;

        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }

        if (list1 == null){
            current.next = list2;
        } else if (list2 == null) {
            current.next = list1;
        }

        return head.next;
    }
}
