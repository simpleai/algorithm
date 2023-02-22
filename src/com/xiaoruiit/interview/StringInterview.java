package com.xiaoruiit.interview;

import java.lang.reflect.Field;

/**
 * @author hxr
 * @Classname StringInterview
 * @Description String引用，常量池
 */
public class StringInterview {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        // 不改变引用的情况下改变引用指向的值
        String s = "abc";
        Field value = s.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(s, "abcd".toCharArray());
        System.out.println(s);

        // String 相等判断
        String a = new String("abcd");// 对象
        String b = "abcd";
        System.out.print("a == b:");// false 比较引用指向的地址
        System.out.println(a == b);// false 比较引用指向的地址
        System.out.println(a.equals(b));// 比较地址中的值

        String f = "abcd";
        System.out.print("b == f:");
        System.out.println(b == f);

        String c = a.intern();// 返回常量池中字符串的引用；new String("abcd")，不会加入常量池，不会返回常量池的引用
        System.out.print("b == c:");
        System.out.println(b == c);
        System.out.print("a == c:");
        System.out.println(a == c);

        String d = a;
        System.out.println("d == a:" + d == a);
    }
}
