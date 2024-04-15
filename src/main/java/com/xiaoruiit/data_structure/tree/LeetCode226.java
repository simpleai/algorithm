package com.xiaoruiit.data_structure.tree;

import com.xiaoruiit.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 翻转二叉树
 * tags: ['递归','二叉树']
 */
public class LeetCode226 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(7);
        list.add(1);
        list.add(3);
        list.add(6);
        list.add(9);
        TreeNode treeNode = TreeNode.constructTree(list);
        TreeNode.traverseTree(treeNode);
        System.out.println();
        invertTree(treeNode);
        TreeNode.traverseTree(treeNode);
    }

    public static TreeNode invertTree(TreeNode root) {

        re(root);

        return root;
    }

    private static void re(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null || root.right != null) {
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
        }

        re(root.left);
        re(root.right);
    }
}
