package com.xiaoruiit.data_structure.string;

/**
 * 字符串
 */
public class StringMain {
    public static void main(String[] args) {
        /*
        // 主串是否包含模式串
        String major = "abcefdefgh";
        String pattern = "efg";
        System.out.println(StringProblem.judgeContainPattern(major,pattern));
        */

        // 两个串的最大子串
        String a = "abcefdefgh";
        String b = "aefgab";
        System.out.println(StringProblem.maxPattern(a,b));
    }


}
