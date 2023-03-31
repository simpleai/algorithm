package com.xiaoruiit.util;

/**
 * 自定义异常
 */
public class MyException extends RuntimeException {
    public MyException(){};
    public MyException(String message){
        super(message);
    }
}
