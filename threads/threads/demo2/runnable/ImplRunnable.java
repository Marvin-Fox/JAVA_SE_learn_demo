package threads.demo2.runnable;

public class ImplRunnable implements Runnable {

    Integer number;

    public ImplRunnable(Integer number) {
        this.number = number;
    }

    @Override
    public void run() {
        synchronized (number) {

            while (number > 0) {
                System.out.println(Thread.currentThread().getName() + "~~~~~~" + number--);
            }
        }

    }


}
