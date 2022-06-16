package jvm;

public class CompareString {

    public static final String MESSAGE = "taobao";

    public static void main(String[] args) {
        test2(120);
    }

    public static void test1() {
//		String a="tao"+"bao";
        String b = "tao";
        String c = "bao";
//		System.out.println(a==MESSAGE);
        System.out.println((b + c) == MESSAGE);
        System.out.println(MESSAGE.equals(b + c));
        System.out.println((b + c).intern() == MESSAGE);
    }

    public static void test2(int number) {
        System.out.println(number & 1);
        System.out.println((number & 1) == 0 ? true : false);
    }

}
