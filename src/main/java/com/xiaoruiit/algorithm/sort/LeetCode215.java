package com.xiaoruiit.algorithm.sort;

/**
 * @author hanxiaorui
 * @date 2024/4/10
 */
public class LeetCode215 {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    /**
     * LeetCode215.数组中的第K个最大元素
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        return nums[findKthLargest(nums, 0, nums.length - 1, k, false)];
    }

    private static int findKthLargest(int[] nums, int start, int end, int k, boolean flag) {
        if (flag){
            return k - 1;
        }

        int i = start, j = end;
        int point = nums[i];
        while (i < j){
            while (j > i){
                if (nums[j] > point){
                    nums[i] = nums[j];
                    i++;
                    break;
                }
                j--;
            }
            while (i < j){
                if (nums[i] < point){
                    nums[j] = nums[i];
                    j--;
                    break;
                }
                i++;
            }
        }
        nums[i] = point;

        if (i + 1 == k) {
            flag = true;
            return i;
        }
        if (i + 1 < k){
            return findKthLargest(nums, i + 1, end, k ,flag);
        } else {
            return findKthLargest(nums, start, i - 1, k, flag);
        }
    }
}
