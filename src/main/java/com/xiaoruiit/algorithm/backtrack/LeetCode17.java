package com.xiaoruiit.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanxiaorui
 * @date 2024/4/18
 */
public class LeetCode17 {
    public static void main(String[] args) {
        LeetCode17 leet = new LeetCode17();
        System.out.println(leet.letterCombinations("23"));
    }

    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return res;
        }
        recursion(digits, 0, new StringBuilder());

        return res;
    }

    public void recursion(String digits, int start, StringBuilder builder){
        if (start == digits.length()){
            res.add(builder.toString());
            return;
        }

        String str = getStr(digits.charAt(start));
        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i));
            start++;
            recursion(digits, start, builder);
            start--;
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public String getStr(char ch){
        if (ch == '2'){
            return "abc";
        }
        if (ch == '3'){
            return "def";
        }
        if (ch == '4'){
            return "ghi";
        }
        if (ch == '5'){
            return "jkl";
        }
        if (ch == '6'){
            return "mno";
        }
        if (ch == '7'){
            return "pqrs";
        }
        if (ch == '8'){
            return "tuv";
        }
        if (ch == '9'){
            return "wxyz";
        }

        return null;
    }

}
