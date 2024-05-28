package com.xiaoruiit.algorithm.dp;

/**
 * 买卖股票的最佳时机含冷冻期
 * @author hanxiaorui
 * @date 2024/5/14
 */
public class LeetCode309 {
    public static void main(String[] args) {
        LeetCode309 leet = new LeetCode309();

    }

    public int maxProfit(int[] prices) {
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
