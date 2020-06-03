package java_0603;

import java.util.Scanner;

public class TheLongestNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxLength = 0;
        int count = 0;
        int end = 0;
        String s = null;
            s = scanner.next();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    count++;
                    if (count > maxLength) {
                        end = i;
                        maxLength = count;
                    }
                } else {
                    count = 0;
                }
            }
        System.out.println(s.substring(end - maxLength + 1, end + 1));
    }
}
