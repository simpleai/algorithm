package com.xiaoruiit.algorithm.dp;

import java.util.Arrays;

/**
 * 选择一些元素，使得和 = sum(nums) / k
 * tags: ['01背包','动态规划']
 */
public class LeetCode698 {
    public static void main(String[] args) {
        LeetCode698 leet = new LeetCode698();
        System.out.println(leet.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println(leet.canPartitionKSubsets(new int[]{1,2,3,4}, 3));
        System.out.println(leet.canPartitionKSubsets(new int[]{2,2,2,2,3,4,5}, 4));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k){
            return false;
        }

        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        if (sum % k != 0){
            return false;
        }

        int target = sum / k;
        if (max > target){
            return false;
        }

        Arrays.sort(nums);
        boolean[] isUse = new boolean[nums.length];

        kCopy = k;
        numsCopy = nums;
        targetCopy = target;
        return recursion(nums.length - 1, 0, 0, isUse);
    }

    int kCopy;
    int[] numsCopy;
    int targetCopy;

    /**
     *
     * @param start 遍历开始位置
     * @param curSum 当前集合总和
     * @param count 满足n个和 target
     * @param isUse 元素是否被使用
     * @return
     */
    public boolean recursion(int start, int curSum, int count, boolean[] isUse){
        if (count == kCopy){
            return true;
        }
        if (curSum == targetCopy){
            return recursion(numsCopy.length - 1, 0, count + 1, isUse);
        }

        for (int i = start; i >= 0; i--) {
            if (isUse[i] || curSum + numsCopy[i] > targetCopy){// 可行性剪枝
                continue;
            }

            isUse[i] = true;
            if(recursion(i - 1, curSum + numsCopy[i], count, isUse)) {
                return true;
            }
            isUse[i] = false;

            if (curSum == 0){// 可行性剪枝 这个数找不到其他数，加起来等于目标和
                return false;
            }
        }

        return false;
    }
}
