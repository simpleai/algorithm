package com.xiaoruiit.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 棒球比赛
 */
public class LeetCode682 {
    public static void main(String[] args) {

    }

    public int calPoints(String[] operations) {
        if (operations == null || operations.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            if ("+".equals(operations[i])) {
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
            } else if ("D".equals(operations[i])) {
                list.add(list.get(list.size() - 1) * 2);
            } else if ("C".equals(operations[i])) {
                list.remove(list.size() - 1);
            } else {
                list.add(Integer.parseInt(operations[i]));
            }
        }
        if (list.size() == 0) {
            return 0;
        }
        return list.stream().reduce(Integer::sum).get();
    }
}
