package com.xiaoruiit.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 有 A 和 B 两种类型 的汤。一开始每种类型的汤有 n 毫升。有四种分配操作：
 * <p>
 * 提供 100ml 的 汤A 和 0ml 的 汤B 。
 * 提供 75ml 的 汤A 和 25ml 的 汤B 。
 * 提供 50ml 的 汤A 和 50ml 的 汤B 。
 * 提供 25ml 的 汤A 和 75ml 的 汤B 。
 * 需要返回的值： 汤A 先分配完的概率 +  汤A和汤B 同时分配完的概率 / 2。
 * 中等
 * tags: ['动态规划',]
 *
 * @author hanxiaorui
 * @date 2024/4/2
 */
public class LeetCode808 {

    public static void main(String[] args) {
        System.out.println(soupServings(850));
        System.out.println(soupServings2(850));
    }

    static Map<String, Double> map = new HashMap<>();

    public static double soupServings(int n) {
        n = (int) Math.ceil(n / 25);
        if (n > 178) {
            return 1.0d;
        }

        return one(n, n);
    }

    public static double one(int a, int b) {
        if (map.containsKey(a + "-" + b)){
            return map.get(a + "-" + b);
        }

        if (a <= 0 && b > 0) {
            return 1;
        } else if (a <= 0 && b <= 0) {
            return 0.5d;
        } else if (a > 0 && b <= 0) {
            return 0;
        }

        double probability = one(a - 4, b);
        double probability2 = one(a - 3, b - 1);
        double probability3 = one(a - 2, b - 2);
        double probability4 = one(a - 1, b - 3);

        map.put(a + "-" + b, (probability + probability2 + probability3 + probability4) / 4);

        return (probability + probability2 + probability3 + probability4) / 4;
    }

    public static double soupServings2(int n) {
        if (n > 4450) {
            return 1;
        }

        n = (int) Math.ceil(n / 25d);
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = 0.25 * (dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i - 3)][Math.max(0, j - 1)] + dp[Math.max(0, i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)]);
            }
        }

        return dp[n][n];
    }

}
