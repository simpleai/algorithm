package com.xiaoruiit.algorithm_problem;

import com.xiaoruiit.util.LeetCodeLinkList;
import com.xiaoruiit.util.ListNode;
import com.xiaoruiit.util.TrieNode;

import java.util.*;

/**
 * 算法题
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
     * <p>
     * 两个有序数组查找合并之后的中位数。给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出这两个正序数组合在一起之后的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * <p>
     * 例如：nums1 = [1, 3, 5, 7, 9]
     * nums2 = [2, 4, 8, 12]
     * 输出 5。
     * <p>
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * <p>
     * 第二种解法：
     * 两数组长度和为奇数，中位数是两个数组中第 (nums1.length + nums2.length)/2 小的数
     * 两数组长度和为偶数，中位数是两个数组中第 ((nums1.length + nums2.length)/2 + (nums1.length + nums2.length)/2 +1 ）/2小的数
     * <p>
     * 每次从两个数组中分别找第 k/2 小的数，比较大小，排除比较小的那个数的左侧的数(x个），要的第k小的数变为找k-x
     */
    public static float leetCode4(int[] nums1, int[] nums2) {
        // 校验

        // 变量
        int length = nums1.length + nums2.length;

        // 递归方法
        if (length % 2 == 1) {// 奇数，找第 length/2 +1 小的数
            return leetCode4Recursion(nums1, 0, nums1.length, nums2, 0, nums2.length, length / 2 + 1);
        } else {
            return ((leetCode4Recursion(nums1, 0, nums1.length, nums2, 0, nums2.length, length / 2) + leetCode4Recursion(nums1, 0, nums1.length, nums2, 0, nums2.length, length / 2 + 1)) / 2.0f);
        }
    }

    /**
     * @param nums1
     * @param m       排除数后新数组开始位置
     * @param mLength 排除后数组的长度
     * @param nums2
     * @param n       排除数后新数组开始位置
     * @param nLength 排除后数组的长度
     * @param k       要找第k小的数
     * @return
     */
    private static int leetCode4Recursion(int[] nums1, int m, int mLength, int[] nums2, int n, int nLength, int k) {
        // 保证长度短的是nums1。nums1的没有nums2长
        if (nums1.length - m > nums2.length - n) {
            return leetCode4Recursion(nums2, n, nLength, nums1, m, mLength, k);
        }

        // 结束条件
        if (mLength == 0) {// nums1数组为空
            return nums2[n + k - 1];
        }
        if (k == 1) {// 其中一个数组只剩一个数
            return nums1[m] < nums2[n] ? nums1[m] : nums2[n];
        }

        // 选择并递归排除（剪枝） 12345 1289
        int exclude = k / 2;// 要排除的数数量
        if (k / 2 > mLength) {// nums1要排除的数 超出新数组nums1长度
            exclude = mLength;// nums1只能排除mLength的数量
        }
        if (nums1[m + exclude - 1] < nums2[n + k / 2 - 1]) {
            return leetCode4Recursion(nums1, m + exclude, mLength - exclude, nums2, n, nLength, k - exclude);
        } else {
            return leetCode4Recursion(nums1, m, mLength, nums2, n + k / 2, nLength - k / 2, k - k / 2);
        }
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
     * <p>
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
     * <p>
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     * <p>
     * 输入：heights = [2,1,5,6,2,3]
     * 输出：10
     * <p>
     * 分析：
     * 判断下一下标对应的高度与当前下标对应的高度
     * 当前下标对应的高度大于下一下标对应的高度，
     * 计算当前下标面积。此次面积与最大面积比较，将大的值赋给最大值。
     * 栈不为空 && 栈顶对下标应的高度大于 下一下标对应的高度，下标前移。
     * 当前下标对应的高度小于下一下标对应的高度，
     * 入栈。下标前移
     * 直到下标到了数组末尾，处理栈中剩余元素：
     * 栈顶下标对应的最大面积：（栈顶下标-栈顶的下一位元素下标）* 栈顶下标对应的元素。原因：柱状图中从右向左，比栈顶小的第一个元素是栈中栈顶的下一个元素。
     * 栈中剩最后一个元素时，它的面积为 下标对应的高度 * 数组长度
     * <p>
     * 代码：
     * 循环数组
     * 当 栈不为空 && （下标超出数组末尾 || 当前下标的高度小于下一下标的高度）
     * 出栈，计算栈顶下标的面积(（下一下标-栈顶下标）* 出栈下标对应的高度)；
     * 计算最大面积；
     * 继续比较栈顶，直到栈顶 < 下一下标对应的高度（此时栈顶下标的面积还可能变大） 或者栈为空。
     * 当前下标入栈。
     * <p>
     * 边界处理方法种类：
     * 1.单独处理
     * 2.为边界增加普通化操作。
     */
    public static int leetCode84(int[] heights) {
        // 校验
        if (heights == null || heights.length == 0) {
            return 0;
        }
        // 变量定义
        int result = 0;
        LinkedList<Integer> linkedList = new LinkedList();
        // 逻辑
        for (int i = 0; i <= heights.length; i++) {
            while (!linkedList.isEmpty() && (i == heights.length || heights[linkedList.peekFirst()] > heights[i])) {
                int height = heights[linkedList.pollFirst()];
                int width = linkedList.isEmpty() ? i : i - 1 - linkedList.peekFirst();// 栈为空，说明他前面的高度都比他高，宽度为当前下标； 栈不为空，宽度为：当前下标前一个下标 - 栈中第一个比他小的下标
                result = height * width > result ? height * width : result;
            }
            linkedList.offerFirst(i);
        }

        return result;
    }

    /**
     * leetCode 23.合并K个升序链表
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * <p>
     * 分析：
     * 挨个比较链表头，最小的加入到新链表。
     * 比较链表头可以用优先队列。
     *
     * @param node
     * @return
     */
    public static ListNode leetCode23(ListNode[] node) {
        // 校验
        if (node == null || node.length == 0) {
            return null;
        }
        // 变量
        ListNode result = new ListNode(), temp = result;
        PriorityQueue<ListNode> p = new PriorityQueue<>(node.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {// 小根堆
                return a.val - b.val;
            }
        });


        // 逻辑
        // 初始化 p
        for (int i = 0; i < node.length; i++) {
            if (node[i] != null) {
                p.offer(node[i]);
            }
        }
        while (!p.isEmpty()) {
            ListNode poll = p.poll();
            temp.next = poll;
            temp = temp.next;

            if (poll.next != null) {// 当前指针的下一个结点不为空，将其加入优先队列
                p.offer(poll.next);
            }
        }

        return result.next;
    }

    /**
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
     * <p>
     * needle 是空字符串时我们应当返回 0
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int leetCode28(String haystack, String needle) {
        // 校验
        if (needle.length() == 0) {
            return 0;
        }
        // 变量
        char[] nChars = needle.toCharArray();
        char[] hChars = haystack.toCharArray();
        int result = -1;
        int[] lpsNeedle = new int[needle.length()]; //  最长公共前缀

        // 逻辑
        // needle的最长公共前缀  abcabdc
        int i = 1, j = 0;
        while (i < needle.length()) {
            if (nChars[i] == nChars[j]) {
                lpsNeedle[i++] = ++j;
            } else if (j > 0) {// 尝试第二长的前缀和后缀，是否能继续延续下去
                j = lpsNeedle[j - 1];
            } else {
                i++;
            }
        }

        // 求indexOf
        // ababefababd
        // ababd
        i = 0;
        j = 0;
        while (i < haystack.length()) {
            if (hChars[i] == nChars[j]) {
                i++;
                j++;
                if (j > nChars.length - 1) {
                    return i - needle.length();
                }
            } else {
                if (j > 0) {
                    j = lpsNeedle[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    /**
     * leetCode 336.回文对
     *
     * 给定一组 互不相同 的单词， 找出所有 不同 的索引对 (i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
     *
     * @param words
     */
    public static List<List<Integer>> leetCode336(String[] words){
        // 变量
        List<List<Integer>> result = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {// 创建trie
            addWord(root, words[i], i);
        }

        for (int i = 0; i < words.length; i++) {// 查找
            search(words, i, root, result);
        }

        return result;
    }

    private static void search(String[] words, int i, TrieNode root, List<List<Integer>> result) {

        char[] chars = words[i].toCharArray();
        // k1>k2,且k1剩下的字符能构成回文，将组合添加到结果中
        for (int j = 0; j < words[i].length(); j++) {
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length()-1)){// k2前缀树中遇到某个单词结束 && k1 != k2 && k1剩下的字符能构成回文
                result.add(Arrays.asList(i, root.index));
            }

            root = root.children.get(chars[j]);

            if (root == null) return;
        }

        // k1==k2 或 k1<k2，只需要把回文列表里的字符都和s1组合
        for (int j : root.palindromes) {
            if (i == j) continue;
            result.add(Arrays.asList(i, j));
        }
    }

    private static void addWord(TrieNode root, String word, int index) {
        char[] chars = word.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (!root.children.containsKey(chars[i])){// 对于每个当前字符，如果还没有被添加到children哈希表中，创建一个新结点，放入children哈希表中
                root.children.put(chars[i],new TrieNode());
            }

            if (isPalindrome(word, 0, i)){// 若该字符串从头开始到当前位置能成为回文的话，把这个字符串的下标添加到这个 Trie 节点的回文列表里
                root.palindromes.add(index);
            }

            root = root.children.get(chars[i]);
        }

        root.palindromes.add(index);// 最后一个字符可以构成回文，添加到回文列表中
        root.index = index;// 设置 结束&&第几个单词 标记j

    }

    private static boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }

    /**
     * LeetCode 212.单词搜索 II TODO 深度优先遍历 + TrieTree
     *
     * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
     *
     * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
     *
     */
    public static List<String> leetCode212(char[][] board, String[] words){
        List<String> result = new ArrayList<>();
        // 校验

        // 变量



        return result;
    }

    public static void main(String[] args) {

        System.out.println(AlgorithmProblem.leetCode10("aab", "c*a*b"));

        System.out.println(AlgorithmProblem.leetCode84(new int[]{2, 4}));

        System.out.println(AlgorithmProblem.leetCode4(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7}));

        LeetCodeLinkList.print(AlgorithmProblem.leetCode23(new ListNode[]{new LeetCodeLinkList().init(0), new LeetCodeLinkList().init(111)}));

        System.out.println(AlgorithmProblem.leetCode28("aabaaabaaac", "aabaaac"));

        String[] words = new String[]{"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> lists = AlgorithmProblem.leetCode336(words);
        for (List<Integer> list: lists) {
            System.out.println(list);
        }
    }

}
