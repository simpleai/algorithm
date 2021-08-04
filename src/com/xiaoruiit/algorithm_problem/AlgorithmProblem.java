package com.xiaoruiit.algorithm_problem;

/**
 * 算法题 TODO
 */
public class AlgorithmProblem {

    /**
     * 1.一个经过任意位数的旋转后的排序数组，判断某个数是否在里面。
     * <p>
     * 例如，对于一个给定数组 {4, 5, 6, 7, 0, 1, 2}，它是将一个有序数组的前三位旋转地放在了数组末尾。
     * 假设输入的 target 等于 0，则输出答案是 4，即 0 所在的位置下标是 4。如果输入 3，则返回 -1。
     */
    public static int algo1(int[] arr, int target) {

        return -1;
    }

    /**
     * 2.在一个流式数据中，查找中位数。如果是偶数个，则返回偏左边的那个元素。
     * <p>
     * 例如：
     * 输入 1，服务端收到 1，返回 1。
     * 输入 2，服务端收到 1、2，返回 1。
     * 输入 0，服务端收到 0、1、2，返回 1。
     * 输入 20，服务端收到 0、1、2、20，返回 1。
     * 输入 10，服务端收到 0、1、2、10、20，返回 2。
     * 输入 22，服务端收到 0、1、2、10、20、22，返回 2。
     */

    public static int algo2(int num) {

        return -1;
    }

    /**
     * 3.给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后的数组和新的长度，你不需要考虑数组中超出新长度后面的元素。要求：空间复杂度为 O(1)，即不要使用额外的数组空间。
     * <p>
     * 例如，给定数组 nums = [1,1,2]，函数应该返回新的长度 2，并且原数组 nums 的前两个元素被修改为 1, 2。
     */
    public static int algo3(int[] nums) {
        int index = 0;// 新数组下标
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }

    /**
     * 4.查找两个有序数组合并后的中位数
     * 两个有序数组查找合并之后的中位数。给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出这两个正序数组合在一起之后的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空，所有的数字全都不相等。还可以再假设，如果数字个数为偶数个，中位数就是中间偏左的那个元素。
     * <p>
     * 例如：nums1 = [1, 3, 5, 7, 9]
     * nums2 = [2, 4, 8, 12]
     * 输出 5。
     */
    public static int algo4(int num) {

        return -1;
    }

    /**
     * leetCode 10.正则表达式匹配
     * <p>
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * <p>
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * <p>
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * <p>
     * 输入：s = "aa" p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     * <p>
     * 输入：s = "aab" p = "c*a*b"
     * 输出：true
     * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     * <p>
     * 0 <= s.length <= 20
     * 0 <= p.length <= 30
     *
     * 输入：
     * "aaa"
     * "ab*a*c*a"
     * 输出：true
     */
    public static boolean leetCode10(String s, String p) {
        // 校验
        if (s == null || p == null) {
            return false;
        }

        // 变量
        char[] chars = s.toCharArray();
        char[] charp = p.toCharArray();
        int i = s.length() - 1, j = p.length() - 1;

        // 逻辑
        while (i >= 0 && j >= 0) {
            if (charp[j] == '.') {
                j--;
                i--;
            } else if (charp[j] == '*') {
                j--;
                if (charp[j] == '.') {
                    return true;
                } else if (chars[i] != charp[j]) {
                    j--;
                } else {
                    while (i >= 0 && chars[i] == charp[j]) {
                        i--;
                    }
                    j--;
                }
            } else if (charp[j] != '.' && charp[j] != '*' && charp[j] != chars[i]) {
                return false;
            } else {// 字符相同
                j--;
                i--;
            }
        }
        if (i == -1 && (j == -1 || (p.length() > 1 && charp[1] == '*'))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(AlgorithmProblem.leetCode10("aab","c*a*b"));
    }

}
