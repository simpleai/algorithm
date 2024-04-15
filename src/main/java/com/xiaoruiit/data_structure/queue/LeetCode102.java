package com.xiaoruiit.data_structure.queue;

import com.xiaoruiit.data_structure.tree.MyTree;
import com.xiaoruiit.data_structure.tree.TreeNode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树层次遍历
 */
public class LeetCode102 {

    public static void main(String[] args) {
        layersPrintTree(MyTree.init());
    }

    public static List<List<Integer>> layersPrintTree(TreeNode2 node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        LinkedList<TreeNode2> queue = new LinkedList<TreeNode2>();
        // 根入队。
        queue.offer(node);
        // 出队头，并打印，遍历左右并入队；出队头，并打印，遍历左右并入队；
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode2 treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            result.add(list);
        }

        return result;
    }
}
