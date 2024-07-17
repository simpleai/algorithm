package com.xiaoruiit.multi_thread;

/**
 * 两个线程交替打印奇偶数
 * @author hanxiaorui
 * @date 2024/6/13
 */
public class PrintOddEven {
    public static int count = 0;
    private static final Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100){
                    synchronized (lock){// 一直抢锁和释放锁。 会有不该抢锁的浪费。不适合大量并发，适合小并发
                        if (count % 2 == 0){// 只有抢到锁，并满足偶数时，才打印并自增。
                            System.out.println(Thread.currentThread().getName()+":"+ count++);
                        }
                    }

                }
            }
        }, "偶数").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100){
                    synchronized (lock){// 一直抢锁和释放锁
                        if (count % 2 == 1){// 只有抢到锁，并满足奇数时，才打印并自增。
                            System.out.println(Thread.currentThread().getName()+":"+count++);
                        }
                    }
                }

            }
        }, "奇数").start();

        Thread.sleep(3000);

        new Thread(new WaitNotify(),"偶数").start();
        new Thread(new WaitNotify(),"奇数").start();
    }
}

class WaitNotify implements Runnable{
    public static int count = 0;
    private static final Object lock = new Object();

    @Override
    public void run() {// 交替唤醒和休眠，无需判断奇偶了。 唤醒消费资源
        while (count < 100){
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+":"+count++);
                lock.notify();// 交替唤醒

                if (count < 100){// 防止最后一个一直休眠
                    try {
                        lock.wait();// 交替休眠
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }
    }
}
