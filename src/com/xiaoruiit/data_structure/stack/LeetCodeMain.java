package com.xiaoruiit.data_structure.stack;

import com.xiaoruiit.data_structure.LinkedList.MyLinkedList;
import com.xiaoruiit.data_structure.LinkedList.Node;

import java.util.Arrays;

public class LeetCodeMain {

    public static void main(String[] args) {
        //LeetCode 20.有效的括号
        String[] str = {"a",")","(",")","]"};
        System.out.println(StackProblem.judgeBracketString(str));

        // leetCode 25.K 个一组翻转链表
        MyLinkedList linkedList = new MyLinkedList();
        Node node = linkedList.init();
        StackProblem.reverserLinkedList(node, 2);

        // leetCode 739.每日温度
        int[] tem739 = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(StackProblem.everydayTemperatures(tem739)));

    }

}
