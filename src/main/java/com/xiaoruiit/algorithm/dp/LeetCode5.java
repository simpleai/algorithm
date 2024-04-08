package com.xiaoruiit.algorithm.dp;

/**
 * 最长回文子串
 * 依次设置长度为 len++长度字符是否回文串。长度为 i,j 是回文串，还需要 i+1,j-1是回文串； boolean[i][j] = (s[i] == s[j] && boolean[i+1][j-1])
 * 每次判断是回文串时，重置最大值和最大回文串起始位置
 * @author hanxiaorui
 * @date 2024/4/8
 */
public class LeetCode5 {

    public static void main(String[] args) {
        String s = "babad";// bab
        String s2 = "cbbd";// bb
        String s3 = "bcbaabc";
//        System.out.println(longestPalindrome(s));
//        System.out.println(longestPalindrome(s2));
        System.out.println(longestPalindrome(s3));
    }
    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {// 单个字符是回文串
            dp[i][i] = true;
        }

        int max = 1;
        int start = 0;

        for (int l = 2; l < s.length() + 1; l++) {// 字符串长度，从2开始判断是否是否回文串
            for (int i = 0; i < s.length(); i++) {
                int j = l + i - 1;

                if (j >= s.length()){
                    break;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 == j){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp [i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j] == true && j - i + 1 > max){
                    max = j - i + 1;
                    start = i;
                }
            }

        }

        return s.substring(start, start + max);

    }
}
