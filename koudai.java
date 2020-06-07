package java_0607;

import java.util.Scanner;

public class koudai {
    static int[] weight;
    static int count;
    static int N;
    public static void fangfa(int s, int n) {
        if (s == 0) {
            count++;
            return;
        }
        if (s < 0 || (s > 0 && n < 1)) {
            return;
        }
        fangfa(s - weight[n], n - 1);
        fangfa(s, n - 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            N = scanner.nextInt();
            weight = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                weight[i] = scanner.nextInt();
            }
            fangfa(40, N);
            System.out.println(count);
        }
    }
}
