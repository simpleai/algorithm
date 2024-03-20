package com.xiaoruiit.algorithm.search;

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
        System.out.println(leetCode103(node2));



        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(leetCode100(p, q));

        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);

        TreeNode q2 = new TreeNode(1);
        q2.right = new TreeNode(2);
        System.out.println(leetCode100(p2, q2));

        TreeNode p3 = new TreeNode(1);

        TreeNode q3 = new TreeNode(1);
        q3.right = new TreeNode(2);
        System.out.println(leetCode100(p3, q3));
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

    /**
     * leetCode 100 相同的树
     * @param p
     * @param q
     * @return
     */
    public static boolean leetCode100(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> queuePList = new LinkedList<>();
        LinkedList<TreeNode> queueQList = new LinkedList<>();

        if(p == null && q == null){
            return true;
        } else if (p != null && q == null){
            return false;
        } else if (p == null && q != null){
            return false;
        }
        else if(p.val != q.val){
            return false;
        }

        queuePList.add(p.left);
        queuePList.add(p.right);
        queueQList.add(q.left);
        queueQList.add(q.right);
        while (!queuePList.isEmpty()){
            TreeNode queueP = queuePList.poll();
            TreeNode queueQ = queueQList.poll();
            if (queueP != null && queueQ == null){
                return false;
            } else if (queueP == null && queueQ != null){
                return false;
            }
            else if(queueP != null && queueQ != null && queueP.val != queueQ.val){
                return false;
            } else {
                if (queueP != null){
                    queuePList.add(queueP.left);
                    queuePList.add(queueP.right);
                }
                if (queueQ != null){
                    queueQList.add(queueQ.left);
                    queueQList.add(queueQ.right);
                }
            }
        }
        if (queueQList.isEmpty()){
            return true;
        }
        return false;
    }
}


