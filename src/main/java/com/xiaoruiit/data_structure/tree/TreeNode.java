package com.xiaoruiit.data_structure.tree;

/**
 * 二叉树节点
 */
public class TreeNode {

    public int data;

    public TreeNode leftNode;

    public TreeNode rightNode;

    public TreeNode parentNode;

    public TreeNode(int data){
        this.data = data;
    }

    public TreeNode(int data, TreeNode parentNode){
        this.data = data;
        this.parentNode = parentNode;
    }



}
