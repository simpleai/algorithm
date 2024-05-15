package com.xiaoruiit.algorithm.dp;

/**
 * 五个状态
 * 1. 不操作
 * 2. a态：第一次买，没有卖    值：最大收益
 * 3. b态：第一次卖出         值：最大收益
 * 4. c态：第二次买，没有卖    值：最大收益
 * 5. d态：第二次卖          值：最大收益
 * 买卖股票的最佳时机 III
 * @author hanxiaorui
 * @date 2024/5/14
 */
public class LeetCode123 {
    public static void main(String[] args) {
        LeetCode123 leet = new LeetCode123();
        System.out.println(leet.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(leet.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(leet.maxProfit(new int[]{7,6,4,3,1}));

    }

    public int maxProfit(int[] prices) {
        int a = -prices[0], b = 0, c = -prices[0], d = 0;

        // 同一天买入并卖出对答案无影响
        for (int i = 1; i < prices.length; i++) {
            a = Math.max(-prices[i], a);
            b = Math.max(b, prices[i] + a);
            c = Math.max(c, b - prices[i]);
            d = Math.max(d, prices[i] + c);
        }
        return d;
    }
}
