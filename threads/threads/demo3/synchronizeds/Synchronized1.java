package threads.demo3.synchronizeds;

/**
 * 【仍存在问题，偶尔会出现多生产或多消费1个的问题】
 * 生产者消费者模拟
 */
public class Synchronized1 {

    Integer product = 10;
    final Integer MAX_PRODUCT = 50;
    final Integer MIN_PRODUCT = 10;

    public static void main(String[] args) {
        final Synchronized1 s1 = new Synchronized1();

        //生产者
//		Thread aThread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				s1.produce();
//			}
//		});
//		aThread.setName("生产者1-");
//		aThread.start();
        for (int i = 1; i < 6; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    s1.produce();
                }
            }, "生产者" + i + "-").start();
        }


        //消费者
        for (int i = 1; i < 6; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    s1.consume();
                }
            }, "消费者" + i + "-").start();

        }

    }

    /**
     * 生产者生产出来的产品交给店员
     */
    public synchronized void produce() {
        while (true) {

            if (this.product >= MAX_PRODUCT) {
                try {
                    System.out.println(Thread.currentThread().getName() + "产品已满，请稍后再生产");
                    this.wait();
//					continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            this.product++;
            System.out.println(Thread.currentThread().getName() + "生产者生产第" + this.product + "个产品");
            notifyAll();//通知等待区的消费者可以取出产品了
        }
    }

    /**
     * 消费者从店员取产品
     */
    public synchronized void consume() {
        while (true) {
            if (product <= MIN_PRODUCT) {
                try {
                    System.out.println(Thread.currentThread().getName() + "库存不足，请稍后再取");
                    this.wait();
//					continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "消费者取走了第" + this.product + "个产品.");
            this.product--;
            notifyAll();//通知等待去的生产者可以生产产品了
        }

    }

}
