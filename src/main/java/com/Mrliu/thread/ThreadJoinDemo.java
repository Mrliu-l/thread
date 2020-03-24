package com.Mrliu.thread;

import java.util.concurrent.TimeUnit;

/**
 * 验证Thread.join方法：控制线程执行顺序
 * 子线程thread.join后，主线程需等待子线程执行完毕后才能继续往下执行
 */
public class ThreadJoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("Children-Thread: test");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Children-Thread");
        thread.start();
        thread.join();
        System.out.println("test");
    }
}
