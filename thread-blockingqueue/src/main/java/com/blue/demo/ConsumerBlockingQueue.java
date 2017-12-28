package com.blue.demo;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 16:43 2017/12/27
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

public class ConsumerBlockingQueue implements Runnable {
    BlockingQueue<String> queue;

    public ConsumerBlockingQueue(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is try get a product...");
//            Thread.sleep(new Random().nextInt(10));
            String product = queue.take();
            System.out.println(Thread.currentThread().getName() + " is get a product success.product is :"+product);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
