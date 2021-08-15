package com.xiaoruiit.data_structure.tree;

/**
 * 二叉树
 */
public class MyTree {

    public TreeNode rootNode;

    public static TreeNode init() {
        TreeNode rootNode = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        rootNode.leftNode = node1;
        rootNode.leftNode.leftNode = node2;
        rootNode.leftNode.rightNode = node3;
        rootNode.rightNode = node4;
        rootNode.rightNode.rightNode = node5;
        return rootNode;
    }

    /**
     * 新增结点 TODO
     */

    /**
     * 删除结点
     */
}
