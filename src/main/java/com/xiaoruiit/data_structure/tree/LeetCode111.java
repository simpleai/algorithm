package com.xiaoruiit.data_structure.tree;

import com.xiaoruiit.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最大深度
 * @author hanxiaorui
 * @date 2024/4/15
 */
public class LeetCode111 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(null);
        list.add(7);
        list.add(1);
        list.add(3);
        list.add(6);
        list.add(9);
        TreeNode treeNode = TreeNode.constructTree(list);

        System.out.println(minDepth(treeNode));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        if (root.left != null){
            min = Math.min(minDepth(root.left), min);
        }

        if (root.right != null){
            min = Math.min(minDepth(root.right), min);
        }

        return min + 1;
    }
}
