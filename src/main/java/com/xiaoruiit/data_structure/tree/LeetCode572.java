package com.xiaoruiit.data_structure.tree;

import com.xiaoruiit.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode572 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(2);
        TreeNode treeNode = TreeNode.constructTree(list);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(1);
        list2.add(2);
        list2.add(1);
        TreeNode treeNode2 = TreeNode.constructTree(list2);
        System.out.println(isSubtree(treeNode, treeNode2));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null){
                queue.add(treeNode.left);
            }
            if (treeNode.right != null){
                queue.add(treeNode.right);
            }
//            if (judge(treeNode, subRoot)){
//                return true;
//            }

        }

        return false;
    }

    public static boolean judge(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null){
            return true;
        }
        if (root == null || subRoot == null){
            return false;
        }
        if (root.val != subRoot.val){
            return false;
        }
        return isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right);
    }
}
