package com.xiaoruiit.data_structure.LinkedList;

import com.xiaoruiit.data_structure.stack.StackProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 链表算法题
 */
public class LinkedListProblem {

    public static void main(String[] args) {

        // LeetCode 简单 206.反转单链表
        System.out.print("206.反转单链表：");
        MyLinkedList.print(reverseList(new MyLinkedList().init()));

        // LeetCode 简单 141.环形链表
        MyLinkedList list141 = new MyLinkedList();
        System.out.println("141.环形链表：" + hasCycle(list141.init()));

        // LeetCode 19.删除链表的倒数第 N 个结点
        MyLinkedList list19 = new MyLinkedList();
        System.out.print("19.环形链表：");
        MyLinkedList.print(removeNthFromEnd(list19.init(), 9));

        // LeetCode 简单 876.链表的中间结点
        MyLinkedList list876 = new MyLinkedList();
        System.out.println("876.链表的中间结点：" + middleNode(list876.init()).val);

        // LeetCode 25.K个一组翻转链表
        System.out.print("25.K个一组翻转链表：");
        MyLinkedList.print(LinkedListProblem.leetCode25(new MyLinkedList().init(),3));

        System.out.print("25.K个一组翻转链表2：");
        MyLinkedList.print(LinkedListProblem.reverseKGroup(new MyLinkedList().init(),3));

    }

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

    /**
     * LeetCode 简单 206.反转单链表
     * 思路：需要先拿到需要翻转指向的next,防止丢失下一个位置。
     *
     * 1 → 2 → 3
     * null ← 1 → 2 → 3
     * null ← 1 ← 2 → 3
     */
    public static ListNode reverseList(ListNode head) {
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

    /**
     * LeetCode 19.删除链表的倒数第 N 个结点
     * 思路：快慢指针，A先走n个节点后，A、B同时向前，知道A到达尾部，此时B为倒数第n个节点；想删除倒数第n个节点，需要拿到的是它的前一个节点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode one = dummy;
        ListNode two = head;

        while (n > 0){
            two = two.next;
            n--;
        }

        while (two != null){
            one = one.next;
            two = two.next;
        }

        one.next = one.next.next;// 删除

        return dummy.next;
    }

    /**
     * LeetCode 简单 876. 链表的中间结点
     */
    public static ListNode middleNode(ListNode head) {
        ListNode hummy = new ListNode();
        hummy.next = head;

        ListNode slow = hummy;
        ListNode fast = hummy;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.next;
    }

    /**
     * 奇数个元素的链表，查找出这个链表中间位置的结点。
     */
    public static int getOddLinkedListMiddleNum(ListNode head) {
        if (head == null) {
            return -1;
        }
        /*if (MyLinkedList.getLength(head) % 2 == 0){
            throw new MyException("链表长度是偶数");
        }*/
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return (int) slow.val;
    }

    /**
     * LeetCode 困难 25.K个一组翻转链表 two
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode();
        hair.next = head;

        ListNode pre = hair;// k个一组的前一个节点
        ListNode kHead = head; // k个一组的头结点

        while (kHead != null){
            ListNode kTail = kHead;// k个一组的尾结点

            for (int i = 1; i < k; i++) {
                kTail = kTail.next;

                if (kTail == null){
                    return hair.next;
                }
            }

            ListNode kNext = kTail.next;

            // 反转链表
            reverseList(kHead, kTail);

            // 连接链表
            pre.next = kTail;
            kHead.next = kNext;
            // pre、kHead归位
            pre = kHead;
            kHead = kNext;
        }

        return hair.next;
    }

    private static void reverseList(ListNode kHead, ListNode kTail) {
        if (kHead == kTail){// 1个节点不反转
            return;
        }

        ListNode pre = kHead;
        ListNode current = kHead.next;

        while (current != kTail){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        if (current == kTail){
            kTail.next = pre;
            return;
        }
    }

    /**
     * LeetCode 困难 25.K个一组翻转链表
     *
     * 给你一个链表，每 k个节点一组进行翻转，请你返回翻转后的链表。k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     */

    public static ListNode leetCode25(ListNode head, int k) {
        ListNode hair = new ListNode();
        hair.next = head;

        ListNode current = head;
        ListNode pre = hair;// k个节点的前一个元素

        while (current != null) {

            // 剩余节点不是k的倍数
            ListNode kTail = pre;
            for (int i = 0; i < k; i++) {
                kTail = kTail.next;
                if (kTail.next == null) {
                    return hair.next;
                }
            }

            ListNode kNext = kTail.next;// k个节点的后一个元素
            ListNode[] nodes = new ListNode[2];// 记录k个节点的头和尾

            nodes[0] = kTail;// 翻转k个节点后，节点中的第一个元素
            nodes[1] = current; // 翻转k个节点后，节点中的最后一个元素

            reverseNode(current, kTail);

            // k 个节点链接回原链表
            pre.next = nodes[0];
            nodes[1].next = kNext;

            pre = nodes[1];// pre变为翻转后k个结点的尾部
            current = current.next;// current变为翻转后k个结点的下一个结点
        }

        return hair.next;
    }

    public static void reverseNode(ListNode current, ListNode kTail) {
        ListNode cPre = current;
        current = current.next;
        while (cPre != kTail){
            ListNode nex = current.next;
            current.next = cPre;
            cPre = current;
            current = nex;
        }

    }

}
