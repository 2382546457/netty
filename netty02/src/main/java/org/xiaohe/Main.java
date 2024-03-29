package org.xiaohe;

import java.util.concurrent.FutureTask;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-01-23 19:09
 */
public class Main {
    private static int i = 0;
    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock) {
                lock.notifyAll();
                System.out.println(Thread.currentThread().getName() + (i++));
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "线程1").start();

        new Thread(() -> {
            synchronized (lock) {
                lock.notifyAll();
                System.out.println(Thread.currentThread().getName() + (i++));
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "线程2").start();
    }
}