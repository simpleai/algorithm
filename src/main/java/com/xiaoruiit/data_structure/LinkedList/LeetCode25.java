package com.xiaoruiit.data_structure.LinkedList;

import com.xiaoruiit.util.ListNode;
import com.xiaoruiit.util.MyLinkedList;

import java.util.LinkedList;

/**
 * @author hanxiaorui
 * @date 2024/4/11
 */
public class LeetCode25 {

    public static void main(String[] args) {
        // LeetCode 25.K个一组翻转链表
        System.out.print("25.K个一组翻转链表：");
        MyLinkedList.print(leetCode25(new MyLinkedList().init(),3));

        System.out.print("25.K个一组翻转链表2：");
        MyLinkedList.print(reverseKGroup(new MyLinkedList().init(),4));

        // LeetCode 25.K个一组翻转链表
        System.out.print("25.K个一组翻转链表3：");
        MyLinkedList.print(reverserLinkedPerKList(new MyLinkedList().init(),4));
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
     * 给定一个包含 n 个元素的链表，现在要求每 k 个节点一组进行翻转，打印翻转后的链表结果。其中，k 是一个正整数，且 n 可被 k 整除。
     * 例如，链表为 1 -> 2 -> 3 -> 4 -> 5 -> 6，k = 3，则打印 321654。
     */
    public static ListNode reverserLinkedPerKList(ListNode head, int k) {
        if (head == null || head.next == null || k == 1){
            return head;
        }

        ListNode hummy = new ListNode();
        hummy.next = head;
        ListNode pre = hummy;
        ListNode current = head;

        LinkedList<ListNode> list = new LinkedList<>();

        while (current != null){
            int i = 0;
            while (i < k){
                if (current != null){
                    list.add(current);
                    current = current.next;
                    i++;
                } else {
                    break;
                }
            }

            if (i == k){// 反转链表
                ListNode listNode = list.pollLast();
                ListNode kHead = listNode;
                while (list.size() > 0){
                    ListNode temp = list.pollLast();
                    listNode.next = temp;
                    listNode = temp;
                }
                pre.next = kHead;
                pre = listNode;
                listNode.next = current;
            } else {// 接上最后的无需反转的链表结点
                ListNode listNode = list.pollFirst();
                ListNode kHead = listNode;
                while (list.size() > 0){
                    ListNode temp = list.pollFirst();
                    listNode.next = temp;
                    listNode = temp;
                }
                pre.next = kHead;
                break;
            }
        }
        return hummy.next;
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
