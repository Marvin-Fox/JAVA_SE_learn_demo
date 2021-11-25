package threads.demo2.runnable;

public class Demo1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getImplRunnable();
	}
	
	public static void getImplRunnable(){
		ImplRunnable implRunnable=new ImplRunnable(100);
		
		Thread thread=new Thread(implRunnable);
		thread.start();
		
		Thread thread2=new Thread(implRunnable);
		thread2.start();
		
		Thread thread3=new Thread(implRunnable);
		thread3.start();
		
		Thread thread4=new Thread(implRunnable);
		thread4.start();
	}
}


