package com.xiaoruiit.data_structure.array;

import java.util.Arrays;

/**
 * 移动机器人
 * 1.根据指令移动（修改数组），不用管相撞
 * 3.移动结束，计算距离。先排序；每一段距离：(a[i] - a[i-1]) * i * (length - i)
 *
 * @author hanxiaorui
 * @date 2024/4/8
 */
public class LeetCode2731 {
    public static void main(String[] args) {
        System.out.println(sumDistance(new int[]{-2, 0, 2}, "RLL", 3));
        System.out.println(sumDistance(new int[]{1,0}, "RL", 2));
    }

    public static int sumDistance(int[] nums, String s, int d) {
        int mod = 1000000007;
        long[] copy = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (s.charAt(i) == 'L'){
                copy[i] = (long)nums[i] - d;
            } else {
                copy[i] = (long)nums[i] + d;
            }
        }

        long res = 0;
        Arrays.sort(copy);
        for (int i = 1; i < copy.length; i++) {
            res += (copy[i] - copy[i - 1]) * i % mod * (copy.length - i) % mod;
            res %= mod;
        }

        return (int)res;
    }
}
