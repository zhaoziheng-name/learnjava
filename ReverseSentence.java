package java_0717;

import java.util.Scanner;

public class ReverseSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        String n = "";
        for (int i = s.length - 1; i >= 0; i--) {
            n = n + s[i] + " ";
        }
        System.out.println(n);
    }
}
