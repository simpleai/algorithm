package com.xiaoruiit.algorithm.dp;

import java.util.Arrays;

/**
 * 选择一些元素，使得和 = sum(nums) / 4
 * tags: ['01背包','动态规划','回溯']
 */
public class LeetCode473 {
    public static void main(String[] args) {
        LeetCode473 leet = new LeetCode473();
//        System.out.println(leet.makesquare(new int[]{1,1,2,2,2}));
//        System.out.println(leet.makesquare(new int[]{3,3,3,3,4}));
        System.out.println(leet.makesquare(new int[]{5,5,5,5,4,4,4,4,3,3,3,3}));
    }

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4){
            return false;
        }

        int sum = 0,max = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
            max = Math.max(max, matchsticks[i]);
        }

        int target = sum / 4;

        if (sum % 4 != 0 || max > target){
            return false;
        }

        Arrays.sort(matchsticks);
        arr = matchsticks;
        targetCopy = target;

        boolean[] isUse = new boolean[matchsticks.length];

        return recursion(arr.length - 1, 0, 0, isUse);
    }

    int[] arr;
    int targetCopy;

    /**
     *
     * @param start
     * @param curSum
     * @param count
     * @param isUse
     * @return
     * @see LeetCode698
     */
    public boolean recursion(int start, int curSum, int count, boolean[] isUse){
        if (count == 4){
            return true;
        }
        if (curSum == targetCopy){// 表示当前子集和达到目标值
            count++;
            return recursion(arr.length - 1, 0, count, isUse);// 递归调用并重置开始数、curSum
        }

        for (int i = start; i >= 0; i--) {
            // 可行性剪枝
            if (isUse[i] || curSum + arr[i] > targetCopy){// 检查当前元素是否已使用或添加后超过目标和，如果是则跳过
                continue;
            }

            isUse[i] = true;
            if (recursion(i - 1, curSum + arr[i], count, isUse)){
                return true;
            }
            isUse[i] = false;

            // 可行性剪枝
            if (curSum == 0){// 如果当前子集和为0，表示无法继续组合，提前结束
                return false;
            }
        }

        return false;
    }
}
