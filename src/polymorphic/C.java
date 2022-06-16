package polymorphic;

import javax.xml.bind.ValidationEvent;

public class C implements A {

    @Override
    public void a() {
        System.out.println("c and a");
    }

    @Override
    public void a1() {
        System.out.println("c and a1");
    }

    public void c() {
        System.out.println("c and c");
    }

}
