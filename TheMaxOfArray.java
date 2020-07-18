package java_0718;

import java.util.Scanner;

public class TheMaxOfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int sum = arr[0];
            int tmp = arr[0];
            for (int i = 0; i < n; i++) {
                if (tmp < 0) {
                    tmp = 0;
                }
                tmp += arr[i];
                if (tmp > sum) {
                    sum = tmp;
                }
            }
            System.out.println(sum);
        }
    }
}
