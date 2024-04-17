package com.xiaoruiit.data_structure.tree;

import com.xiaoruiit.util.TreeNode;

import java.util.LinkedList;

/**
 * 相同的树
 * tags: ['广度优先搜索','二叉树']
 */
public class LeetCode100 {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(leetCode100(p, q));
        System.out.println(isSameTree(p, q));

        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);

        TreeNode q2 = new TreeNode(1);
        q2.right = new TreeNode(2);
        System.out.println(leetCode100(p2, q2));
        System.out.println(isSameTree(p2, q2));

        TreeNode p3 = new TreeNode(1);

        TreeNode q3 = new TreeNode(1);
        q3.right = new TreeNode(2);
        System.out.println(leetCode100(p3, q3));
        System.out.println(isSameTree(p3, q3));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private static boolean reIsSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return reIsSameTree(p.left, q.left) && reIsSameTree(p.right, q.right);
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
