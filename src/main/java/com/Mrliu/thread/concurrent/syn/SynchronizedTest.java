package com.Mrliu.thread.concurrent.syn;

/**
 * @ClassName SynchronizedTest
 * @Description Synchronized为对象锁，锁的范围为对象的生命周期
 * @Author liulei33
 * @Time 2020/3/25 12:03
 */
public class SynchronizedTest {

    private static Object lock;

    //对象锁，等同于test2；test2的锁范围 <= test1
    //锁的生命周期：伴随着对象的生命周期，new SynchronizedTest()
    public synchronized void test1(){
        //todo
    }

    public void test2(){
        //todo
        synchronized(this){
            //todo
        }
        //todo
    }

    //类锁，等同于test4，test4的缩范围 <= test3
    //锁的生命周期伴随着class类的生命周期
    public synchronized static void test3(){

    }

    public void test4(){
        //todo
        synchronized (lock){
            //todo
        }
        //todo
    }
}
