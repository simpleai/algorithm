package com.xiaoruiit.algorithm.dp;

/**
 * 摆动序列
 * 返回摆动序列的最大长度
 *
 * @author hanxiaorui
 * @date 2024/4/10
 */
public class LeetCode336 {

    public static void main(String[] args) {
//        System.out.println(wiggleMaxLength(new int[]{1,7,4,9,2,5}));
//        System.out.println(wiggleMaxLength(new int[]{1}));
//        System.out.println(wiggleMaxLength(new int[]{1,1}));
//        System.out.println(wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
//        System.out.println(wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(wiggleMaxLength(new int[]{3,3,3,2,5}));
    }
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length == 1){
            return 1;
        }

        int preDiff = nums[1] - nums[0];
        int length = preDiff == 0 ? 1 : 2;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && preDiff <= 0 ) || (diff < 0 && preDiff >= 0)) {
                length++;
                preDiff = diff;
            }
        }

        return length;
    }

}
