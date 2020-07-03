package java_0703;

import java.util.Scanner;

public class SXNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = n * n;
            if (n < 10) {
                if (m - n % 10 == 0) {
                    System.out.println("YES!");
                } else {
                    System.out.println("NO!");
                }
            } else {
                if (m - n % 100 == 0) {
                    System.out.println("YES!");
                } else {
                    System.out.println("NO!");
                }
            }
        }
    }
}
