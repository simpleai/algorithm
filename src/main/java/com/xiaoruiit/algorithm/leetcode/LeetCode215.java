package com.xiaoruiit.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * @author hanxiaorui
 * @date 2024/4/1
 */
public class LeetCode215 {

    public static void main(String[] args) {
        System.out.println(LeetCode215(new int[]{3,2,1,5,6,4}, 2));
    }
    public static int LeetCode215(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o1 - o2);
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (queue.peek() < arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        return queue.poll();
    }
}
