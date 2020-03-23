package com.Mrliu.thread;

import java.util.concurrent.TimeUnit;

/**
 * 线程状态演示，jps，jstack
 */
public class ThreadStatusDemo {

    public static void main(String[] args) {
        new Thread(()->{
           while (true){
               try {
                   TimeUnit.SECONDS.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        },"Time_Waiting_Thread").start();

        new Thread(()->{
            while (true){
                synchronized (ThreadStatusDemo.class){
                    try {
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        },"Waiting_Thread").start();

        new Thread(new BlockedDemo(),"Block01_Thread").start();
        new Thread(new BlockedDemo(),"Block02_Thread").start();
    }

    static class BlockedDemo implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (BlockedDemo.class){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
