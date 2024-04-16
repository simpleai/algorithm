package com.xiaoruiit.data_structure.tree;

import com.xiaoruiit.util.TreeNode;

/**
 * 平衡二叉树
 * @author hanxiaorui
 * @date 2024/4/16
 */
public class LeetCode110 {
    public static void main(String[] args) {

    }


    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(hight(root.left) - hight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int hight(TreeNode root) {
        if(root == null){
            return 0;
        } else {
            return Math.max(hight(root.left), hight(root.right)) + 1;
        }
    }

    public static boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }

        return !(hight2(root) == -1);
    }

    private static int hight2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHight = hight2(root.left);
        if (leftHight == -1) {
            return -1;
        }
        int rightHight = hight2(root.right);
        if (rightHight == -1 || Math.abs(leftHight - rightHight) > 1){
            return -1;
        }

        return Math.max(leftHight, rightHight) + 1;
    }

}
