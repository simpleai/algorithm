package com.xiaoruiit.data_structure.tree;

import com.xiaoruiit.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 * @author hanxiaorui
 * @date 2024/4/15
 */
public class LeetCode101 {

    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }

        return re(root.left, root.right);
    }

    private static boolean re(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null){
            return false;
        }

        if (left.val != right.val){
            return false;
        }
        return re(left.left, right.right) && re(left.right, right.left);
    }

    public static boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();

        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            TreeNode treeNode2 = queue.poll();
            if (treeNode == null && treeNode2 == null){
                continue;
            } else if (treeNode == null || treeNode2 == null){
                return false;
            } else if (treeNode.val != treeNode2.val){
                return false;
            }
            queue.add(treeNode.left);
            queue.add(treeNode2.right);

            queue.add(treeNode.right);
            queue.add(treeNode2.left);
        }

        return true;
    }
}
