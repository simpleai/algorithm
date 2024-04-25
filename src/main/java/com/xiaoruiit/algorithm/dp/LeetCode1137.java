package com.xiaoruiit.algorithm.dp;

public class LeetCode1137 {
    public static void main(String[] args) {
        LeetCode1137 leet = new LeetCode1137();
        System.out.println(leet.tribonacci(0));
        System.out.println(leet.tribonacci(1));
        System.out.println(leet.tribonacci(2));
        System.out.println(leet.tribonacci(3));
    }

    public int tribonacci(int n) {
        if (n == 0){
            return 0;
        } else if (n == 1){
            return 1;
        } else if(n == 2){
            return 1;
        }

        int a = 0, a1 = 1, a2 = 1,a3 = 0;

        for (int i = 2; i < n; i++) {
            a3 = a + a1 + a2;
            a = a1;
            a1 = a2;
            a2 = a3;
        }

        return a3;
    }
}
