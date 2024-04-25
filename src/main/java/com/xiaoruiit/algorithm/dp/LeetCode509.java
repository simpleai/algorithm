package com.xiaoruiit.algorithm.dp;

/**
 * 斐波那契数
 */
public class LeetCode509 {
    public static void main(String[] args) {
        LeetCode509 leet = new LeetCode509();
        System.out.println(leet.fib(0));
        System.out.println(leet.fib(1));
        System.out.println(leet.fib(4));
    }

    public int fib(int n) {
        if (n == 0){
            return 0;
        }

        int pre = 0, cur = 1, next = 1;

        for (int i = 1; i < n; i++) {
            next = pre + cur;
            pre = cur;
            cur = next;
        }

        return next;
    }
}
