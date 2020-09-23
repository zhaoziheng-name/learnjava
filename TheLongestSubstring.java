package java_0923;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TheLongestSubstring {
    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if (s == null || s.length() < 1) {
            return;
        }
        char[] c = s.toCharArray();
        int size = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = i; j < c.length; j++) {
                if (set.contains(c[j])) {
                    break;
                }
                set.add(c[j]);
            }
        }
        if (set.size() > size) {
            for (int i = 0; i < set.size(); i++) {
                System.out.println();
            }
        } else {
            System.out.println(" ");
        }
    }
}
