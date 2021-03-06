package threads.demo5.threadPool.FixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/6/6.
 * <p>
 * newFixedThreadPool 创建一个固定长度线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 */
public class NewFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            final int index = i;

            //1- 在未来某个时间执行给定的命令。
            // 该命令可能在新的线程、已入池的线程或者正调用的线程中执行，这由 Executor 实现决定。
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    threadRunMethod(index);
                }
            });

            //2- 提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future。
            // 该 Future 的 get 方法在成功完成时将会返回给定的结果
            fixedThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    threadRunMethod(index);
                }
            });
        }
        fixedThreadPool.shutdown();
    }

    /**
     * @param index
     */
    private static void threadRunMethod(int index) {
        try {
            System.out.println(index);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}