package com.xiaoruiit.multi_thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hanxiaorui
 * @date 2024/7/17
 */
public class ThreeOrderPringV2 {

    private static final ReentrantLock lock = new ReentrantLock();

    private static final Condition condition = lock.newCondition();

    private static final AtomicInteger currentCharIndex = new AtomicInteger(); // a:0, b:1, c:2

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new PrintChar('A'));
        Thread threadB = new Thread(new PrintChar('B'));
        Thread threadC = new Thread(new PrintChar('C'));

        threadA.start();
        threadB.start();
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();
    }

    public static class PrintChar implements Runnable{

        char c;

        int index;

        public PrintChar(char str){
            this.c = str;
            this.index = c == 'A' ? 0 : c == 'B' ? 1 : 2;
        }
        @Override
        public void run() {
            try {
                for (int i = 0; i < 2; i++) {// 执行几轮 打印A、B、C
                    lock.lock();
                    try {
                        while(currentCharIndex.get() % 3 != index){
                            condition.await();
                        }

                        System.out.println(c);
                        currentCharIndex.incrementAndGet();
                        condition.signalAll();
                    } finally {
                        lock.unlock();
                    }
                }
            } catch (InterruptedException e){
                System.out.println("异常");
                Thread.currentThread().interrupt();
            }
        }
    }
}
