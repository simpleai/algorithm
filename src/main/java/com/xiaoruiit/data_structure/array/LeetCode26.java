package com.xiaoruiit.data_structure.array;

/**
 * @author hanxiaorui
 * @date 2024/4/10
 */
public class LeetCode26 {

    public static void main(String[] args) {
        System.out.println("LeetCode26:" + removeDuplicates(new int[]{1,1,2}));
    }

    /**
     * LeetCode 简单 26. 删除有序数组中的重复项
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int length = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[length] != nums[i]){
                nums[length + 1] = nums[i];
                length++;
            }
        }

        return length + 1;
    }
}
