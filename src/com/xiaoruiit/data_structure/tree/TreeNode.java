package com.xiaoruiit.data_structure.tree;

/**
 * 二叉树节点
 */
public class TreeNode {

    public int data;

    public TreeNode leftNode;

    public TreeNode rightNode;

    public TreeNode(int data){
        this.data = data;
    }

    /**
     * 二叉树中序遍历 左根右
     * 对于每一个节点，1.找他的左节点，2.打印他本身，3，找他的右节点
     * 结束条件 找到的节点为 null
     */
    public static void traverseTree(TreeNode rootNode) {
        if (rootNode == null){
            return;
        }
        traverseTree(rootNode.leftNode);
        System.out.println(rootNode.data);
        traverseTree(rootNode.rightNode);
    }
    /**
     * 新增 TODO
     */

    /**
     * 删除 TODO
     */
}
