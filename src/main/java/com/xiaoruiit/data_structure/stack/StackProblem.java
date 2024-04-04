package com.xiaoruiit.data_structure.stack;

import com.xiaoruiit.util.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 栈算法题
 */
public class StackProblem {

    public static void main(String[] args) {
        System.out.println(judgeBracketString2("()[()]"));

        System.out.println("leetCode739two:" + Arrays.toString(everydayTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println("leetCode224:" + calculateSimple("2-1 + 2"));
        System.out.println("leetCode224:" + calculateSimple("-1+2-1"));

        System.out.println(calculate2("-5"));
        System.out.println(calculate2("2 - 1 + 2"));
        System.out.println(calculate2("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate2("2147483647"));
        System.out.println(calculate2("1-(     -2)"));
        System.out.println(calculate2("(1+2)"));

        System.out.println(Arrays.toString(nextGreaterElement(new int[]{1, 3, 4}, new int[]{1, 4, 3, 2})));

        System.out.println(isPalindrome(ListNode.constructList(new int[]{1})));
        System.out.println(isPalindrome(ListNode.constructList(new int[]{1,2})));
        System.out.println(isPalindrome(ListNode.constructList(new int[]{1,2,1})));
        System.out.println(isPalindrome(ListNode.constructList(new int[]{1,2,2,1})));
        System.out.println(isPalindrome(ListNode.constructList(new int[]{1,2,2,2,1})));
        System.out.println(isPalindrome(ListNode.constructList(new int[]{1,1,2,1})));
    }

    /**
     * LeetCode234.回文链表
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode current = pre;
        while(current.next != null) {
            stack.push(current.next);
            current = current.next;
        }

        while (!stack.isEmpty() && pre.next != null) {
            if (stack.pop().val != pre.next.val) {
                return false;
            }
            pre = pre.next;
        }

        if (stack.isEmpty() && pre.next == null){
            return true;
        }
        return false;
    }

    /**
     * LeetCode496.下一个更大元素
     * 1.反序遍历nums2，用栈来辅助map记录nums2中本元素对应的下一个更大元素；
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    /**
     * LeetCode682.棒球比赛
     *
     * @param operations
     * @return
     */
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

    /**
     * LeetCode224.基本计算器
     * 1. 处理 空格; （0 → （-0 ;第一个字符是 - ,前边填充0；
     * 3. 每次添加数字后，进行计算；遇到 ) ，需要将提前加入的 ( 弹出，如何 ( 弹出后下一个是操作符，进行计算；
     */

    public static int calculate2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String str = s.replace(" ", "").replace("(-", "(0-");
        if (str.charAt(0) == '-') {
            str = "0".concat(str);
        }
        char[] charArray = str.toCharArray();
        Stack<Character> stackOpt = new Stack<>();
        Stack<Integer> stackInt = new Stack<>();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(' || charArray[i] == '+' || charArray[i] == '-') {
                stackOpt.push(charArray[i]);
            } else if (Character.isDigit(charArray[i])) {
                // 数字处理 '218' → 218
                int num = Character.getNumericValue(charArray[i]);
                while (i + 1 < charArray.length && Character.isDigit(charArray[i + 1])) {
                    num = num * 10 + Character.getNumericValue(charArray[i + 1]);
                    i++;
                }
                stackInt.push(num);

                // 计算
                calc(stackOpt, stackInt);
            } else {// charArray[i] == ')'
                stackOpt.pop();// （ 出栈
                // 计算
                calc(stackOpt, stackInt);
            }
        }

        return stackInt.pop();
    }

    public static void calc(Stack<Character> stackOpt, Stack<Integer> stackInt) {
        if (stackInt.empty() || stackInt.size() < 2) {
            return;
        }

        if (stackOpt.peek() == '+') {
            stackInt.push(stackInt.pop() + stackInt.pop());
            stackOpt.pop();
        } else if (stackOpt.peek() == '-') {
            Integer pop = stackInt.pop();
            stackInt.push(stackInt.pop() - pop);
            stackOpt.pop();
        }

//        if (stackOpt.isEmpty() || stackOpt.peek() == '('){
//            return;
//        }
    }

    /**
     * LeetCode224.基本计算器
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.replace(" ", "").toCharArray();
        Stack<Object> stack = new Stack<>();
        if (Character.isDigit(chars[0])) {
            stack.push(0);
            stack.push('+');
        } else if ('-' == chars[0]) {
            stack.push(0);
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '-' && !stack.isEmpty()) {
                if (stack.peek() instanceof Character && '(' == (Character) stack.peek()) {
                    stack.push(0);
                }
            }
            if (chars[i] == '+' || chars[i] == '(' || chars[i] == '-') {
                stack.push(chars[i]);
            } else if (chars[i] == ')') {
                String str = String.valueOf(stack.pop());
                Integer i1 = Integer.valueOf(str);
                stack.pop();
                if (!stack.isEmpty()) {
                    if ('(' == (Character) stack.peek()) {
                        stack.pop();
                        stack.push(i1);
                    } else {
                        Character pop = (Character) stack.pop();// 必定是操作符
                        Integer i2 = Integer.valueOf(String.valueOf(stack.pop()));
                        if (pop == '+') {
                            stack.push(i2 + i1);
                        } else {
                            stack.push(i2 - i1);
                        }
                    }
                } else {
                    stack.push(i1);
                }
            } else {// 数字
                int temp = 0;
                Stack<Integer> stackInt = new Stack<>();
                stackInt.push(Character.getNumericValue(chars[i]));
                while (i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
                    stackInt.push(Character.getNumericValue(chars[i + 1]));
                    i++;
                }
                temp += stackInt.pop();
                int wei = 1;
                int j = 0;
                while (!stackInt.isEmpty()) {
                    wei *= 10;
                    temp += stackInt.pop() * wei;
                    j++;
                }

                // 栈顶是 ( 或 操作符 +-
                if (stack.isEmpty() || '(' == (Character) stack.peek()) {
                    stack.push(temp);
                } else {// 操作符
                    Character pop = (Character) stack.pop();
                    Integer i1 = (Integer) stack.pop();
                    if ('+' == pop) {
                        stack.push(i1 + temp);
                    } else {
                        stack.push(i1 - temp);
                    }
                }
            }
        }

        return (Integer) stack.pop();
    }


    /**
     * LeetCode224.基本计算器 简化
     *
     * @param s
     * @return
     */
    public static int calculateSimple(String s) {
        char[] chars = s.replace(" ", "").toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push('+');
        Stack<Integer> stackInt = new Stack<>();
        stackInt.push(0);

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+' || chars[i] == '-') {
                stack.push(chars[i]);
            } else {
                Character ch = stack.pop();
                Integer integer = stackInt.pop();
                Integer i1 = Integer.valueOf(String.valueOf(chars[i]));
                if (ch == '+') {
                    stackInt.push(integer + i1);
                } else if (ch == '-') {
                    stackInt.push(integer - i1);
                }
            }
        }

        return stackInt.pop();
    }

