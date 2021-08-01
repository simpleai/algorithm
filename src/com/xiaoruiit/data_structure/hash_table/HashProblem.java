package com.xiaoruiit.data_structure.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表算法题
 */
public class HashProblem {

    /**
     * leetCode 1. 两数之和
     *
     * 给定一个整数数组 arr 和一个目标值 target，请你在该数组中找出加和等于目标值的数组下标，并返回。
     * 你可以假设，原数组中没有重复元素，而且有且只有一组答案。但是，数组中的元素只能使用一次。例如，arr = [1, 2, 3, 4, 5, 6]，target = 4。因为，arr[0] + arr[2] = 1 + 3 = 4 = target，则输出 0，2。
     */
    public static int[] twoSums(int[] arr, int target){
        int[] result = new int[2];
        // 构建哈希表
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(arr.length);// 优化：hash默认长度16，超出时扩容。
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
        }
        // 哈希表中查找
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.get(target - entry.getKey()) != null){
                result[0] = entry.getValue();
                result[1] = map.get(target - entry.getKey());
                return result;
            }
        }
        return null;
    }

}
