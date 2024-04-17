package com.xiaoruiit.data_structure.tree;

import com.xiaoruiit.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hanxiaorui
 * @date 2024/4/17
 */
public class LeetCode513 {
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

        System.out.println(findBottomLeftValue(treeNode));


        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(9);
        list2.add(20);
        list2.add(null);
        list2.add(null);
        list2.add(15);
        list2.add(7);
        TreeNode treeNode2 = TreeNode.constructTree(list2);

        System.out.println(findBottomLeftValue(treeNode2));

        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(null);
        list3.add(9);
        list3.add(null);
        list3.add(null);
        list3.add(1);
        list3.add(2);
        TreeNode treeNode3 = TreeNode.constructTree(list3);

        System.out.println(findBottomLeftValue(treeNode3));
    }

    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int val = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0){
                    val = poll.val;
                }
                if (poll.left != null){
                    queue.add(poll.left);
                }
                if (poll.right != null){
                    queue.add(poll.right);
                }
            }
        }

        return val;
    }
}
