package java_0610;

import java.util.Scanner;

public class NiXuNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = "";
        while (n != 0) {
            int t1 = n % 10;
            int t2 = n / 10;
            str = str + String.valueOf(t1);
            n = t2;
        }
        System.out.println(str);
    }
}
