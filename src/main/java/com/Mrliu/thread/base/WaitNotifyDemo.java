package com.Mrliu.thread.base;

/**
 * wait和notify的使用场景
 * wait：1、实现线程的阻塞；2、释放当前的同步锁（）所以wait必须配合synchronize使用
 * notify/notifyall： 唤醒被阻塞的线程
 */
public class WaitNotifyDemo {


    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(new ThreadA(lock)).start();
        new Thread(new ThreadB(lock)).start();
    }

    static class ThreadA implements Runnable{
        Object lock;

        public ThreadA(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock){
                System.out.println("ThreadA开始执行");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ThreadA执行结束");
            }
        }
    }

    static class ThreadB implements Runnable{
        Object lock;

        public ThreadB(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock){
                System.out.println("ThreadB开始执行");
                lock.notify();
                System.out.println("ThreadB执行结束");
            }
        }
    }
}
