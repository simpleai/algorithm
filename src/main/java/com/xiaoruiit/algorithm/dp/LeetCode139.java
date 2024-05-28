package com.xiaoruiit.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * tags: ['完全背包','动态规划']
 */
public class LeetCode139 {
    public static void main(String[] args) {
        LeetCode139 leet = new LeetCode139();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(leet.wordBreak("leetcode", list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> collect = wordDict.stream().collect(Collectors.toSet());

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && collect.contains(s.substring(j, i))) {// 0到j、j到i都可以拼接，则 0到i可以拼接
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
