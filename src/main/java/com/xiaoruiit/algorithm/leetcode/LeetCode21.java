package com.xiaoruiit.algorithm.leetcode;

public class LeetCode21 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4};
        int[] arr2 = new int[]{1,3,4};
        ListNode.printList(mergeTwoLists(ListNode.constructList(arr), ListNode.constructList(arr2)));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        } else if (list2 == null){
            return list1;
        }

        ListNode head = new ListNode();
        ListNode node = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
                node = node.next;
            } else {
                node.next = list2;
                list2 = list2.next;
                node = node.next;
            }
        }

        if (list1 == null){
            node.next = list2;
        } else if (list2 == null){
            node.next = list1;
        }

        return head.next;
    }

}
