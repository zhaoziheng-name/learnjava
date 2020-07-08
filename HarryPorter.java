package java_0708;

import java.util.Scanner;

public class HarryPorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.next();
            String str2 = scanner.next();
            String[] P = str1.split("\\.");
            String[] A = str2.split("\\.");
            int P1 = Integer.parseInt(P[0]) * 17 * 29 + Integer.parseInt(P[1]) * 29 + Integer.parseInt(P[2]);
            int A1 = Integer.parseInt(A[0]) * 17 * 29 + Integer.parseInt(A[1]) * 29 + Integer.parseInt(A[2]);
            int change = A1 - P1;
            if (change < 0) {
                System.out.println(-change);
            }
            int change1 = (change / 17) / 29;
            change -= change1 * 17 * 29;
            int change2 = change / 29;
            int change3 = change - change2 * 29;
            System.out.println(change1 + "." + change2 + "." + change3);
        }
    }
}
