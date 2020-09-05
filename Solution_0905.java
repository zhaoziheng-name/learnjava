package java_0905;

import java.util.Scanner;

public class Solution_0905 {
    public static int numberOfPrize (int a, int b, int c) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
//            a = scanner.nextInt();
//            b = scanner.nextInt();
//            c = scanner.nextInt();
            String str = scanner.next();
            String[] s = new String[3];
            s = str.split(",");
            a = s[0].charAt(0) - 48;
            b = s[1].charAt(0) - 48;
            c = s[2].charAt(0) - 48;
            // 找到三个中的最小值, 就是最少能换的个数
            int min = Min(a, b, c);
            sum = min;
            a -= sum;
            b -= sum;
            c -= sum;
            // 三个都剩 0 个的情况
            if (a == 0 && b == 0 && c == 0) {
                return sum;
                // a, b 用完了, c 没用完
            } else if (a == 0 && b == 0 && c != 0) {
                sum += c / 5;
                // a, c 用完了, b 没用完
            } else if (a == 0 && c == 0 && b != 0) {
                sum += b / 5;
                // b, c 用完了, a 没用完
            } else if (a != 0 && b == 0 && c == 0) {
                sum += a / 5;
                // a 用完了, b, c 没用完
            } else if (a == 0 && b != 0 && c != 0) {
                sum += (b + c) / 4;
                // b 用完了, a, c 没用完
            } else if (b == 0 && a != 0 && c != 0) {
                sum += (a + c) / 4;
                // c 用完了, a, b 没用完
            } else if (c == 0 && a != 0 && b != 0) {
                sum += (a + b) / 4;
            }
        return sum;
    }

    private static int Min(int a, int b, int c) {
        int tmp = a < b ? a : b;
        int min = tmp < c ? tmp : c;
        return min;
    }

    public static void main(String[] args) {
        int a = 4, b = 4, c = 2;
        System.out.println(Min(a, b, c));
        numberOfPrize(a, b, c);
    }
}
