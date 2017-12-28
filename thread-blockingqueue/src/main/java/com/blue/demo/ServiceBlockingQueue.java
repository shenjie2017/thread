package com.blue.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 16:51 2017/12/27
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

public class ServiceBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue(2);
        ProviderBlockingQueue provider = new ProviderBlockingQueue(queue);
        ConsumerBlockingQueue consumer = new ConsumerBlockingQueue(queue);
        for(int i = 0 ; i < 4; i++){
            new Thread(provider,"provider-"+i).start();
        }

        for(int i = 0 ; i < 8; i++){
            new Thread(consumer,"consumer-"+i).start();
        }
    }
}
