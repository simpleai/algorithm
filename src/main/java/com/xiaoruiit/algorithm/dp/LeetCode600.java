package com.xiaoruiit.algorithm.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * fn = fn
 */
public class LeetCode600 {

    public static void main(String[] args) {
        LeetCode600 leet = new LeetCode600();

        System.out.println(leet.findIntegers(5));
        System.out.println(leet.findIntegers(1));
        System.out.println(leet.findIntegers(2));
        System.out.println(leet.findIntegers(6));
    }
    public int findIntegers(int n) {
        int[] cache = new int[30];
        cache[0] = 3;
        for (int i = 1; i < 30; i++) {
            cache[i] = (cache[i - 1] + 1) * 2 - 1;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < cache.length; i++) {
            set.add(cache[i]);
        }

        int result = 0;
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)){
                result++;
            }
        }

        return result;
    }
}
