package java_0324;

import java.util.Arrays;

public class Testbs {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        print(arr);
    }

    public static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
