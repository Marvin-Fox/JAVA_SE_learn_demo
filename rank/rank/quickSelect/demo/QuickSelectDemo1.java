package rank.quickSelect.demo;


import java.util.Arrays;
import java.util.Random;

public class QuickSelectDemo1 {

    public static void main(String[] args) {
        int[] arr = {1000, 0, 6, 5, 4, 3, 2, 1, 7, 156, 44, 23, 123, 11, 5};
        System.out.println("before:" + Arrays.toString(arr));
        int kth = quickSelect(arr, 0, arr.length - 1, 8);

        System.out.println("quickSelect:" + kth);
        Arrays.sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));

    }

    private static int quickSelect(int[] arr, int l, int h, int k) {
        int l_temp = l;//缓存
        int h_temp = h;

        int q = randomizedPartition(arr, l, h);//随机择取中位数
        //快速选择核心逻辑
        if (q == k)
            return arr[q];
        else if (q < k)
            return quickSelect(arr, q + 1, h_temp, k);
        else
            return quickSelect(arr, l_temp, q - 1, k);
    }

    private static int randomizedPartition(int[] arr, int l, int h) {
        int i = new Random().nextInt(h - l + 1) + l;
        System.out.println("i=" + i);
        //由于partition中默认选取的是最后一位主元，要随机选取，需要把随机取到的数放到最后
        swap(arr, i, h);
        System.out.println("swap-->" + Arrays.toString(arr));
        return partition(arr, l, h);
    }


    private static int partition(int[] arr, int l, int h) {
        int i = l - 1;
        int key = arr[h];//选取最后一位为中位数或者叫主元素
        for (int j = l; j < h; j++) {
            if (arr[j] <= key) {
                i++;
                System.out.println("i=" + i + ",j=" + j);
                swap(arr, i, j);
            }
        }
        System.out.println("end swp-->" + Arrays.toString(arr));
        swap(arr, i + 1, h);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
