package java_0702;

import java.util.Scanner;

public class SearchIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int res = scanner.nextInt();
            System.out.println(search(arr, res));
        }
    }

    private static int search(int[] arr, int res) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == res) {
                return i;
            }
        }
        return -1;
    }
}
