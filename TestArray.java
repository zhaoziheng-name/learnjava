package java_0422;

import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        // System.out.println(Arrays.toString(array));
        // printArray(array);
        // transform(array);
        // sum(array);
        avg(array);
    }

    public static double avg(int[] array) {
        double ret = 0;
        double avg = 0;
        for (int i = 0; i < array.length; i++) {
            ret += array[i];
        }
        avg = ret / array.length;
        System.out.println(avg);
        return avg;
    }

    public static int sum(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            tmp += array[i];
        }
        System.out.println(tmp);
        return tmp;
    }

    public static void transform(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int tmp = array[i] * 2;
            newArray[i] = tmp;
        }
        array = newArray;
        System.out.println(Arrays.toString(array));
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.print("]");
    }
}
