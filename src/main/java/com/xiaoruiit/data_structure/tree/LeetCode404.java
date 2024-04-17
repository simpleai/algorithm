package com.xiaoruiit.data_structure.tree;

import com.xiaoruiit.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanxiaorui
 * @date 2024/4/17
 */
public class LeetCode404 {
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

        System.out.println(sumOfLeftLeaves(treeNode));


        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(9);
        list2.add(20);
        list2.add(null);
        list2.add(null);
        list2.add(15);
        list2.add(7);
        TreeNode treeNode2 = TreeNode.constructTree(list2);

        System.out.println(sumOfLeftLeaves(treeNode2));

        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(null);
        list3.add(9);
        list3.add(null);
        list3.add(null);
        list3.add(1);
        list3.add(2);
        TreeNode treeNode3 = TreeNode.constructTree(list3);

        System.out.println(sumOfLeftLeaves(treeNode3));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }

    public static int dfs(TreeNode root){
        int ans = 0;
        if (root == null){
            return ans;
        }

        if (root.left == null && root.right == null) {
            return ans;
        }

        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            ans += root.left.val;
        }

        ans += dfs(root.left);
        ans += dfs(root.right);

        return ans;
    }
}
