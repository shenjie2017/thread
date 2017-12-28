package com.blue;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 13:26 2017/12/27
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

public class ReadWriteLockDemo {
    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        new Thread(){
            @Override
            public void run() {
                demo.read(Thread.currentThread());
                demo.write(Thread.currentThread());
            }
        }.start();

        new Thread(){

            @Override
            public void run() {
                demo.read(Thread.currentThread());
                demo.write(Thread.currentThread());
            }
        }.start();
    }

    public void read(Thread thread){
        rwl.readLock().lock();
        try{
            long start = System.currentTimeMillis();
            while(System.currentTimeMillis()-start<=1000){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(thread.getName() + " " + "正在进行读操作");
            }
            System.out.println(thread.getName() + " " + "读操作完成");
        }finally {
            rwl.readLock().unlock();
        }

    }

    public void write(Thread thread){
        rwl.writeLock().lock();
        try{
            long start = System.currentTimeMillis();
            while(System.currentTimeMillis()-start<=1000){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(thread.getName() + " " + "正在进行写操作");
            }
            System.out.println(thread.getName() + " " + "写操作完成");
        }finally {
            rwl.writeLock().unlock();
        }
    }
}
