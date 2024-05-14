package com.xiaoruiit.algorithm.dp;

/**
 * 买卖股票的最佳时机
 * @author hanxiaorui
 * @date 2024/5/14
 */
public class LeetCode121 {
    public static void main(String[] args) {
        LeetCode121 leet = new LeetCode121();
        System.out.println(leet.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(leet.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int[] arr = new int[prices.length];
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min){
                arr[i] = prices[i] - min;
                max = Math.max(max, arr[i]);
            } else {
                min = prices[i];
            }
        }

        return max;
    }
}
