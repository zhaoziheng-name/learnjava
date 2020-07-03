package java_0703;

import java.util.Scanner;

public class passwordCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String password = scanner.nextLine();
            System.out.println(check(password));
        }
    }

    private static String check(String str) {
        String result = "NG";
        int upperCase = 0;
        int lowerCase = 0;
        int num = 0;
        int sign = 0;
        // 判断密码长度
        if (str != null && str.length() > 8) {
            // 判断字符有几种
            for (Character ch : str.toCharArray()) {
                if (ch >= 'a' && ch <= 'z') {
                    lowerCase = 1;
                } else if (ch >= 'A' && ch <= 'Z') {
                    upperCase = 1;
                } else if (ch >= '0' && ch <= '9') {
                    num = 1;
                } else {
                    sign = 1;
                }
            }
            if (lowerCase + upperCase + num + sign > 2) {
                // 判断有没有重复长度超过 2 的
                if (repeatWord(str)) {
                    result = "OK";
                }
            }
        }
        return result;
    }

    private static boolean repeatWord(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length() - 2; j++) {
                if (str.substring(j).contains(str.substring(i, i + 3))) {
                    // 有重复的
                    return false;
                }
            }
        }
        // 没有重复的
        return true;
    }
}
