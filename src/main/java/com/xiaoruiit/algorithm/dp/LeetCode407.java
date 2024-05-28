package com.xiaoruiit.algorithm.dp;

/**
 * 接雨水 II
 * 接水后的高度：water[i][j] = max(heightMap[i][j],min(water[i - 1][j],water[i + 1][j],water[i][j - 1], water[i][j + 1])
 * 接到的水：water[i][j] - heightMap[i][j]
 * 边界：最外层的方块 water[i][j] = heightMap[i][j]
 * tags: ['优先队列']
 */
public class LeetCode407 {
    public static void main(String[] args) {
        LeetCode407 leet = new LeetCode407();
        System.out.println(leet.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(leet.trap(new int[]{4,2,0,3,2,5}));

        System.out.println(leet.trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(leet.trap2(new int[]{4,2,0,3,2,5}));

//        System.out.println(leet.trap3(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(leet.trap3(new int[]{4,2,0,3,2,5}));
    }

    /**
     * 一列一列计算，找到本列左侧最高和右侧最高，本列可接的雨水 = min(left, right) - height[i]. 一共接的雨水 = sum(i)
     * 暴力双指针
     * tags: ['双指针']
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length <= 2){
            return 0;
        }

        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {// 头和尾不可能接雨水
            // 找到左侧比自己最高的
            int left = height[i];
            for (int j = i - 1; j >= 0; j--) {
                left = Math.max(left, height[j]);
            }
            if (left == height[i]){
                continue;
            }

            // 找到右侧比自己最高的
            int right = height[i];
            for (int j = i + 1; j < height.length; j++) {
                right = Math.max(right, height[j]);
            }
            if (right == height[i]){
                continue;
            }

            sum += Math.min(right, left) - height[i];
        }

        return sum;
    }

    /**
     * 双指针优化
     * tags: ['双指针','动态规划']
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if (height.length <= 2){
            return 0;
        }

        int sum = 0;

        int[] leftMax = new int[height.length];// 每一位数左侧的最大值  左最大状态
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[height.length]; // 每一位数右侧的最大值 右最大状态
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 1; i < height.length - 1; i++) {// 头和尾不可能接雨水
            if (height[i] >= leftMax[i]){
                continue;
            }

            if (height[i] >= rightMax[i]){
                continue;
            }

            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return sum;
    }

    /**
     * 双指针优化，再优化空间复杂度
     * tags: ['双指针']
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        if (height.length <= 2){
            return 0;
        }

        int sum = 0;
        int leftMax = height[0], rightMax = height[height.length - 1];

        int left = 0, right = height.length - 1;
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if (leftMax < rightMax){// 左边是最大中的低值，可以接左边柱子的水。可能接到的水是0
                sum += leftMax - height[left];
                left ++;
            } else {// 右边是最大中的低值，可以接右边柱子的水
                sum += rightMax - height[right];
                right--;
            }
        }

        return sum;
    }
}
