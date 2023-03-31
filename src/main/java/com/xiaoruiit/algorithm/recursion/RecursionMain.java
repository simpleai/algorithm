package com.xiaoruiit.algorithm.recursion;

import com.xiaoruiit.data_structure.tree.MyTree;
import com.xiaoruiit.data_structure.tree.TreeNode;

/**
 * 递归
 *
 * @see com.xiaoruiit.algorithm.sort.QuickSort 快排
 * @see com.xiaoruiit.algorithm.sort.MergeSort 归并排序
 *
 */

public class RecursionMain {
    public static void main(String[] args) {
        // 斐波那契数列
        long l1 = System.currentTimeMillis();
        System.out.println(RecursionProblem.fibonacciSequence(50));
        System.out.println(System.currentTimeMillis() - l1);

        long l2 = System.currentTimeMillis();
        System.out.println(RecursionProblem.fibonacciSequence2(50));
        System.out.println(System.currentTimeMillis() - l2);

        // 汉诺塔
        RecursionProblem.hanoi(3);

        // 中序遍历二叉树
        TreeNode rootNode = MyTree.init();
        MyTree.traverseTree(rootNode);
    }
}
