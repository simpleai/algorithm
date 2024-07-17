package com.xiaoruiit.multi_thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hanxiaorui
 * @date 2024/7/17
 */
public class ThreeOrderPring {

    private static final ReentrantLock lock = new ReentrantLock();

    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();

    private static int state = 0; // a:0, b:1, c:2

    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintChar('A'));
        Thread threadB = new Thread(new PrintChar('B'));
        Thread threadC = new Thread(new PrintChar('C'));

        threadA.start();
        threadB.start();
        threadC.start();
    }

    public static class PrintChar implements Runnable{

        char c;

        public PrintChar(char str){
            this.c = str;
        }
        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {// 执行几轮 打印A、B、C
                    lock.lock();
                    try {
                        while((c == 'A' && state != 0) ||
                                (c == 'B' && state != 1) ||
                                (c == 'C' && state != 2)){
                            if (c == 'A'){// 不该打印A时，A休眠
                                conditionA.await();
                            } else if (c == 'B'){
                                conditionB.await();
                            } else if (c == 'C'){
                                conditionC.await();
                            }
                        }

                        System.out.println(c);

                        if (c == 'A'){// 打印A之后，唤醒B
                            state = 1;
                            conditionB.signal();
                        } else if (c == 'B'){
                            state = 2;
                            conditionC.signal();
                        } else if (c == 'C'){
                            state = 0;
                            conditionA.signal();
                        }
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
