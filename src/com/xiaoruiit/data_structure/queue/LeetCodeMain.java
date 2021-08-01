package com.xiaoruiit.data_structure.queue;

import java.util.Arrays;

public class LeetCodeMain {

    public static void main(String[] args) {
        // 队列-约瑟夫环
        /*System.out.println(Arrays.toString(QueueProblem.josephRing(1,1,1)));*/

        // 队列-二叉树层次遍历
        /*QueueProblem.layersPrintTree(MyTree.init());*/

        // leetCode 239. 滑动窗口最大值
        int[] nums239 = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(QueueProblem.leetCode239(nums239,3)));

        // leetCode 347.前 K 个高频元素
        System.out.println(Arrays.toString(QueueProblem.leetCode347(new int[]{1,1,1,2,2,3}, 2)));


    }

}
