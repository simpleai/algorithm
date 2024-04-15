package com.xiaoruiit.data_structure.queue;

import java.util.*;

/**
 * 前 K 个高频元素
 * tags: ['队列']
 */
public class LeetCode347 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(leetCode347(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(LeetCode347(new int[]{1,1,1,2,2,3}, 2)));
    }
    /**
     * 1.map存值对应的次数
     * 2.用优先队列对map按照value大小排序
     * 3.优先队列的前k个即结果
     * @param nums
     * @param k
     * @return
     */
    public static int[] LeetCode347(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) ->  o2[1] - o1[1]);

        for (Integer i : map.keySet()) {
            queue.add(new int[]{i, map.get(i)});
        }

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
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
}
