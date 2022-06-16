package polymorphic;

public class B implements A {

    @Override
    public void a() {
        System.out.println("b and a");
    }

    @Override
    public void a1() {
        System.out.println("b and a1");
    }

    public void b() {
        System.out.println("b and b");
    }

}
