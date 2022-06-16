package threads.demo5.threadPool.SingleThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/6/6.
 * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
 * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 */
public class NewSingleThreadExecutor {
    public static void main(String[] args) {

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            /*singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("newSingleThreadExecutor: " + index);
                        Thread.sleep(2*1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });*/


            singleThreadExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("newSingleThreadExecutor: " + index);
                        Thread.sleep(2 * 1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        singleThreadExecutor.shutdown();
    }

}