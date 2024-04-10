package com.xiaoruiit.data_structure.array;

/**
 * @author hanxiaorui
 * @date 2024/4/10
 */
public class LeetCode27 {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1,2,3,3,3,4}, 3));
        System.out.println(removeElement2(new int[]{1,2,3,3,3,4}, 3));
    }
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        while (i < len){
            if (nums[i] == val){
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j+1];
                }
                len--;
                i--;
            }
            i++;
        }

        return len;
    }

    public static int removeElement2(int[] nums, int val) {
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[left] = nums[i];
                left++;
            }
        }

        return left;
    }
}
