package java_0603;

import java.util.Scanner;

public class Cola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n < 0) {
                return;
            } else if (n == 0) {
                return;
            } else {
                System.out.println(n / 2);
            }
        }
    }
}
