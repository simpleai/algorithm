package com.xiaoruiit.data_structure.tree;

/**
 * 二叉树节点
 */
public class TreeNode2 {

    public int val;

    public TreeNode2 left;

    public TreeNode2 right;

    public TreeNode2 parentNode;

    public TreeNode2(int data){
        this.val = data;
    }

    public TreeNode2(int data, TreeNode2 parentNode){
        this.val = data;
        this.parentNode = parentNode;
    }



}
