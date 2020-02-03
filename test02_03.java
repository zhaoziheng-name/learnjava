import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.Random;
import java.util.Scanner;

public class test02_03 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        double sum = 0.0;
//        int num = 0;
//        while (sc.hasNextDouble()) {
//            double tmp = sc.nextDouble();
//            sum += tmp;
//            num++;
//        }
//        System.out.println("sum = " + sum);
//        System.out.println("avg = " + sum / num);
//        sc.close();
//        Random random = new Random();
//        Scanner sc = new Scanner(System.in);
//        int toGuess = random.nextInt(100);
//        while (true) {
//            System.out.println("请输入要猜的数字: (1-100)");
//            int num = sc.nextInt();
//            if(num < toGuess) {
//                System.out.println("猜小了!");
//            } else if (num > toGuess) {
//                System.out.println("猜大了!");
//            } else {
//                System.out.println("恭喜你,猜对了!");
//                break;
//            }
//        }
//        sc.close();
//        int sum = 0;
//        for (int i = 1; i <= 5; i++) {
//            sum += factor(i);
//        }
//        System.out.println("sum = " + sum);
//        无法正常交换
//        int a = 10;
//        int b = 20;
//        swap(a,b);
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
//        int[] arr ={10, 20};
//        swap(arr);
//        System.out.println("a = " + arr[0]);
//        System.out.println("b = " + arr[1]);
//        int a = 10;
//        int b = 20;
//        int ret = add(a, b);
//        System.out.println("ret = " + ret);
//
//        double a2 = 10.5;
//        double b2 = 20.5;
//        double ret2 = add(a2, b2);
//        System.out.println("ret2 = " + ret2);
//
//        double a3 = 10.5;
//        double b3 = 20.5;
//        double c3 = 30.5;
//        double ret3 = add(a3, b3, c3);
//        System.out.println("ret3 = " + ret3);
        int n = 5;
        int ret = factor(5);
        System.out.println("ret = " + ret);
    }
    public static int factor(int n) {
        if(n == 1) {
            return 1;
        }
        return n * factor(n - 1);
    }
//    public static int factor(int n) {
//        System.out.println("计算n的阶乘中! n = " + n);
//        int result = 1;
//        for (int i = 1; i <= n; i++) {
//            result *= i;
//        }
//        return result;
//    }
//  形参无法改变实参的值
//    public static void swap(int x, int y) {
//        int tmp = x;
//        x = y;
//        y = tmp;
//    }
//    public static void swap(int[] arr) {
//        int tmp = arr[0];
//        arr[0] = arr[1];
//        arr[1] = tmp;
//    }
//    public static int add(int x, int y) {
//        return x + y;
//    }
//    public static double add(double x, double y) {
//        return x + y;
//    }
//    public static double add(double x, double y, double z) {
//        return x + y + z;
//    }
}
