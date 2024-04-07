package com.xiaoruiit.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原 IP 地址
 * 1. 关键：小数点的位置
 * 2. 分别按照1位、2位、3为做切割，不能以0开头，三位需要 < 255;
 *
 */
public class LeetCode93 {

    public static void main(String[] args) {
        LeetCode93 leetCode = new LeetCode93();

//        System.out.println(leetCode.restoreIpAddresses("25525511135"));
        System.out.println(leetCode.restoreIpAddresses("0000"));
        System.out.println(leetCode.restoreIpAddresses("101023"));
        System.out.println(leetCode.restoreIpAddresses("1231231231234"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < s.length() - 2 && i < 4; i++) {
            if(judgement(s, 0, i)) {
                continue;
            }
            for (int j = i + 1; j < s.length() - 1; j++) {
                if(judgement(s, i, j)) {
                    continue;
                }
                for (int k = j + 1; k < s.length() ; k++) {
                    if(judgement(s, j, k)) {
                        continue;
                    }
                    if(judgement(s, k, s.length())) {
                        continue;
                    }

                    String ip = s.substring(0, i) + "." + s.substring(i, j) + "." + s.substring(j, k) + "." + s.substring(k, s.length());
                    list.add(ip);
                }
            }
        }

        return list;
    }

    private boolean judgement(String s, int start, int end) {
        if (end - start > 3){
            return true;
        }
        if (end - start > 2 && Integer.valueOf(s.substring(start, end)) > 255) {
            return true;
        }
        if (end - start  > 1 && s.charAt(start) == '0') {
            return true;
        }

        return false;
    }
}
