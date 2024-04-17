package com.xiaoruiit.data_structure.tree;

import com.xiaoruiit.util.TreeNode;

/**
 * @author hanxiaorui
 * @date 2024/4/17
 */
public class LeetCode654 {
    public static void main(String[] args) {
        LeetCode654 leet = new LeetCode654();
        TreeNode treeNode = leet.constructMaximumBinaryTree2(new int[]{3,2,1,6,0,5});
        TreeNode treeNode2 = leet.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        System.out.println();
    }

    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (start > end){
            return null;
        }

        int index = getMaxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[index]);
        root.left = dfs(nums, start, index - 1);
        root.right = dfs(nums, index + 1, end);

        return root;
    }

    private int getMaxIndex(int[] nums, int start, int end) {
        int maxIndex = start;
        while (start <= end){
            if (nums[start] > nums[maxIndex]) {
                maxIndex = start;
            }
            start++;
        }
        return maxIndex;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int index = getMaxIndex(nums, 0, nums.length - 1);
        TreeNode root = new TreeNode(nums[index]);
        dfsLeft(nums, 0, index - 1, root);
        dfsRight(nums, index + 1, nums.length - 1, root);
        return root;
    }

    private void dfsLeft(int[] nums, int start, int end, TreeNode pre) {
        if (start > end){
            return;
        }

        int index = getMaxIndex(nums, start, end);
        TreeNode treeNode = new TreeNode(nums[index]);
        pre.left = treeNode;
        if (index > start && index < end){
            dfsLeft(nums, start, index - 1, treeNode);
            dfsRight(nums, index + 1, end, treeNode);
        } else if(index == start) {
            dfsRight(nums, index + 1, end, treeNode);
        } else if(index == end){
            dfsLeft(nums, start, index - 1, treeNode);
        }
    }

    private void dfsRight(int[] nums, int start, int end, TreeNode pre) {
        if (start > end){
            return;
        }

        int index = getMaxIndex(nums, start, end);
        TreeNode treeNode = new TreeNode(nums[index]);
        pre.right = treeNode;
        if (index > start && index < end){
            dfsLeft(nums, start, index - 1, treeNode);
            dfsRight(nums, index + 1, end, treeNode);
        } else if(index == start) {
            dfsRight(nums, index + 1, end, treeNode);
        } else if(index == end){
            dfsLeft(nums, start, index - 1, treeNode);
        }
    }

}
