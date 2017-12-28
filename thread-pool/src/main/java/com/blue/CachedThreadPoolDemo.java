package com.blue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 15:23 2017/12/27
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

public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 200000 ; i++) {
            final int ii = i;
            threadPool.execute(new Runnable() {
                public void run() {
                    System.out.println("thread name("+ii+"):" + Thread.currentThread().getName());
                }
            });
        }
        threadPool.shutdown();
    }
}
