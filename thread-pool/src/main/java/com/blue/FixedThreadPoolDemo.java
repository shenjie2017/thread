package com.blue;

import java.util.concurrent.*;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 15:29 2017/12/27
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

public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int cpuNum = Runtime.getRuntime().availableProcessors();
        ExecutorService threadPool = Executors.newFixedThreadPool(cpuNum);

        for (int i = 0; i < 200000 ; i++) {
            final int ii = i;
            Future<String> future = threadPool.submit(new Callable<String>() {
                public String call() throws Exception {
//                    System.out.println("thread name(" + ii + "):" + Thread.currentThread().getName());
                    return "thread name(" + ii + "):" + Thread.currentThread().getName();
                }
            });
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
        System.out.println("time:"+(System.currentTimeMillis()-start));
    }
}
