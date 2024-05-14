package com.xiaoruiit.algorithm.dp;

/**
 * dp[i][0] 第i天没有持有股票
 * dp[i][1] 第i天持有股票
 * 买卖股票的最佳时机 II
 * @author hanxiaorui
 * @date 2024/5/14
 */
public class LeetCode122 {
    public static void main(String[] args) {
        LeetCode122 leet = new LeetCode122();
        System.out.println(leet.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(leet.maxProfit(new int[]{7,6,4,3,1}));

        System.out.println(leet.maxProfit2(new int[]{7,1,5,3,6,4}));
        System.out.println(leet.maxProfit2(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = - prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); // 今天不持有股票的收益 = max(前一天不持有股票,前一天持有股票且今天卖出）
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); // 今天持有股票的收益 = max(前一天持有股票,前一天不持有股票且今天买入）
        }

        return dp[prices.length - 1][0];// 最后一天不持有股票收益更大
    }

    /**
     * 贪心
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]){
                max += prices[i] - prices[i - 1];
            }
        }

        return max;
    }
}
