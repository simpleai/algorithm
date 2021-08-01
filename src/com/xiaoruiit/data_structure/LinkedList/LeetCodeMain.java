package com.xiaoruiit.data_structure.LinkedList;

import com.xiaoruiit.data_structure.stack.StackProblem;

import java.util.Arrays;

public class LeetCodeMain {

    public static void main(String[] args) {
        // leetCode 25.K 个一组翻转链表
        MyLinkedList.print(LinkedListProblem.leetCode25(new MyLinkedList().init(),3));

        // leetCode 739.每日温度
        int[] tem739 = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(StackProblem.everydayTemperatures(tem739)));

    }

}
