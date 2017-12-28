package com.blue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 11:06 2017/12/27
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

public class LockDemo {
    private static List<Integer> arrayList = new ArrayList<Integer>();
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(){
            @Override
            public void run() {
               Thread thread = Thread.currentThread();
               lock.lock();
                System.out.println(thread.getName() + " " + "获得了锁");
               try {
                   for (int i = 0; i < 20; i++) {
                       arrayList.add(i);
                   }
               }catch (Exception e) {
                   e.printStackTrace();
               }finally {
                   System.out.println(thread.getName() + " " + "释放了锁");
                   lock.unlock();
               }
            }
        }.start();

        new Thread(){

            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                lock.lock();
                System.out.println(thread.getName() + " " + "获得了锁");
                try {
                    for (int i = 0; i < 20; i++) {
                        arrayList.add(20+i);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(thread.getName() + " " + "释放了锁");
                    lock.unlock();
                }
            }
        }.start();
        Thread.sleep(3*1000L);
        System.out.println(arrayList);
    }
}
