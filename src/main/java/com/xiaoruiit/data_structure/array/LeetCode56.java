package com.xiaoruiit.data_structure.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 合并区间
 * tags: ['排序','数组']
 * @author hanxiaorui
 * @date 2024/4/11
 */
public class LeetCode56 {

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < intervals.length; i++) {
            queue.add(intervals[i]);
        }

        int[] arr = queue.poll();
        while (!queue.isEmpty()) {
            int[] arr2 = queue.poll();
            if (arr[1] > arr2[1]){

            } else if (arr[1] >= arr2[0]){
                arr[1] = arr2[1];
            } else {
                list.add(arr);
                arr = arr2;
            }
        }

        list.add(arr);

        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
