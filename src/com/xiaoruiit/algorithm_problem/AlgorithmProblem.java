package com.xiaoruiit.algorithm_problem;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 算法题 TODO
 */
public class AlgorithmProblem {

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
     * leetCode 4.查找两个有序数组合并后的中位数
     *
     * 两个有序数组查找合并之后的中位数。给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出这两个正序数组合在一起之后的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     *
     * 例如：nums1 = [1, 3, 5, 7, 9]
     * nums2 = [2, 4, 8, 12]
     * 输出 5。
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     *
     * 分析：
     *      123456  456789
     *      nums1.length = 0时, 直接返回 nums2[nums2.length / 2]
     *      0 < nums1.length <= nums2.length
     *
     *      nums1的中间 < nums2的中间，nums1中间左边和nums2中间的右边都不可能是中位数；去除nums1左边的数，去除nums2右边  nums左边个数 的数
     *      nums1的中间 == nums2的中间，中位数时nums1的中间的数
     *      nums1的中间 > nums2的中间，nums1中间右边和nums2中间的左边都不可能是中位数；去除nums1右边的数，去除nums2左边  nums右边个数 的数
     *
     *      当nums1 只剩 1 , 2个数时
     */
    public static int leetCode4(int[] nums1, int[] nums2) {
        // 校验

        // 特殊处理
        if (nums1.length == 0 && nums2.length != 0){
            return nums2[nums2.length/2];
        }
        if (nums2.length == 0 && nums1.length != 0){
            return nums1[nums1.length /2];
        }

        // 变量

        // 递归方法
        if (nums1.length <= nums2.length){
            return leetCode10Recursion(nums1,0, nums1.length, nums2, 0, nums2.length);
        } else {
            leetCode10Recursion(nums2,0, nums1.length, nums1, 0, nums2.length);
        }


    }

    private static int leetCode10Recursion(int[] nums1, int low1, int high1, int[] nums2, int low2, int high2) {
        if (high1 - low1 == 1 || high1 - low1 == 2){

        }
        int middle1 = low1 + (high1 - low1)/2;
        int middle2 = low2 + (high2 - low2)/2;

    }

    /**
     * leetCode 10.正则表达式匹配
     * <p>
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * <p>
     * '.' 匹配任意单个字符(包括空格)
     * '*' 匹配零个或多个前面的那一个元素
     * ab*aa 与 aaa匹配
     * <p>
     * 所谓匹配，p通过通配符的规则使 p == s
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

        return false;
    }

    /**
     * leetCode 84.柱状图中最大的矩形
     *
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *
     * 输入：heights = [2,1,5,6,2,3]
     * 输出：10
     *
     * 分析：
     *   判断下一下标对应的高度与当前下标对应的高度
     *      当前下标对应的高度大于下一下标对应的高度，
     *          计算当前下标面积。此次面积与最大面积比较，将大的值赋给最大值。
     *          栈不为空 && 栈顶对下标应的高度大于 下一下标对应的高度，下标前移。
     *      当前下标对应的高度小于下一下标对应的高度，
     *          入栈。下标前移
     *  直到下标到了数组末尾，处理栈中剩余元素：
     *      栈顶下标对应的最大面积：（栈顶下标-栈顶的下一位元素下标）* 栈顶下标对应的元素。原因：柱状图中从右向左，比栈顶小的第一个元素是栈中栈顶的下一个元素。
     *      栈中剩最后一个元素时，它的面积为 下标对应的高度 * 数组长度
     *
     *  代码：
     *      循环数组
     *          当 栈不为空 && （下标超出数组末尾 || 当前下标的高度小于下一下标的高度）
     *              出栈，计算栈顶下标的面积(（下一下标-栈顶下标）* 出栈下标对应的高度)；
     *              计算最大面积；
     *              继续比较栈顶，直到栈顶 < 下一下标对应的高度（此时栈顶下标的面积还可能变大） 或者栈为空。
     *          当前下标入栈。
     *
     *  边界处理方法种类：
     *      1.单独处理
     *      2.为边界增加普通化操作。
     */
    public static int leetCode84(int[] heights){
        // 校验
        if (heights == null || heights.length == 0){
            return 0;
        }
        // 变量定义
        int result = 0;
        LinkedList<Integer> linkedList = new LinkedList();
        // 逻辑
        for (int i = 0; i <= heights.length; i++) {
            while( !linkedList.isEmpty() && ( i == heights.length || heights[linkedList.peekFirst()] > heights[i])){
                int height = heights[linkedList.pollFirst()];
                int width = linkedList.isEmpty() ? i : i - 1 - linkedList.peekFirst();// 栈为空，说明他前面的高度都比他高，宽度为当前下标； 栈不为空，宽度为：当前下标前一个下标 - 栈中第一个比他小的下标
                result = height * width > result ? height * width : result;
            }
            linkedList.offerFirst(i);
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(AlgorithmProblem.leetCode10("aab","c*a*b"));

        System.out.println(AlgorithmProblem.leetCode84(new int[]{2,4}));

        System.out.println(AlgorithmProblem.leetCode4(new int[]{}, new int[]{2}));
    }

}
