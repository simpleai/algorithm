package com.xiaoruiit.algorithm.leetcode;

import com.xiaoruiit.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode23 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.constructList(new int[]{1, 2, 3});
        ListNode listNode2 = ListNode.constructList(new int[]{1,22});
        ListNode[] lists = new ListNode[2];
        lists[0] = listNode;
        lists[1] = listNode2;
        ListNode.printList(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if(list != null){
                priorityQueue.add(list);
            }
        }

        ListNode head = new ListNode();
        ListNode current = head;
        while (!priorityQueue.isEmpty()){
            ListNode poll = priorityQueue.poll();
            current.next = poll;
            current = current.next;
            if (poll.next != null){
                priorityQueue.add(poll.next);
            }
        }

        return head.next;
    }
}
