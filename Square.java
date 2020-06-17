package java_0617;

import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 0;
        while (scanner.hasNext()) {
            N = scanner.nextInt();
            String str = scanner.next();
            char c = str.charAt(0);
            for (int i = 0; i < (N + 1) / 2; i++) {
                if (i == 0 || i == (N + 1) / 2 - 1) {
                    for (int j = 0; j < N; j++) {
                        System.out.print(c);
                    }
                    System.out.println();
                } else {
                    for (int j = 0; j < N; j++) {
                        if (j == 0 || j == N - 1) {
                            System.out.print(c);
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
}
