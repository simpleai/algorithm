package com.xiaoruiit.data_structure.queue;

import com.xiaoruiit.data_structure.tree.MyTree;
import com.xiaoruiit.util.TreeNode;

import java.util.*;

public class LeetCodeMain {

    public static void main(String[] args) {
        // 队列-约瑟夫环
        System.out.println(Arrays.toString(QueueProblem.josephRing(1,1,1)));

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(9);
        list2.add(20);
        list2.add(null);
        list2.add(null);
        list2.add(15);
        list2.add(7);
        TreeNode node3 = TreeNode.constructTree(list2);
        System.out.println("leetCode107:" + levelOrderBottom(node3));
    }


    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<List<Integer>> stack = new Stack<>();

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            stack.add(list);
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }
}
