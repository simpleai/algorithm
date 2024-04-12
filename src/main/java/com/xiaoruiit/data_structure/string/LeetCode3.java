package com.xiaoruiit.data_structure.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hanxiaorui
 * @date 2024/4/12
 */
public class LeetCode3 {

    public static void main(String[] args) {
        // leetCode 3.无重复字符的最长子串
        System.out.println(leetCode3("abcdaefbcdg"));
    }
    /**
     * LeetCode 3.给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
     *
     * abcdaefbcdg
     *
     * 分析：
     *  快慢指针，已经存在，从慢指针开始删除。
     *  map查找是否已经存在。
     *
     *  遍历，
     *      如果map中存在，从慢指针处开始删除，直到不重复。
     *      将每个字母加入到map中。
     *      维护map的最大值，遍历完成后，返回最大值。
     */
    public static int leetCode3(String str){
        if (str.length() == 0){
            return 0;
        }
        char[] chars = str.toCharArray();
        Map map = new HashMap();// 存已经遍历过的字符串，重复时根据slow慢指针删除
        map.put(chars[0],0);
        int max = map.size();// 记录遍历过程中map长度的最大值
        for (int slow = 0,fast = 1; fast < chars.length; fast++) {
            if (map.containsKey(chars[fast])){
                while(chars[slow] != chars[fast]){
                    map.remove(chars[slow]);
                    slow++;
                }
                map.remove(chars[slow]);
                slow++;
            }
            map.put(chars[fast],fast);
            max = max > map.size() ? max : map.size();
        }
        return max;
    }
}
