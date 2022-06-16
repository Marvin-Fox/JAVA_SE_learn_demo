package arithmetic.action;

public class Zhishu {
    /**
     * 判断一个数是不是质数
     */
    public static void main(String[] args) {
        System.out.println(MyEqulse(11));
    }


    public static boolean MyEqulse(int num) {
        if (num == 2 || num == 3) {
            return true;
        } else if (num < 2 || num % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i < num; i = i + 2) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
