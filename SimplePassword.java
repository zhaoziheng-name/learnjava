package java_0626;

import java.util.Scanner;

public class SimplePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] b = str.toCharArray();
            for (int i = 0; i < b.length; i++) {
                char c = b[i];
                if (c - 'A' >= 0) {
                    c = (char) (c > 'E' ? (c - 5) : (c + 21));
                    b[i] = c;
                }
            }
            System.out.println(new String(b));
        }
    }
}
