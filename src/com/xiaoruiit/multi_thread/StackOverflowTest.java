package com.xiaoruiit.multi_thread;

public class StackOverflowTest {
    static int count = 0;
    static void a() {
        System.out.println(count);
        count++;
        b();
    }
    static void b() {
        System.out.println(count);
        count++;
        a();
    }
    public static void main(String[] args) throws Exception {
        a();
    }
}
