package threads.demo1.thread;

public class Demo1 {

    public static void main(String[] args) {
        ExtendsThread extendsThread = new ExtendsThread(100);
        extendsThread.start();

        ExtendsThread extendsThread2 = new ExtendsThread(100);
        extendsThread2.start();

    }


}
