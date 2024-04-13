package com.xiaoruiit.data_structure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author hanxiaorui
 * @date 2023/2/22
 */
public class ArrayProblem {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(notRepeat(new int[] {1, 1, 1, 2, 2, 3, 4, 4, 5})));
        System.out.println(Arrays.toString(notRepeat(new int[] {1, 1})));
        System.out.println(Arrays.toString(notRepeat(new int[] {1, 2})));
        System.out.println(Arrays.toString(notRepeat(new int[] {1, 2, 2})));

        notRepeat2(new int[] {1, 1, 1, 2, 2, 3, 4, 4, 5});
        notRepeat2(new int[] {1, 1});
        notRepeat2(new int[] {1, 2});
        notRepeat2(new int[] {1, 2, 2});

        merge56(new int[][]{{1,3},{2,6},{8,10}});
    }

    /**
     * 1. 排序
     */
    public static int[][] merge56(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < intervals.length; i++) {
            queue.add(intervals[i]);
        }

        int[] arr = queue.poll();
        while (!queue.isEmpty()) {
            int[] arr2 = queue.poll();
            if (arr[1] > arr2[1]){

            }
            if (arr[1] >= arr2[0]){
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

    /**
     * 有序数组输出不重复的数据
     * @param nums
     * @return
     */
    public static int[] notRepeat(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1){
            return nums;
        }

        int[] result = new int[nums.length];

        int slow = 0, fast = 1;
        int temp = 0;
        while (fast < nums.length){
            if (nums[slow] != nums[fast]){
                result[temp++] = nums[slow];
                slow++;
                fast++;
            } else{
                fast++;
                while (fast < nums.length && nums[slow] != nums[fast]){
                    slow = fast;
                    fast++;
                    break;
                }
            }
        }

        if (nums[fast - 1] != nums[fast - 2])
            result[temp] = nums[fast - 1];

        return result;
    }

    /**
     * 有序数组输出不重复的数据
     * 分析：处理 有序数组保证 数与前一位、后一位都不同即可；尾部特殊处理
     * @param arr
     * @return
     */
    public static void notRepeat2(int[] arr) {
        int i = 1;

        if (arr[0] != arr[1]){
            System.out.print(arr[0]);
        }

        while (i < arr.length - 1) {// 处理下标 1 至 length-2
            if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1]) {
                System.out.print(arr[i]);
            }
            i++;
        }

        if (arr[i] != arr[i - 1]){// 处理尾部下标 length-1
            System.out.print(arr[i]);
        }

        System.out.println();
    }
}
