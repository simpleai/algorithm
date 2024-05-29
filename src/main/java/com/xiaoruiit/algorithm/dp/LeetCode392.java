package com.xiaoruiit.algorithm.dp;

/**
 * tags: ['子序列','动态规划']
 */
public class LeetCode392 {
    public static void main(String[] args) {
        LeetCode392 leet = new LeetCode392();
        System.out.println(leet.isSubsequence("abc", "ahbgdc"));
        System.out.println(leet.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        if(i == s.length()){
            return true;
        }
        return false;
    }
}
