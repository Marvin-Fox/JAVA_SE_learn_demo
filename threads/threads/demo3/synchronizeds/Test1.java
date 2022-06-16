package threads.demo3.synchronizeds;


public class Test1 {
    public static int count = 0;

    public static void main(String[] args) {
        final Test1 t1 = new Test1();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    for (int j = 0; j < 100; j++) {
                        t1.addCount();
                    }
                    System.out.println(Thread.currentThread() + " " + count + " ");
                }
            }).start();
        }

        try {
            //主程序暂停3秒，以保证上面的程序执行完成
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " " + "count=" + count);

    }

    public static synchronized void addCount() {
        count++;
    }
}
