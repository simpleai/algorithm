package com.xiaoruiit.data_structure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hanxiaorui
 * @date 2024/4/22
 */
public class LeetCode47 {
    public static void main(String[] args) {
        LeetCode47 leet = new LeetCode47();
        System.out.println(leet.permuteUnique(new int[]{1,1,2}));
    }
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] booleans = new boolean[nums.length];
        Arrays.sort(nums);
        addList(nums, new ArrayList<>(), booleans);

        return result;
    }

    private void addList(int[] nums, List<Integer> temp,boolean[] used) {
        if (temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums [i - 1] && !used[i - 1])) {
                continue;
            }

            temp.add(nums[i]);
            used[i] = true;

            addList(nums, temp,used);

            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

}
