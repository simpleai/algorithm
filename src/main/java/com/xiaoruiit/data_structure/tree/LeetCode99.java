package com.xiaoruiit.data_structure.tree;

import com.xiaoruiit.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 恢复二叉搜索树 https://leetcode.cn/problems/recover-binary-search-tree/description/
 * tags: ['二叉树']
 * @author hanxiaorui
 * @date 2024/4/3
 */
public class LeetCode99 {

    public static void main(String[] args) {
        LeetCode99 leet = new LeetCode99();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(null);
        list.add(null);
        list.add(2);
        TreeNode treeNode = TreeNode.constructTree(list);
        leet.recoverTree(treeNode);
        TreeNode.traverseTree(treeNode);

    }

    List<TreeNode> list = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        doRecoverTree(root);
        // 5 2 3 4 1
        TreeNode x = null, y = null;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val){// 第一次乱序 5 < 2, 记录 x = 5, y = 2; 第二次乱序 4 < 1, 更新记录 y = 1
                y = list.get(i + 1);
                if (x == null) {
                    x = list.get(i);
                } else {
                    break;
                }
            }
        }

        swap(x, y);
    }

    private void swap(TreeNode x, TreeNode y) {
        int t = x.val;
        x.val = y.val;
        y.val = t;
    }

    private void swap(int[] temp) {
        int t = list.get(temp[0]).val;
        list.get(temp[0]).val = list.get(temp[1]).val;
        list.get(temp[1]).val = t;
    }

    private void doRecoverTree(TreeNode root) {// 中序遍历，存到数组
        if (root == null){
            return;
        }

        doRecoverTree(root.left);
        list.add(root);
        doRecoverTree(root.right);
    }
}
