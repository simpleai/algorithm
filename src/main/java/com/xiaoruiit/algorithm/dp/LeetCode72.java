package com.xiaoruiit.algorithm.dp;

/**
 * 编辑距离
 * 最少操作。 增加、删除、替换 相当于 删除、替换
 * 不相等的时候，看删除A、删除B、做替换哪个操作最少
 * tags: ['子序列','动态规划']
 */
public class LeetCode72 {

    public static void main(String[] args) {
        LeetCode72 leet = new LeetCode72();
        System.out.println(leet.minDistance("horse", "ros"));
        System.out.println(leet.minDistance("intention","execution"));
    }
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0){
            return word2.length();
        } else if (word2.length() == 0){
            return word1.length();
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < word1.length() + 1; i++) {// 一个为空，距离 = 另一个长度
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {// 一个为空，距离 = 另一个长度
            dp[0][j] = j;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt((j - 1))){
                    dp[i][j] =  dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;// 删除 word1 当前元素、删除 word2 当前元素、或替换当前元素
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
