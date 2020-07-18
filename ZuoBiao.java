package java_0718;

import java.util.Scanner;

public class ZuoBiao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(";");
        int x = 0;
        int y = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].charAt(0) == 'A' && s[i].substring(1).matches("[0-9]+")) {
                x -= Integer.parseInt(s[i].substring(1));
            }

            if (s[i].charAt(0) == 'D' && s[i].substring(1).matches("[0-9]+")) {
                x += Integer.parseInt(s[i].substring(1));
            }
            if (s[i].charAt(0) == 'S' && s[i].substring(1).matches("[0-9]+")) {
                y -= Integer.parseInt(s[i].substring(1));
            }
            if (s[i].charAt(0) == 'W' && s[i].substring(1).matches("[0-9]+")) {
                y += Integer.parseInt(s[i].substring(1));
            }
        }
        System.out.println(x + "," + y);
    }

//    private static boolean correctInput(String s) {
//        int n = s.length();
//        if (n <= 3 && n > 1) {
//            if (s.charAt(0) == 'A' || s.charAt(0) == 'D'|| s.charAt(0) == 'W' || s.charAt(0) == 'S') {
//                if (n == 2 && Character.isDigit(s.charAt(1))) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
