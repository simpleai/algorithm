package com.xiaoruiit.data_structure.hash_table;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanxiaorui
 * @date 2024/4/12
 */
public class LeetCode1002 {

    public static void main(String[] args) {
//        System.out.println(commonChars(new String[]{"aa","ba"}));
        System.out.println(commonChars(new String[]{"bella","label","roller"}));
    }
    public static List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();

        int[] min = new int[26];
        for (int i = 0; i < min.length; i++) {
            min[i] = Integer.MAX_VALUE;
        }

        for (String word : words) {
            int[] arr = new int[26];
            for (int i = 0; i < word.length(); i++) {
                arr[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < min.length; i++) {
                min[i] = Math.min(min[i], arr[i]);
            }
        }

        for (int i = 0; i < min.length; i++) {
            for (int j = 0; j < min[i]; j++) {
                res.add(String.valueOf((char)(i + 'a')));
            }
        }

        return res;
    }
}
