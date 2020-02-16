package hw;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Count();
        year();
        printPrime();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数: ");
        int num = scanner.nextInt();
        if(isPrime(num) == true) {
            System.out.println("是素数");
        } else {
            System.out.println("不是素数");
        }
    }

    public static void Count() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if(i % 10 == 9) {
                count++;
            }
            if (i / 10 % 10 == 9) {
                count++;
            }
        }
        System.out.println("出现9的次数为: " + count);
    }

    public static void year() {
        for (int i = 1000; i < 2001; i++) {
            if(i % 400 == 0 || i % 4 == 0 && i % 100 != 0) {
                System.out.println(i);
            }
        }
    }

    public static void printPrime() {
        int i = 0;
        int j = 0;
        for (i = 1; i < 100; i++) {
            for (j = 2; j < i; j++) {
                if(i % j == 0) {
                    break;
                }
            }
            if(j == i) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int a) {
        if(a < 2) {
            return false;
        } else {
            for (int i = 2; i < a; i++) {
                if(a % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}