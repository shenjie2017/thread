package com.blue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 15:38 2017/12/27
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

public class ScheduledThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        int cpuNum = Runtime.getRuntime().availableProcessors();
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(cpuNum);
        List<Future<?>> arrayList = new ArrayList<Future<?>>();
        Random random = new Random();
        for (int i = 0; i < 200000 ; i++) {
//            Future<String> future = threadPool.submit(new TaskCallable(i));
            //带有延时执行
            Future<String> future = threadPool.schedule(new TaskCallable(i),random.nextInt(100),TimeUnit.MILLISECONDS);
            arrayList.add(future);
        }

        for(Future<?> future:arrayList){
            if(future.isDone()){
                System.out.println("is done.-------" + future.get());
            }else{
                System.out.println("is not done.------wait done.------" + future.get());
            }
        }
        threadPool.shutdown();
        System.out.println("time:"+(System.currentTimeMillis()-start));
    }
}

class TaskCallable implements Callable<String>{
    int i;
    TaskCallable(int i){
        this.i = i;
    }

    public String call() throws Exception {
//                    System.out.println("thread name(" + ii + "):" + Thread.currentThread().getName());
        return "thread name(" + i + "):" + Thread.currentThread().getName();
    }
}
