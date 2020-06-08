package java_0608;

import java.util.Scanner;

public class Candy {
    public static void main(String[] args) {
        int A, B, C, D;
        float x, y, z;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            A = scanner.nextInt();
            B = scanner.nextInt();
            C = scanner.nextInt();
            D = scanner.nextInt();
            x = (A + C) / 2;
            y = (C - A) / 2;
            z = (D - B) / 2;
            if (x - y != A) {
                System.out.println("No");
                return;
            }
            if (y  - z != B) {
                System.out.println("No");
                return;
            }
            if (x + y != C) {
                System.out.println("No");
                return;
            }
            if (y + z != D) {
                System.out.println("No");
                return;
            }
            System.out.print((int)x + " " + (int)y + " " + (int)z + " ");
        }
    }
}
