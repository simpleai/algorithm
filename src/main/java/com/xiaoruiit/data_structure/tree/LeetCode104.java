package com.xiaoruiit.data_structure.tree;

import com.xiaoruiit.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最大深度
 * @author hanxiaorui
 * @date 2024/4/15
 */
public class LeetCode104 {

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

        System.out.println(maxDepth(treeNode));
    }

    static int max = 0;
    public static int maxDepth(TreeNode root) {
        re(root, 0);
        return max;
    }

    public static void re(TreeNode root, int len){
        if (root == null){
            max = Math.max(max, len);
            return;
        }

        re(root.left, len + 1);
        re(root.right, len + 1);
    }
}
