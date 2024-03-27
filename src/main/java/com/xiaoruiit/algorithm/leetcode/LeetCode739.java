package com.xiaoruiit.algorithm.leetcode;

import java.util.*;

public class LeetCode739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{1, 1, 1})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{1, 2, 1})));
    }

    /**
     * LeetCode739 每日温度
     * 用栈来存储没有大于当日温度的下标。下标相减即更高温度出现在几天之后
     * tags: ['栈','数组']
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return temperatures;
        }

        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()) {
                Integer peek = stack.peek();
                if (temperatures[i] > temperatures[peek]) {
                    result[peek] = i - peek;
                    stack.pop();
                } else {
                    break;
                }
            }

            stack.push(i);
        }

//        while (!stack.isEmpty()) {// 不会升高，无需处理，数组初始化值就是0
//            Integer pop = stack.pop();
//            result[pop] = 0;
//        }

        return result;
    }
}
