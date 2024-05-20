package com.xiaoruiit.algorithm.dp;

import java.util.Arrays;

/**
 * f(n) = min(f(n - i)) + 1
 */
public class LeetCode279 {
    public static void main(String[] args) {
        LeetCode279 leet = new LeetCode279();
//        System.out.println(leet.numSquares(12));
        System.out.println(leet.numSquares(13));
    }

    public int numSquares(int n) {
        int[] cache = new int[100];
        for (int i = 0; i < 100; i++) {
            cache[i] = (i + 1) * (i + 1);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 10000);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < cache.length; j++) {
                if(i - cache[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i - cache[j]] + 1);
                } else {
                    continue;
                }
            }
        }

        return dp[n];
    }
}
