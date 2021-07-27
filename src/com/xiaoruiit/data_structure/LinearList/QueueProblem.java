package com.xiaoruiit.data_structure.LinearList;

import com.xiaoruiit.data_structure.tree.TreeNode;

import java.util.LinkedList;

/**
 * 队列算法题
 */
public class QueueProblem {

    /**
     * 约瑟夫环问题
     * 已知 n 个人（以编号 1，2，3...n 分别表示）围坐在一张圆桌周围。
     * 从编号为 k 的人开始报数，数到 m 的那个人出列；
     * 他的下一个人又从 1 开始报数，数到 m 的那个人又出列；
     * 依此规律重复下去，直到圆桌周围的人全部出列。
     */
    public static int[] josephRing(int n, int m, int k) {
        // 校验
        if (n < 1 || m < 1 || k < 1 || k < n) {
            return null;
        }
        int[] result = new int[n];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        // 将 n 个数 从 k 添加到队列
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (k <= n) {
                queue.offer(k);
                k++;
            } else {
                queue.offer(count);
                count++;
            }
        }

        int countNum = 0;
        int numberOf = 1;
        while (!queue.isEmpty()) {
            if (numberOf < m) {
                queue.offer(queue.poll());
                numberOf++;
            }
            if (numberOf == m) {
                result[countNum] = queue.poll();
                numberOf = 1;
                countNum++;
            }
        }

        return result;
    }

    /**
     * 按层次打印二叉树
     */
    public static void layersPrintTree(TreeNode node) {
        if (node == null) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        // 根入队。
        queue.offer(node);
        // 出队头，并打印，遍历左右并入队；出队头，并打印，遍历左右并入队；
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.data);
            if (treeNode.leftNode != null) {
                queue.offer(treeNode.leftNode);
            }
            if (treeNode.rightNode != null) {
                queue.offer(treeNode.rightNode);
            }
        }
    }

}
