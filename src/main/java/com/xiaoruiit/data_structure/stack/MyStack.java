package com.xiaoruiit.data_structure.stack;

import java.util.Stack;

/**
 * 顺序栈简易实现
 */
public class MyStack {

    private int[] array;

    public int count;

    MyStack(int length) {
        this.array = new int[length];
        this.count = 0;
    }

    public void push(int a) throws Exception {
        if (this.count < array.length){
            array[count++] = a;
        } else {
            throw new Exception("a");

        }
    }

    public int pop() throws Exception {
        if (this.count != 0 ){
            count--;
            return array[count];
        } else {
            throw new Exception("a");
        }
    }
}
