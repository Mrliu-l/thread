package com.Mrliu.thread.base;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断演示thread.interrupt
 */
public class InterruptDemo {

    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
           while (!Thread.currentThread().isInterrupted()){
               i++;
           }
            System.out.println(i);
        });

        thread.start();

        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
