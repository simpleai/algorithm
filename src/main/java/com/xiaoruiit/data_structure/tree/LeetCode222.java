package com.xiaoruiit.data_structure.tree;

import com.xiaoruiit.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 完全二叉树的节点个数
 * @author hanxiaorui
 * @date 2024/4/15
 */
public class LeetCode222 {

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

        System.out.println(countNodes(treeNode));
    }

    static int count = 0;
    public static int countNodes(TreeNode root) {
        if (root != null){
            count++;
        }
        re(root);
        return count;
    }

    public static void re(TreeNode root){
        if (root == null){
            return;
        }

        if (root.left != null){
            count++;
            re(root.left);
        }

        if (root.right != null){
            count++;
            re(root.right);
        }
    }


    public static int countNodes2(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftCount = countNodes2(root.left);
        int rightCount = countNodes2(root.right);

        return leftCount + rightCount + 1;
    }
}
