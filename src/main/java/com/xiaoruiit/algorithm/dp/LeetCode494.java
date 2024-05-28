package com.xiaoruiit.algorithm.dp;

/**
 * 目标和
 * dp[i][j] 值：方法数；i：哪些数组元素；j:计算结果。  前 i 个数，当前计算结果为 j 的方案数
 * 准备两个背包。背包a放带+的元素，剩下的元素带-，放入背包b。则：sum(a) - sum(b) = target; sum(a) + sum(b) = sum(nums); 化简的 sum(a) = (sum(nums) + target ) / 2
 * tags: ['动态规划','0-1背包']
 * @author hanxiaorui
 * @date 2024/5/16
 */
public class LeetCode494 {
    public static void main(String[] args) {
        LeetCode494 leet = new LeetCode494();
        System.out.println(leet.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int diff = sum - target;
        if (diff < 0 || diff %2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[][] dp = new int[nums.length + 1][neg + 1];// 从0到i任选数，值为j的种类数，可重复
        dp[0][0] = 1;

        for (int i = 1; i < nums.length + 1; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                if (j < num){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                }
            }
        }

        return dp[nums.length][neg];
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        dp[0][sum] = 1;

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = -sum; j < sum + 1; j++) {
                if (j - nums[i - 1] + sum >= 0){
                    dp[i][j + sum] += dp[i - 1][j - nums[i - 1] + sum];
                }
                if (j + nums[i - 1] + sum <= 2 * sum){
                    dp[i][j + sum] += dp[i - 1][j + nums[i - 1] + sum];
                }
            }
        }

        //  -1  0 1 2 3 4
        //   0  1 0 0 0 0    选0个数，结果是0，有1种；  选0个数，结果是1，有0种
        //   1  0 1 0 0 0    0-1个数，结果是0，有0种；  0-1个数，结果是1，有1种
        //   0  2 0 0 0 0    0-2个数，结果是0，有2种（-1 + 1；1 + （- 1））；

        return dp[nums.length][target + sum];
    }
}
