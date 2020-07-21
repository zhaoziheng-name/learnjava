package java_0721;

import java.util.Scanner;

public class PrintName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
        System.out.println(printName(str1));
        System.out.println(printName(str2));
    }

    public static String printName(String str) {
        String[] s = str.split("_");
        String S = s[0];
        for (int i = 1; i < s.length; i++) {
            S += s[i].substring(0, 1).toUpperCase() + s[i].substring(1);
        }
        return S;
    }
}
