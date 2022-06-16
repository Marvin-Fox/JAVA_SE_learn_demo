package threads.demo3.synchronizeds;


/**
 * synchronized修饰非静态方法时
 * 锁定的是该类中被synchronized修饰的所有方法,共同为一把锁（如：Method 1、Method 2）
 * 没有被修饰的方法仍然可以被调用（如：Method 3）
 */
public class Test {

    public synchronized void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public synchronized void method2() {
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }

    public void method3() {
        System.out.println("Method 3 start");
        try {
            System.out.println("Method 3 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 3 end");
    }

    public static void main(String[] args) {
        final Test test = new Test();
//         final Test test2 = new Test();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method2();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method3();
            }
        }).start();
    }
}