    /**
     * LeetCode.844比较含退格的字符串
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (stack.empty()) {
                    continue;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        Stack<Character> stack2 = new Stack<>();
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (stack2.empty()) {
                    continue;
                }
                stack2.pop();
            } else {
                stack2.push(c);
            }
        }

        if (stack.size() != stack2.size()) {
            return false;
        }

        while (!stack.isEmpty() && !stack2.isEmpty()) {
            if (stack.pop() != stack2.pop()) {
                return false;
            }
        }
        return true;
    }

    /**
     * LeetCode.232用栈实现队列
     */
    class MyQueue {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            while (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
            stack.push(x);
            while (!stack2.isEmpty()) {
                stack.push(stack2.pop());
            }
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.empty();
        }
    }

    /**
     * LeetCode.155最小栈
     */
    class MinStack {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public MinStack() {
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(minStack.peek(), val));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    /**
     * 简单 LeetCode20.有效的括号
     * 思路：
     * 左括号入栈，
     * 右括号，出栈与右括号相同，继续循环；
     * 出栈与右括号不相同，返回fasle;
     * 最后判断栈是否为空
     *
     * @param s
     * @return
     */
    public static boolean judgeBracketString2(String s) {
        char[] chars = s.toCharArray();

        Stack stack = new Stack();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            } else if (chars[i] == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else if (!stack.pop().equals('(')) {
                    return false;
                }
            } else if (chars[i] == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else if (!stack.pop().equals('[')) {
                    return false;
                }
            } else if (chars[i] == '}') {
                if (stack.isEmpty()) {
                    return false;
                } else if (!stack.pop().equals('{')) {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    /**
     * LeetCode20.有效的括号
     * <p>
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：左括号必须与相同类型的右括号匹配，左括号必须以正确的顺序匹配。
     */
    public static boolean judgeBracketString(String[] str) {
        if (str == null || str.length == 0) {
            return false;
        }

        Stack stack = new Stack();
        for (int i = 0; i < str.length; i++) {
            if (judgeLeftBracket(str[i])) {
                stack.push(str[i]);
            }
            if (judgeRightBracket(str[i])) {
                if (stack.empty()) {
                    return false;
                }
                if (!judgeBracketType(str[i]).equals(stack.pop().toString())) {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    private static String judgeBracketType(String s) {
        String result = "";
        switch (s) {
            case ")":
                result = "(";
                break;
            case "]":
                result = "[";
                break;
            case "}":
                result = "{";
                break;
        }
        return result;
    }

    private static boolean judgeLeftBracket(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if ("(".equals(s) || "[".equals(s) || "{".equals(s)) {
            return true;
        }
        return false;
    }

    private static boolean judgeRightBracket(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (")".equals(s) || "]".equals(s) || "}".equals(s)) {
            return true;
        }
        return false;
    }

    /**
     * 给定一个包含 n 个元素的链表，现在要求每 k 个节点一组进行翻转，打印翻转后的链表结果。其中，k 是一个正整数，且 n 可被 k 整除。
     * 例如，链表为 1 -> 2 -> 3 -> 4 -> 5 -> 6，k = 3，则打印 321654。
     */
    public static void reverserLinkedList(ListNode head, int k) {
        if (head == null || k < 1) {
            return;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        int count = 0;
        while (head != null) {
            stack.push(head);
            count++;
            if (count == k) {
                while (!stack.empty()) {
                    System.out.println(stack.pop().val);
                }
                count = 0;
            }
            head = head.next;
        }
    }

    /**
     * 中等 leetCode739.每日温度
     * 思路：前进，后退，从后退处前进
     *
     * @param temperatures
     * @return
     */
    public static int[] everydayTemperatures2(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return temperatures;
        }

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int pop = stack.pop();
                result[pop] = i - pop;
            }
            stack.push(i);
        }

        return result;
    }

    /**
     * LeetCode739.每日温度
     * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     * <p>
     * 输入: temperatures = [30,40,50,60]
     * 输出: [1,1,1,0]
     */
    public static int[] everydayTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                result[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return result;
    }

}
