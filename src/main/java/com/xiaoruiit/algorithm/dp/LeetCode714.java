package com.xiaoruiit.algorithm.dp;

/**
 * 五个状态
 * 2. a态：持有股票    值：最大收益
 * 3. b态：不持有股票   值：最大收益
 * 买卖股票的最佳时机含手续费
 * @author hanxiaorui
 * @date 2024/5/14
 */
public class LeetCode714 {
    public static void main(String[] args) {
        LeetCode714 leet = new LeetCode714();
//        System.out.println(leet.maxProfit(new int[]{7,1,5,3,6,4}, 2));
//        System.out.println(leet.maxProfit(new int[]{3,3,5,0,0,3,1,4}, 2));
//        System.out.println(leet.maxProfit(new int[]{7,6,4,3,1}, 2));
        System.out.println(leet.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));

    }

    public int maxProfit(int[] prices, int fee) {
        int beforeBuy = -prices[0];
        int beforeSell = 0;

        int buy = 0, sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(beforeBuy, beforeSell - prices[i]);
            sell = Math.max(beforeSell, beforeBuy + prices[i] - fee);

            beforeBuy = buy;
            beforeSell = sell;
        }
        return beforeSell;
    }
}
