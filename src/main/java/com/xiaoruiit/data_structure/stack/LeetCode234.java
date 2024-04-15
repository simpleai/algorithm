package com.xiaoruiit.data_structure.stack;

import com.xiaoruiit.util.ListNode;

import java.util.Stack;

public class LeetCode234 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(ListNode.constructList(new int[]{1})));
        System.out.println(isPalindrome(ListNode.constructList(new int[]{1,2})));
        System.out.println(isPalindrome(ListNode.constructList(new int[]{1,2,1})));
        System.out.println(isPalindrome(ListNode.constructList(new int[]{1,2,2,1})));
        System.out.println(isPalindrome(ListNode.constructList(new int[]{1,2,2,2,1})));
        System.out.println(isPalindrome(ListNode.constructList(new int[]{1,1,2,1})));
    }
    /**
     * LeetCode234.回文链表
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode current = pre;
        while(current.next != null) {
            stack.push(current.next);
            current = current.next;
        }

        while (!stack.isEmpty() && pre.next != null) {
            if (stack.pop().val != pre.next.val) {
                return false;
            }
            pre = pre.next;
        }

        if (stack.isEmpty() && pre.next == null){
            return true;
        }
        return false;
    }
}
