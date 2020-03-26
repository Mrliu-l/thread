package com.Mrliu.thread.base;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断后复位
 */
public class InterruptResetDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
           while (true){
               if(Thread.currentThread().isInterrupted()){
                   System.out.println("before:"+Thread.currentThread().isInterrupted());
                   Thread.interrupted();
                   System.out.println("After:" + Thread.currentThread().isInterrupted());
               }
           }
        });

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        ExceptionResetDemo();
    }

    public static void ExceptionResetDemo() throws InterruptedException {
        Thread thread = new Thread(()->{
           while (true){
               if(Thread.currentThread().isInterrupted()){
                   try {
                       TimeUnit.SECONDS.sleep(1);
                   } catch (InterruptedException e) {
                       //抛出异常，告诉当前状态当前不能中断
                       e.printStackTrace();
                   }
                   System.out.println("state:" + Thread.currentThread().isInterrupted());
               }
           }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
