import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

public class DGtest {
//    public static void main(String[] args) {
//        int[] arr = {9, 5, 2, 7};
//        printArray(arr);
//        int n = 40;
//        int ret = fib(n);
//        System.out.println("ret = " + ret);
//    }
//    public static void printArray(int[] a) {
//        for (int x :a) {
//            System.out.println(x);
//        }
//    }
//    非递归算"生兔子"
//    public static int fib(int num) {
//        int cur = 0;
//        int last1 = 1;
//        int last2 = 1;
//        for (int i = 3; i <= num; i++) {
//            cur = last1 + last2;
//            last2 = last1;
//            last1 = cur;
//        }
//        return cur;
//    }
//    递归算"生兔子"
//    public static int fib(int num) {
//        if(num == 1 || num == 2) {
//            return 1;
//        }
//        return fib(num - 1) + fib(num - 2);
//    }
//    public static int sum(int num) {
//        if (num < 10) {
//            return num;
//        }
//        return num % 10 +sum(num / 10);
//    }
//    public static int sum(int num) {
//        if(num == 1) {
//            return 1;
//        }
//        return num + sum(num - 1);
//    }
//    public static void print(int num) {
//        if(num > 9) {
//            print(num / 10);
//        }
//        System.out.printf("%d ", num % 10);
//    }
//    public static int factor(int n) {
//        System.out.println("函数开始, n = " + n);
//        if (n == 1) {
//            System.out.println("函数结束, n = 1 ret = 1");
//            return 1;
//        }
//        int ret = n * factor(n - 1);
//        System.out.println("函数结束, n = " + n + "ret = " + ret);
//        return ret;
//    }
//public static void main(String[] args) {
//    int[] arr = {9, 5, 2, 7};
//    int[] output = transform(arr);
//    printArray(output);
//    for (int i = 0; i < 4; i++) {
//        System.out.println(arr[i]);
//    }
//    }
//    public static void printArray(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//    }
//    public static int[] transform(int[] arr) {
//    int[] ret = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            ret[i] = arr[i] * 2;
//        }
//        return ret;
//    }
//public static void main(String[] args) {
//    int[] arr = {9, 5, 2, 7};
//    transform(arr);
//    printArray(arr);
//    for (int i = 0; i < 4; i++) {
//        System.out.println(arr[i]);
//    }
//    }
//    public static void printArray(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//    }
//    public static void transform(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = arr[i] * 2;
//        }
//    }
public static void main(String[] args) {
//    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//    String newArr = Arrays.toString(arr);
//    System.out.println(newArr);
    int[] arr = {1, 2, 3, 4, 5, 6};
    System.out.println(toString(arr));
    }
    public static String toString(int[] arr) {
        String ret = "[";
        for (int i = 0; i < arr.length; i++) {
            ret += arr[i];
            if (i != arr.length - 1) {
                ret += ",";
            }
        }
        ret += "]";
        return ret;
    }
}
