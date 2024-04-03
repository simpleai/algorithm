package com.xiaoruiit.data_structure.queue;

import com.xiaoruiit.data_structure.tree.MyTree;

import java.util.Arrays;

public class LeetCodeMain {

    public static void main(String[] args) {
        // 队列-约瑟夫环
        System.out.println(Arrays.toString(QueueProblem.josephRing(1,1,1)));

        // LeetCode102.二叉树层次遍历
        QueueProblem.layersPrintTree(MyTree.init());

        // LeetCode239. 滑动窗口最大值
        int[] nums239 = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(QueueProblem.leetCode239(nums239,3)));

        // leetCode347.前 K 个高频元素
        System.out.println(Arrays.toString(QueueProblem.leetCode347(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(QueueProblem.LeetCode347(new int[]{1,1,1,2,2,3}, 2)));
    }

}
