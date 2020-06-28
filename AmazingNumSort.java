package java_0628;

import java.util.Scanner;

public class AmazingNumSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int A1 = 0, A2 = 0, A3 = 0, A5 = 0, t = 0, c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0;
        double A4 = 0;
        int sum = 0, b = 0;
        int max = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {
            arr [i] = scanner.nextInt();
            if (arr[i] % 5 == 0 && arr[i] % 2 ==0) {
                A1 = A1 + arr[i];
                c1++;
            } else if (arr[i] % 5 == 1) {
                c2++;
                if (count % 2 == 1) {
                    arr[i] = arr[i];
                } else {
                    arr[i] = (-1) * arr[i];
                }
                A2 = A2 + arr[i];
                count++;
            } else if (arr[i] % 5 == 2) {
                c3++;
                A3++;
            } else if (arr[i] % 5 == 3) {
                c4++;
                b++;
                sum += arr[i];
            } else if (arr[i] % 5 == 4) {
                c5++;
                if (max < arr[i]) {
                    t = max;
                    max = arr[i];
                    arr[i] = t;
                }
            }
        }
        A5 = max;
        if (c1 == 0) {
            System.out.print("N" + " ");
        }
        if (c1 != 0) {
            System.out.print(A1 + " ");
        }
        if (c2== 0) {
            System.out.print("N" + " ");
        }
        if (c2 != 0) {
            System.out.print(A2 + " ");
        }
        if (c3 == 0) {
            System.out.print("N" + " ");
        }
        if (c3 != 0) {
            System.out.print(A3 + " ");
        }
        if (c4 == 0) {
            System.out.print("N" + " ");
        }
        if (c4 != 0) {
            A4 = (float)sum / b;
            System.out.printf("%.1f" + " " + A4);
        }
        if (c5 == 0) {
            System.out.print("N");
        }
        if (c5 != 0) {
            System.out.print(A5);
        }
    }
}
