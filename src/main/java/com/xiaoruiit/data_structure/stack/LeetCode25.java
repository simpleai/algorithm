package com.xiaoruiit.data_structure.stack;

import com.xiaoruiit.util.ListNode;
import com.xiaoruiit.util.MyLinkedList;

import java.util.Stack;

/**
 * K 个一组翻转链表
 */
public class LeetCode25 {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        ListNode node = linkedList.init();
        reverserLinkedList(node, 2);

    }
    /**
     * 给定一个包含 n 个元素的链表，现在要求每 k 个节点一组进行翻转，打印翻转后的链表结果。其中，k 是一个正整数，且 n 可被 k 整除。
     * 例如，链表为 1 -> 2 -> 3 -> 4 -> 5 -> 6，k = 3，则打印 321654。
     */
    public static void reverserLinkedList(ListNode head, int k) {
        if (head == null || k < 1) {
            return;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        int count = 0;
        while (head != null) {
            stack.push(head);
            count++;
            if (count == k) {
                while (!stack.empty()) {
                    System.out.println(stack.pop().val);
                }
                count = 0;
            }
            head = head.next;
        }
    }
}
