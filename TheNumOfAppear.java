package java_0608;

import java.util.Scanner;

public class TheNumOfAppear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[100];
        int count = 0;
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            arr[n]++;
            count++;
        }
        for (int i = 0; i < count; i++) {
            if (arr[i] >= count / 2) {
                System.out.println(i);
            }
        }
    }
}
