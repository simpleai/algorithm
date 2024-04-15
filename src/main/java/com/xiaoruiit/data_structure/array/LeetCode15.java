package com.xiaoruiit.data_structure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 三数之和
 * tags: ['双指针']
 * @author hanxiaorui
 * @date 2024/4/12
 */
public class LeetCode15 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]){// 去重
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]){// 去重
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]){// 去重
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0){
                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }

}
