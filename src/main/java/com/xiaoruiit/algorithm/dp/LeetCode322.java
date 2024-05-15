package com.xiaoruiit.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 零钱兑换
 * @author hanxiaorui
 * @date 2024/5/15
 */
public class LeetCode322 {
    public static void main(String[] args) {
        LeetCode322 leet = new LeetCode322();
        System.out.println(leet.coinChange(new int[]{1,2,5}, 11));
    }

    int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        List<Integer> list = new ArrayList<>();

        backtrack(coins, amount, list);
        if (min != Integer.MAX_VALUE){
            return min;
        }
        return -1;
    }

    public void backtrack(int[] coins, int amount, List<Integer> list){
        if (amount == 0){
            min = Math.min(min, list.size());
            return;
        } else if (amount < 0){
            return ;
        }

        for (int i = coins.length - 1; i > 0; i--) {
            list.add(coins[i]);
            amount -= coins[i];

            backtrack(coins, amount, list);

            amount += coins[i];
            list.remove(list.size() - 1);
        }
    }
}
