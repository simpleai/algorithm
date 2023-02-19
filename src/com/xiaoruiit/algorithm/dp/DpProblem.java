package com.xiaoruiit.algorithm.dp;

/**
 * dynamic planning 动态规划 TODO
 */
public class DpProblem {

    /**
     * 图
     */

    /**
     * 最大公共子串
     */


    /**
     * leetCode 91.解码方法 TODO
     */
    public static int leetCode91(String s) {
        if (s == null || s.length() == 0)
            return 0;

        if (s.length() == 1){
            if (s.equals("0"))
                return  0;
            return 1;
        }
        // 校验
        char[] chars = s.toCharArray();

        return getCount(chars, chars.length - 2);

    }

    public static int getCount(char[] chars, int index) {
        if (index == 0){
            if (chars[index] == '0'){
                return 0;
            } else {
                return 2;
            }
        }

        //System.out.println(index);

        if (chars[index] != '0' && (chars[index - 1] == '1' || (chars[index - 1] == '2' && chars[index] < '7'))){
            return getCount(chars, index - 1) + 1;
        } else if(chars[index + 1] == '0') {
            return getCount(chars, index - 1) - 1;
        } else {
            return getCount(chars, index - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(leetCode91("10"));
    }
}
