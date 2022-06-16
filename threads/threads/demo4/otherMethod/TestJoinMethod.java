package threads.demo4.otherMethod;

public class TestJoinMethod {

    public static void main(String[] args) {
        Thread t1 = new Thread(new JoinDemo());

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程第" + i + "次执行！");
            if (i == 5)
                try {
                    System.out.println("main state:" + Thread.currentThread().getState());
                    System.out.println("t1 state of befor :" + t1.getState());
                    t1.start();
                    // t1线程合并到主线程中，主线程停止执行过程，转而执行t1线程，直到t1执行完毕后继续。
                    // join()方法一定要在start后
                    t1.join();
                    System.out.println("t1 state of after:" + t1.getState());
                    System.out.println("main state:" + Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}

class JoinDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("t1 state run:" + Thread.currentThread().getState());
        for (int i = 0; i < 10; i++) {
            System.out.println("线程1第" + i + "次执行！");
        }
    }

}
