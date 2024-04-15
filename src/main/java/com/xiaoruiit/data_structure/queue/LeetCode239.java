package com.xiaoruiit.data_structure.queue;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * tags: ['队列']
 */
public class LeetCode239 {

    public static void main(String[] args) {
        int[] nums239 = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(leetCode239(nums239,3)));
    }
    /**
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

        // 前k个元素入队下标
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
            // 滑动前
            if (queue.peekFirst() + k == i) {
                queue.pollFirst();
            }

            // 滑动后
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {// 队列倒序，去除队列中比当前值小的数
                queue.pollLast();
            }
            queue.offerLast(i);

            result[i - k + 1] = nums[queue.peekFirst()];
        }
        return result;
    }
}
