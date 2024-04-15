package com.xiaoruiit.data_structure.LinkedList;

import com.xiaoruiit.util.ListNode;
import com.xiaoruiit.util.MyLinkedList;

/**
 * 19.删除链表的倒数第 N 个结点
 * tags: ['链表','双指针']
 * @author hanxiaorui
 * @date 2024/4/11
 */
public class LeetCode19 {

    public static void main(String[] args) {
        MyLinkedList list19 = new MyLinkedList();
        MyLinkedList.print(removeNthFromEnd(list19.init(), 9));
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
}
