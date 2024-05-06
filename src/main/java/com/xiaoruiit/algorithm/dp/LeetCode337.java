package com.xiaoruiit.algorithm.dp;

import com.xiaoruiit.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 打家劫舍 III
 * tags: ['动态规划']
 * 每个节点有选和不选两个状态 f：选择；g：不选择。o：当前节点；l：当前节点的左孩子；r：当前节点的右孩子
 * f(o) = o.val + g(l) + g(r)； g(o) = max(f(l),g(l)） + max(f(r), g(r))
 * @author hanxiaorui
 * @date 2024/4/25
 */
public class LeetCode337 {
    public static void main(String[] args) {
        LeetCode337 leet = new LeetCode337();

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(null);
        list.add(3);
        list.add(null);
        list.add(1);

        System.out.println(leet.rob(TreeNode.constructTree(list)));

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(1);
        list2.add(3);
        list2.add(null);
        list2.add(4);

        System.out.println(leet.rob(TreeNode.constructTree(list2)));
    }

    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }

        dfs(root);

        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode root){
        if (root == null){
            return;
        }

        // 后序遍历
        dfs(root.left);
        dfs(root.right);

        f.put(root,root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0)) + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
    }
}
