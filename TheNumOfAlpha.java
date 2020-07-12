package java_0712;

import java.util.Scanner;

public class TheNumOfAlpha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            char[] c = str.toCharArray();
            int[] arr = new int[26];
            for (int i = 0; i < c.length; i++) {
                if (c[i] >= 'A' && c[i] <= 'Z') {
                    arr[c[i] - 'A']++;
                }
            }
            for (int i = 0; i < 26; i++) {
                System.out.println((char) ('A' + i) + ":" + arr[i]);
            }
            break;
        }
    }
}
