package com.xiaoruiit.data_structure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * tags: ['双指针']
 * 需考虑int溢出
 * @author hanxiaorui
 * @date 2024/4/12
 */
public class LeetCode18 {

    public static void main(String[] args) {
//        System.out.println(fourSum(new int[]{2,2,2,2,2}, 8));
//        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(fourSum(new int[]{0,0,0,-1000000000,-1000000000,-1000000000,-1000000000}, -1000000000));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if ((long)nums[i] + nums[i + 1] + nums[i + 2] + nums [i + 3] > target){// 剪枝
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]){// 去重
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]){// 去重
                    continue;
                }
                if ((long)nums[i] + nums[j] + nums[j +1] + nums[j +2] > target){// 剪枝
                    break;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right){
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]){// 去重
                            left++;
                        }
                        left++;
                        while (right > left && nums[right] == nums[right - 1]){// 去重
                            right--;
                        }
                        right--;
                    } else if (sum > target){
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return res;
    }
}
