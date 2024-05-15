package com.xiaoruiit.algorithm.dp;

/**
 * 3个状态
 * 1. a态：今天持有一只股票                         值：最大收益
 * 2. b态：今天不持有股票                          值：最大收益
 * 买卖股票的最佳时机含冷冻期
 * @author hanxiaorui
 * @date 2024/5/14
 */
public class LeetCode109 {
    public static void main(String[] args) {
        LeetCode109 leet = new LeetCode109();
        System.out.println(leet.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(leet.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(leet.maxProfit(new int[]{7,6,4,3,1}));

        System.out.println(leet.maxProfit2(new int[]{7,1,5,3,6,4}));
        System.out.println(leet.maxProfit2(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(leet.maxProfit2(new int[]{7,6,4,3,1}));
        System.out.println(leet.maxProfit2(new int[]{1,2}));

    }

    public int maxProfit(int[] prices) {
        if (prices.length == 1){
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[1][0] = Math.max(-prices[0], -prices[1]);
        dp[1][1] = dp[1][0] + prices[1];

        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);// 昨天持有；或前天卖出，今天购买
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);// 昨天不持有；或昨天持有，今天卖出
        }
        return dp[prices.length - 1][1];
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 1){
            return 0;
        }

        int beforeTwoSell = 0;
        int beforeBuy = Math.max(-prices[0], -prices[1]);
        int beforeSell = beforeBuy + prices[1];
        int buy = 0, sell = 0;

        for (int i = 2; i < prices.length; i++) {
            buy = Math.max(beforeBuy, beforeTwoSell - prices[i]);// 昨天持有；或前天卖出，今天购买
            sell = Math.max(beforeSell, beforeBuy + prices[i]);// 昨天不持有；或昨天持有，今天卖出
            beforeTwoSell = beforeSell;
            beforeBuy = buy;
            beforeSell = sell;
        }
        return beforeSell;
    }
}
