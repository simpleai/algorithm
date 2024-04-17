package com.xiaoruiit.algorithm.search;

import com.xiaoruiit.util.TreeNode;

import java.util.*;

/**
 * 广度优先搜索
 */
public class BFSTreeLeverOrder {
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        System.out.println(leetCode102(node));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(null);
        list.add(null);
        list.add(5);

        TreeNode node2 = TreeNode.constructTree(list);
        System.out.println("leetCode103:" +leetCode103(node2));

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(9);
        list2.add(20);
        list2.add(null);
        list2.add(null);
        list2.add(15);
        list2.add(7);
        TreeNode node3 = TreeNode.constructTree(list2);
        System.out.println("leetCode107:" + leetCode107(node3));
    }

    /**
     * 二叉树，返回自底向上的层序遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> leetCode107(TreeNode root){
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.addFirst(list);
        }

        return result;
    }


    /**
     * 二叉树的锯齿形层序遍历 广度优先搜索
     * @param root
     * @return
     */
    public static List<List<Integer>> leetCode103(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        boolean flag = true;// 从左往右；否则从右往左

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                if (flag){
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null){
                        queue.add(node.left);
                    }
                    if (node.right != null){
                        queue.add(node.right);
                    }

                } else {
                    TreeNode node = queue.pollLast();
                    list.add(node.val);
                    if (node.right != null){
                        queue.addFirst(node.right);
                    }
                    if (node.left != null){
                        queue.addFirst(node.left);
                    }
                }
            }
            flag = !flag;
            result.add(list);
        }
        return result;
    }

    /**
     * leetcode 102.二叉树的层序遍历 广度优先搜索
     * @param root
     * @return
     */
    public static List<List<Integer>> leetCode102(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(list);
        }

        return result;
    }


}


