package java_0610;

import java.util.Scanner;

public class TheNumOf0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = factor(n);
        int count = 0;
        while (sum > 9) {
            if (sum % 10 == 0) {
                count++;
            }
            sum /= 10;
        }
        System.out.println(count);
    }

    private static int factor(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return n * factor(n - 1);
    }
}
