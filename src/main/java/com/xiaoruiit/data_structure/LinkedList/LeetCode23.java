package com.xiaoruiit.data_structure.LinkedList;

import com.xiaoruiit.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hanxiaorui
 * @date 2024/4/11
 */
public class LeetCode23 {

    /**
     * LeetCode 困难 23.合并K个升序链表
     * 思路：使用优先队列
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null){
            return null;
        }

        ListNode hummy = new ListNode();
        ListNode current = hummy;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 初始化小根堆
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                priorityQueue.offer(lists[i]);
        }

        while (!priorityQueue.isEmpty()){
            ListNode poll = priorityQueue.poll();

            current.next = poll;// 连接
            current = current.next;// 前移

            if (poll.next != null){
                priorityQueue.offer(poll.next);
            }
        }

        return hummy.next;
    }
}
