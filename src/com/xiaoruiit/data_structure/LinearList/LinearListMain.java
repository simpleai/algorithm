package com.xiaoruiit.data_structure.LinearList;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 线性表Main
 */
public class LinearListMain {
    public static void main(String[] args) {

        /*// 初始化单链表
        MyLinkedList linkedList = new MyLinkedList();
        Node node = linkedList.init();
        linkedList.print(node);
        // 反转单链表并打印
        Node reverserNode = LinkedListProblem.reverserLinkedList(node);
        MyLinkedList.print(reverserNode);
        */

        /*
        // 初始化单链表
        MyLinkedList linkedList = new MyLinkedList();
        Node node = linkedList.init();
        linkedList.add(10);
        linkedList.print(node);

        // 奇数链表的中间节点数值
        System.out.println(LinkedListProblem.getOddLinkedListMiddleNum(node));
        */

        // 初始化单链表
        MyLinkedList linkedList = new MyLinkedList();
        Node node = linkedList.init();

        node.next = node.next.next.next.next;
        linkedList.print(node);

        // 奇数链表的中间节点数值
        System.out.println(LinkedListProblem.judgeLinkedListLoop(node));

    }

}


