package com.xiaoruiit.algorithm.dp;

/**
 * 爬楼梯
 * tags: ['动态规划','滚动数组']
 * 最后一步可能跨了一级台阶，也可能跨了两级台阶  f(x) = f(x - 1) + f(x - 2)
 * @author hanxiaorui
 * @date 2024/4/23
 */
public class LeetCode70 {

    public static void main(String[] args) {
        LeetCode70 leet = new LeetCode70();
        System.out.println(leet.climbStairs(40));
        System.out.println(leet.climbStairs(1));
        System.out.println(leet.climbStairs(2));
        System.out.println(leet.climbStairs(3));


        System.out.println(leet.climbStairs2(40));
        System.out.println(leet.climbStairs2(1));
        System.out.println(leet.climbStairs2(2));
        System.out.println(leet.climbStairs2(3));
    }

    public int climbStairs(int n) {
        int pre = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = pre + curr;
            pre = curr;
            curr = next;
        }

        return curr;
    }

    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
