package java_0627;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BuyThings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str1.length(); i++) {
                int length = map.getOrDefault(str1.charAt(i), 0);
                map.put(str1.charAt(i), length + 1);
            }
            int count = 0;
            for (int j = 0; j < str2.length(); j++) {
                int len = map.getOrDefault(str2.charAt(j), 0);
                if (len <= 0) {
                    count++;
                }
                map.put(str2.charAt(j), len - 1);
            }
            if (count == 0) {
                System.out.println("yes" + " " + (str1.length() - str2.length()));
            } else {
                System.out.println("no" + " " + count);
            }
        }
        scanner.close();
    }
}
