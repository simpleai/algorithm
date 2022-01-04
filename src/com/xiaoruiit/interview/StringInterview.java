package com.xiaoruiit.interview;

import java.lang.reflect.Field;

/**
 * @author hxr
 * @Classname StringInterview
 * @Description ToDo
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
        System.out.println(a == b);// false 比较引用指向的地址
        System.out.println(a.equals(b));// 比较地址中的值

        String c = a.intern();
        System.out.println(b == c);


        // 打印数组

        int[] arr = {1, 1, 1, 2, 2, 3, 4, 4, 5};
        int i = 1;
        while (i < arr.length - 1) {
            if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1]) {
                System.out.println(arr[i]);
            }
            i++;
        }
        if (arr[i] != arr[i - 1]){
            System.out.println(arr[i]);
        }


    }
}
