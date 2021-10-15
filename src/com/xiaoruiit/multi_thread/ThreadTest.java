package com.xiaoruiit.multi_thread;

public class ThreadTest{

    volatile Integer i = 0;

    synchronized public void add(){
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest threadTest = new ThreadTest();

        for (int j = 0; j < 1000; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    threadTest.add();
                }
            }).start();
        }
        Thread.sleep(10000);//等待10秒，保证上面程序执行完成
        System.out.println(threadTest.i);
    }



}
