package com.xiaoruiit.data_structure.LinkedList;

/**
 * @author hanxiaorui
 * @date 2024/4/11
 */
public class LeetCode707 {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        System.out.println(myLinkedList.get(4));// 4
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5, 0);
        myLinkedList.addAtHead(6);

    }
}

class MyLinkedList {

    ListNode pre;

    int size;

    public MyLinkedList() {
        pre = new ListNode();
        size = 0;
    }

    public int get(int index) {
        if (index > size - 1){
            return -1;
        }
        ListNode dum = pre;
        for (int i = 0; i <= index; i++) {
            dum = dum.next;
        }
        return dum.val;
    }

    public void addAtHead(int val) {
        ListNode listNode = new ListNode(val, pre.next);
        pre.next = listNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode dum = pre;
        while (dum.next != null){
            dum = dum.next;
        }

        ListNode listNode = new ListNode(val);
        dum.next = listNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size){
            return;
        }

        ListNode dum = pre;
        for (int i = 0; i < index; i++) {
            dum = dum.next;
        }
        ListNode listNode = new ListNode(val, dum.next);
        dum.next = listNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index > size - 1){
            return;
        }

        ListNode dum = pre;
        for (int i = 0; i < index; i++) {
            dum = dum.next;
        }

        dum.next = dum.next.next;

        size--;
    }
}

class ListNode{

    int val;
    ListNode next;

    ListNode(){
    }
    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode listNode){
        this.val = val;
        this.next = listNode;
    }
}
