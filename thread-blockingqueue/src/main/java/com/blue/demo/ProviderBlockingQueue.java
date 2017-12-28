package com.blue.demo;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 16:42 2017/12/27
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

public class ProviderBlockingQueue implements Runnable {
    private BlockingQueue<String> queue;

    public ProviderBlockingQueue(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        String tmp = Thread.currentThread().getName() + ":" + "i have made a product";
        try {
//            Thread.sleep(new Random().nextInt(10));
            queue.put(tmp);
            System.out.println(tmp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
