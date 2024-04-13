package com.xiaoruiit.data_structure.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 括号生成
 */
public class LeetCode22 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(8));
    }

    /**
     * 增加括号放在每个括号外边；括号++，重复放
     */
    public static List<String> generateParenthesis(int n) {
        if (n < 1){
            return new ArrayList<>();
        }

        Set<String> set = new HashSet<>();
        set.add("()");
        for (int i = 1; i < n; i++) {
            Set<String> setNew = new HashSet<>();
            for (String s : set) {
                for (int j = 0; j < s.length() / 2 + 1; j++) {
                    String s1 = s.substring(0, j) + "()" + s.substring(j, s.length());
                    setNew.add(s1);
                }
            }

            set = setNew;
        }

        return new ArrayList<>(set);
    }


}
