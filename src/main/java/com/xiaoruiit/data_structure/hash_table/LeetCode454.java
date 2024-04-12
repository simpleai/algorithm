package com.xiaoruiit.data_structure.hash_table;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hanxiaorui
 * @date 2024/4/12
 */
public class LeetCode454 {

    public static void main(String[] args) {
        System.out.println(fourSumCount2(new int[]{2,2,2}, new int[]{2,2,2}, new int[]{-2,-2,-2}, new int[]{-2,-2,-2}));
    }
    public static int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> countAB = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                countAB.put(nums1[i] + nums2[j], countAB.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if (countAB.containsKey(-nums3[i] - nums4[j])){
                    res += countAB.get(-nums3[i] - nums4[j]);// 排列组合
                }
            }
        }

        return res;
    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                for (int k = 0; k < nums3.length; k++) {
                    for (int l = 0; l < nums4.length; l++) {
                        if (nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0){
                            res++;
                        }
                    }
                }
            }
        }

        return res;
    }
}
