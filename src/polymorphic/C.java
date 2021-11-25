package polymorphic;

import javax.xml.bind.ValidationEvent;

public class C implements A {

	@Override
	public void a() {
		// TODO Auto-generated method stub
		System.out.println("c and a");
	}

	@Override
	public void a1() {
		// TODO Auto-generated method stub
			System.out.println("c and a1");
	}
	
	public void c(){
		System.out.println("c and c");
	}

}
