package com.xiaoruiit.data_structure.stack;

import com.xiaoruiit.data_structure.LinkedList.MyLinkedList;
import com.xiaoruiit.data_structure.LinkedList.ListNode;

import java.util.Arrays;

public class LeetCodeMain {

    public static void main(String[] args) {
        //LeetCode 20.有效的括号
        String[] str = {"a",")","(",")","]"};
        System.out.println(StackProblem.judgeBracketString(str));

        // leetCode 25.K 个一组翻转链表
        MyLinkedList linkedList = new MyLinkedList();
        ListNode node = linkedList.init();
        StackProblem.reverserLinkedList(node, 2);

        // leetCode 739.每日温度
        int[] tem739 = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(StackProblem.everydayTemperatures(tem739)));

        // leetCode 844.比较含退格的字符串
        System.out.println(StackProblem.backspaceCompare("#abc", "abc"));
        System.out.println(StackProblem.backspaceCompare("ab#c", "ac#c"));
        System.out.println(StackProblem.backspaceCompare("ab", "ac"));
    }

}
