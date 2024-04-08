package com.xiaoruiit.algorithm.search;

/**
 * @author hanxiaorui
 * @date 2024/4/8
 */
public class LeetCode69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(17));
        System.out.println(mySqrt(15));
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        int low = 0;
        int high = x;
        int res = -1;
        while (low <= high){
            int middle = low + ((high - low) >> 1);
            if ((long)middle * middle <= x){
                res = middle;
                low =  middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return res;
    }
}
