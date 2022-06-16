package jvm;

public class EqulseAndHashCode {

    public static void main(String[] args) {
        System.out.println(new Integer(123).toString());

        TempClass t = new TempClass(1, "1");
        TempClass t2 = new TempClass(1, "1");
        System.out.println(t.equals(t2));


        System.out.println(t.toString());
        System.out.println(t2.toString());

    }

}
