package com.xiaoruiit.algorithm.dp;

/**
 * 2k + 1个状态
 * 1. 不操作  无需处理
 * 2. a态：第一次买，没有卖    值：最大收益
 * 3. b态：第一次卖出         值：最大收益
 * 4. c态：第二次买，没有卖    值：最大收益
 * 5. d态：第二次卖          值：最大收益
 * 买卖股票的最佳时机 IV
 * @author hanxiaorui
 * @date 2024/5/14
 */
public class LeetCode188 {
    public static void main(String[] args) {
        LeetCode188 leet = new LeetCode188();
        System.out.println(leet.maxProfit(2, new int[]{7,1,5,3,6,4}));
        System.out.println(leet.maxProfit(2, new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(leet.maxProfit(2, new int[]{7,6,4,3,1}));

    }

    public int maxProfit(int k,int[] prices) {
        int[] arr = new int[2 * k];
        for (int i = 0; i < 2 * k; i++) {
            if (i % 2 == 0){
                arr[i] = -prices[0];
            }
        }

        // 同一天买入并卖出对答案无影响
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j == 0){
                    arr[j] = Math.max(-prices[i], arr[j]);
                } else if (j % 2 == 0){
                    arr[j] = Math.max(arr[j], arr[j - 1] - prices[i]);
                } else if (j % 2 == 1){
                    arr[j] = Math.max(arr[j], prices[i] + arr[j - 1]);
                }
            }
        }
        return arr[ 2 * k - 1];
    }
}
