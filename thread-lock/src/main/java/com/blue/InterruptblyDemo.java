package com.blue;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 11:40 2017/12/27
 * @Modifide By:
 **/

//      ┏┛ ┻━━━━━┛ ┻┓
//      ┃　　　　　　 ┃
//      ┃　　　━　　　┃
//      ┃　┳┛　  ┗┳　┃
//      ┃　　　　　　 ┃
//      ┃　　　┻　　　┃
//      ┃　　　　　　 ┃
//      ┗━┓　　　┏━━━┛
//        ┃　　　┃   神兽保佑
//        ┃　　　┃   代码无BUG！
//        ┃　　　┗━━━━━━━━━┓
//        ┃　　　　　　　    ┣┓
//        ┃　　　　         ┏┛
//        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
//          ┃ ┫ ┫   ┃ ┫ ┫
//          ┗━┻━┛   ┗━┻━┛

public class InterruptblyDemo {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        InterruptblyDemo interruptblyDemo = new InterruptblyDemo();
        Thread thread0 = new MyThread(interruptblyDemo);
        Thread thread1 = new MyThread(interruptblyDemo);
        thread0.start();
        thread1.start();

        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
//            e.printStackTrace();y
        }
        thread1.interrupt();
        System.out.println(thread1.getName() + " " + "手动中断线程");

    }

    public void handleBusiness(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println(thread.getName() + " " + "得到了锁");
            long start = System.currentTimeMillis();
            while(true){
                long end = System.currentTimeMillis();
                if(end - start > 1000*60*60){
                    break;
                }
            }
        }finally {
            lock.unlock();
            System.out.println(thread.getName() + " " + "失去了锁");
        }
    }

}

class MyThread extends Thread{

    private InterruptblyDemo obj;

    public MyThread(InterruptblyDemo obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        try {
            obj.handleBusiness(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " " + "被中断");
        }
    }
}