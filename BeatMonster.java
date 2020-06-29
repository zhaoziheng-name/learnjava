package java_0629;

import java.util.Scanner;

public class BeatMonster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n  = scanner.nextInt();
            int z = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                if (z > arr[i]) {
                    z += arr[i];
                } else {
                    z += maxCommonNum(z, arr[i]);
                }
            }
            System.out.println(z);
        }
    }

    private static int maxCommonNum(int n, int z) {
        int max = 0;
        int smaller = n < z ? n : z;
        for (int i = 2; i <= smaller; i++) {
            if (n % i == 0 && z % i == 0) {
                max = i;
            }
        }
        return max;
    }
}
