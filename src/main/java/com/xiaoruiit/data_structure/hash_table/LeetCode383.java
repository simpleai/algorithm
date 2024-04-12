package com.xiaoruiit.data_structure.hash_table;

/**
 * @author hanxiaorui
 * @date 2024/4/12
 */
public class LeetCode383 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            arr[ransomNote.charAt(i) - 'a']--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0){
                return false;
            }
        }

        return true;
    }
}
