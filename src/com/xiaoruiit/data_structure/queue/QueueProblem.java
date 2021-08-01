package com.xiaoruiit.data_structure.queue;

import com.xiaoruiit.data_structure.tree.TreeNode;

import java.util.*;

/**
 * 队列算法题
 */
public class QueueProblem {

    /**
     * 约瑟夫环问题
     * 已知 n 个人（以编号 1，2，3...n 分别表示）围坐在一张圆桌周围。
     * 从编号为 k 的人开始报数，数到 m 的那个人出列；
     * 他的下一个人又从 1 开始报数，数到 m 的那个人又出列；
     * 依此规律重复下去，直到圆桌周围的人全部出列。
     */
    public static int[] josephRing(int n, int m, int k) {
        // 校验
        if (n < 1 || m < 1 || k < 1 || k < n) {
            return null;
        }
        int[] result = new int[n];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        // 将 n 个数 从 k 添加到队列
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (k <= n) {
                queue.offer(k);
                k++;
            } else {
                queue.offer(count);
                count++;
            }
        }

        int countNum = 0;
        int numberOf = 1;
        while (!queue.isEmpty()) {
            if (numberOf < m) {
                queue.offer(queue.poll());
                numberOf++;
            }
            if (numberOf == m) {
                result[countNum] = queue.poll();
                numberOf = 1;
                countNum++;
            }
        }

        return result;
    }

    /**
     * 按层次打印二叉树
     */
    public static void layersPrintTree(TreeNode node) {
        if (node == null) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        // 根入队。
        queue.offer(node);
        // 出队头，并打印，遍历左右并入队；出队头，并打印，遍历左右并入队；
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.data);
            if (treeNode.leftNode != null) {
                queue.offer(treeNode.leftNode);
            }
            if (treeNode.rightNode != null) {
                queue.offer(treeNode.rightNode);
            }
        }
    }

    /**
     * leetCode 239. 滑动窗口最大值
     * <p>
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回滑动窗口中的最大值。
     * <p>
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * <p>
     * 分析：滑动窗口使用双端队列
     */
    public static int[] leetCode239(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // 前k个元素入队
        queue.offerLast(0);
        for (int i = 1; i < k; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();

            }
            queue.offerLast(i);

        }
        result[0] = nums[queue.peekFirst()];
        // 滑动窗口，获取窗口最大值
        for (int i = k; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);

            if (queue.peekFirst() + k == i) {
                queue.pollFirst();
            }
            result[i - k + 1] = nums[queue.peekFirst()];

        }
        return result;
    }

    /**
     * leetCode 347. 前 K 个高频元素
     * <p>
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     * <p>
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     *
     * 时间复杂度O(nlogk)
     */
    public static int[] leetCode347(int[] nums, int k) {
        int[] result = new int[k];

        // 统计整数数组nums 各个元素次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        // 构建优先队列（小根堆）
        PriorityQueue<int[]> priorityQueue = new PriorityQueue(k,new Comparator<int[]>() {
            @Override
            public int compare(int[] newValue, int[] pileTop) {// 小值放到堆顶
                return newValue[1] - pileTop[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            if (priorityQueue.size() == k && priorityQueue.peek()[1] < entry.getValue()) {
                priorityQueue.poll();
                priorityQueue.offer(new int[]{entry.getKey(),entry.getValue()});
            }
            if (priorityQueue.size() < k){
                priorityQueue.offer(new int[]{entry.getKey(),entry.getValue()});
            }
        }

        // 二叉堆的元素即前k大
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll()[0];
        }

        return result;
    }

    /**
     * LeetCode 212.单词搜索 II TODO 深度优先遍历
     *
     * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
     *
     * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
     *
     */


}
