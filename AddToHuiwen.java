package java_0716;

import java.util.Scanner;

public class AddToHuiwen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int i = 0;
            int j = str.length() - 1;
            int flag = 0;
            while (i <= j) {
                if (str.charAt(i) != str.charAt(j)) {
                    if (str.charAt(i) == str.charAt(j - 1) && i <= j - 1) {
                        flag++;
                        j--;
                    } else if (str.charAt(i + 1) == str.charAt(j) && i + 1 <= j) {
                        flag++;
                        i++;
                    } else {
                        flag += 2;
                        break;
                    }
                } else {
                    i++;
                    j--;
                }
            }
            if (flag < 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
