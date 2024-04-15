package com.xiaoruiit.data_structure.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 每日温度
 * 中等
 * 思路：前进，后退，从后退处前进
 */
public class LeetCode739 {

    public static void main(String[] args) {
        int[] tem739 = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(everydayTemperatures(tem739)));

        System.out.println("leetCode739two:" + Arrays.toString(everydayTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));

    }
    /**

     *
     * @param temperatures
     * @return
     */
    public static int[] everydayTemperatures2(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return temperatures;
        }

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int pop = stack.pop();
                result[pop] = i - pop;
            }
            stack.push(i);
        }

        return result;
    }

    /**
     * LeetCode739.每日温度
     * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     * <p>
     * 输入: temperatures = [30,40,50,60]
     * 输出: [1,1,1,0]
     */
    public static int[] everydayTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                result[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
