package com.xiaoruiit.algorithm.recursion;

import com.xiaoruiit.data_structure.tree.TreeNode;
import com.xiaoruiit.util.MyException;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归算法题
 */
public class RecursionProblem {

    /**
     * 汉诺塔，三根柱子x,y,z，n个从小到大的盘在x柱子上，小的不能往大的上边放
     * 问题：把n从小到大的盘子从x移到z
     * 分析：一次移一个盘子，
     * 把汉诺塔(x)的第1到第n-1个盘子需要移到空塔(y)，
     * 第n个盘子（最大的盘子）需要从(x)移到目标塔(z)，
     * 把汉诺塔(y)的第1到第n-2个盘子需要移到目标塔(z)
     */
    public static void hanoi(int n) {
        if (n < 1) {
            throw new MyException("汉诺塔层数不能小于1");
        }
        String x = "x";// 汉诺塔
        String y = "y";// 空塔
        String z = "z";// 目标塔
        hanoiRecursion(n, x, y, z);

    }

    private static void hanoiRecursion(int n, String x, String y, String z) {
        if (n == 1) {
            System.out.println(x + " → " + z);
            return;
        }
        hanoiRecursion(n - 1, x, z, y);
        System.out.println(x + " → " + z);
        hanoiRecursion(n - 1, y, x, z);
    }

    /**
     * 斐波那契数列是：0，1，1，2，3，5，8……。数列中元素的性质是，某个数等于它前面两个数的和；起始两个元素，分别为 0 和 1。
     * 问题：写一个函数，输入 x，输出斐波那契数列中第 x 位的元素。
     * 例如，输入 4，输出 2；
     * 分析：递归体：a[x] = a[x-1]+a[x-2]，结束条件x==2;
     *
     * @param x 第x位
     * @return 第x位的元素
     */
    public static long fibonacciSequence(int x) {
        if (x < 1) {
            throw new MyException("输入值：" + x + "应该>1");
        } else if (x == 1) {
            return 0;
        }
        // 递归方法
        return fibonacciRecursion(0l, 1l, x);
    }

    public static Map<Integer, Long> map = new HashMap();
    public static long fibonacciSequence2(int x) {
        if (x == 1) {
            return 0;
        } else if (x == 2) {
            return 1;
        }

        if (map.containsKey(x)){
            return map.get(x);
        }

        long n = fibonacciSequence2(x - 1) + fibonacciSequence2(x - 2);

        map.put(x, n);

        return n;
    }

    /**
     * 斐波那契数列递归
     *
     * @param m
     * @param n
     * @param x
     * @return
     */
    private static long fibonacciRecursion(long m, long n, int x) {
        // 结束条件
        if (x == 2) {
            return n;
        }
        // 递归体
        long t = m;
        m = n;
        n += t;
        x--;
        return fibonacciRecursion(m, n, x);
    }

    /**
     * leetCode 91.解码方法 TODO
     */
    public static int leetCode91(String str) {
        int result = 0;
        // 校验
        char[] chars = str.toCharArray();

        return result;
    }

}
