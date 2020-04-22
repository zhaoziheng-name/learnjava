package java_0422;

import java.util.Arrays;

public class TestString {
    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        // toString(array);
        // copyOf(array);
        // System.out.println(binarySearch(array, 1));
        // System.out.println(isSorted(array));
        bubbleSort(array);
    }

    public static void bubbleSort(int[] array) {
        // 升序排序
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = 0; cur < array.length - 1; cur++) {
                if (array[cur] > array[cur + 1]) {
                    int tmp = array[cur];
                    array[cur] = array[cur + 1];
                    array[cur + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 判断是否为升序
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int binarySearch(int[] array, int toFind) {
        int left = 0;
        int right = array.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (toFind < array[mid]) {
                right = mid - 1;
            } else if (toFind > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void copyOf(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        System.out.println(Arrays.toString(newArray));
    }

    public static void toString(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length - 1]);
        System.out.print("]");
    }
}
