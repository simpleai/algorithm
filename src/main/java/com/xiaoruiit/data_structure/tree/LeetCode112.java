package com.xiaoruiit.data_structure.tree;

import com.xiaoruiit.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanxiaorui
 * @date 2024/4/17
 */
public class LeetCode112 {
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

        System.out.println(hasPathSum(treeNode, 9));

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);

    }

    public static boolean dfs(TreeNode root, int targetSum, int sum){
        if (root == null){
            return false;
        }

        sum += root.val;
        if (root.left == null && root.right == null){
            if (sum == targetSum){
                return true;
            }
        }

        return  dfs(root.left, targetSum, sum) || dfs(root.right, targetSum, sum);
    }
}
