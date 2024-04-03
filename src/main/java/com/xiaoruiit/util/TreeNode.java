package com.xiaoruiit.util;

import com.xiaoruiit.data_structure.tree.TreeNode2;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode constructTree(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(list.get(0));
        constructTreeHelper(list, root, 0);
        return root;
    }

    private static void constructTreeHelper(List<Integer> list, TreeNode node, int index) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < list.size() && list.get(leftIndex) != null) {
            node.left = new TreeNode(list.get(leftIndex));
            constructTreeHelper(list, node.left, leftIndex);
        }

        if (rightIndex < list.size() && list.get(rightIndex) != null) {
            node.right = new TreeNode(list.get(rightIndex));
            constructTreeHelper(list, node.right, rightIndex);
        }
    }

    public static void traverseTree(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        traverseTree(rootNode.left);
        System.out.print(rootNode.val +",");
        traverseTree(rootNode.right);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(null);
        list.add(null);
        list.add(2);
        TreeNode treeNode = constructTree(list);

        traverseTree(treeNode);
    }
}
