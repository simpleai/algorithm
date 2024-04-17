package com.xiaoruiit.data_structure.tree;

import com.xiaoruiit.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * @author hanxiaorui
 * @date 2024/4/16
 */
public class LeetCode257 {

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

        System.out.println(binaryTreePaths(treeNode));

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        TreeNode treeNode2 = TreeNode.constructTree(list2);

        System.out.println(binaryTreePaths(treeNode2));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        addPath(root, "", res);

        return res;
    }

    private static void addPath(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }

        path += root.val;
        if (root.left == null && root.right == null){
            res.add(path);
        } else {
            path += "->";
            addPath(root.left, path, res);
            addPath(root.right, path, res);
        }
    }
}
