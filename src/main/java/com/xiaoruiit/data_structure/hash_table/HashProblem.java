package com.xiaoruiit.data_structure.hash_table;

import com.xiaoruiit.data_structure.LinkedList.LeetCode146;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表算法题
 */
public class HashProblem {

    public static void main(String[] args) {

        // leetCode 1. 两数之和
        int[] arr = {3,3};
        System.out.println(Arrays.toString(HashProblem.twoSums(arr, 6)));
    }

    /**
     * leetCode 1. 两数之和
     *
     * 给定一个整数数组 arr 和一个目标值 target，请你在该数组中找出加和等于目标值的数组下标，并返回。
     * 你可以假设，原数组中没有重复元素，而且有且只有一组答案。但是，数组中的元素只能使用一次。例如，arr = [1, 2, 3, 4, 5, 6]，target = 4。因为，arr[0] + arr[2] = 1 + 3 = 4 = target，则输出 0，2。
     */
    public static int[] twoSums(int[] nums, int target){
        int[] result = new int[2];
        // 构建哈希表
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length);// 优化：hash默认长度16，超出时扩容。
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        // 哈希表中查找
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && map.get(temp) != i){
                return new int[]{i, map.get(temp)};
            }
        }

        return null;
    }

    /**
     * @see com.xiaoruiit.data_structure.queue.QueueProblem#leetCode347 leetCode347
     */


    /**
     * @see LeetCode146
     */
}
