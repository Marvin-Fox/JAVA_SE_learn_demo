package threads.demo1.thread;

public class ExtendsThread extends Thread {
	int number;
	
	public ExtendsThread(int number) {
		// TODO Auto-generated constructor stub
		this.number=number;
	}

	@Override
	public void run() {
		synchronized (ExtendsThread.class) {
			while(number>0){
				System.out.println(Thread.currentThread()+"~~~~~~"+number--);
			}
		}
		
	}
	
	
	

}
