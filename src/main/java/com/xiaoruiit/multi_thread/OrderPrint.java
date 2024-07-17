package com.xiaoruiit.multi_thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 属性：定义锁、条件、自增值
 * main执行：定义三个线程，启动三个线程，子线程加入到主线程
 * 定义线程执行类，实现Runnable接口
 *  属性：标识线程是谁，标识是否该自己执行
 *  实现run方法
 *      for循环
 *          加锁
     *          不应该自己执行，休眠自己
     *          打印自己
     *          执行次数++
     *          唤醒所有线程
 *          解锁
 */
public class OrderPrint {

    private static final ReentrantLock lock = new ReentrantLock();

    private static final Condition condition = lock.newCondition();

    private static AtomicInteger state = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new PrintChar('A', 0));
        Thread threadB = new Thread(new PrintChar('B', 1));
        Thread threadC = new Thread(new PrintChar('C', 2));

        threadA.start();
        threadB.start();
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();
    }

    private static class PrintChar implements Runnable {
        char c;

        int index;

        PrintChar(char c, int index) {
            this.c = c;
            this.index = index;
        }


        @Override
        public void run() {
            try {
                for (int i = 0; i < 2; i++) {
                    lock.lock();
                    try {
                        if (state.get() % 3 != index) {
                            condition.await();
                        }
                        System.out.println(c);
                        state.getAndIncrement();
                        condition.signalAll();
                    } finally {
                        lock.unlock();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
