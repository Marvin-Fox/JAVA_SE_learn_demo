package threads.demo2.runnable;

public class ImplRunnable implements Runnable {

	Integer number;
	
	public ImplRunnable(Integer number) {
		// TODO Auto-generated constructor stub
		this.number=number;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(number){
			
			while(number>0){
				System.out.println(Thread.currentThread().getName()+"~~~~~~"+number--);
			}
		}
		
	}
	


}
