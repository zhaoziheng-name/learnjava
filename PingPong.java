package java_0722;

import java.util.Scanner;

public class PingPong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String A = scanner.next();
            String B = scanner.next();
            int[] arrA = new int[26];
            int[] arrB = new int[26];
            for (int i = 0; i < A.length(); i++) {
                arrA[A.charAt(i) - 'A']++;
            }
            for (int i = 0; i < B.length(); i++) {
                arrB[B.charAt(i) - 'A']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (arrA[i] < arrB[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
