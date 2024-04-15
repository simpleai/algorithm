package com.xiaoruiit.data_structure.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 下一个更大元素
 *
 * 1.反序遍历nums2，用栈来辅助map记录nums2中本元素对应的下一个更大元素；
 */
public class LeetCode496 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{1, 3, 4}, new int[]{1, 4, 3, 2})));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
