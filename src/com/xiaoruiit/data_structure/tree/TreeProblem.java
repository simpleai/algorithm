package com.xiaoruiit.data_structure.tree;

public class TreeProblem {

    /**
     * 输入一个字符串，判断它在已有的字符串集合中是否出现过? TODO
     *
     * @param node
     * @param trieTree
     * @return
     */
    public static boolean trieTree(TreeNode node, TrieTree trieTree){

        return false;
    }

    /**
     * leetCode 230.二叉搜索树中第K小的元素
     *
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     */
    public static int leetCode230(TreeNode node, int k){

        return preorderTraverseTree(node, k);
    }

    private static int preorderTraverseTree(TreeNode node, int k) {
        if (node == null){
            return k;
        }
        preorderTraverseTree(node.leftNode,k);
        k--;
        if (k == 0){
            return node.data;
        }
        preorderTraverseTree(node.rightNode,k);
        return k;
    }
}
