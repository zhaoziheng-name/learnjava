package java_0917;

import java.util.ArrayList;
import java.util.Scanner;

public class GetYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].charAt(0) >= '1' && s[i].charAt(0) <= '3') {
                list.add(s[i]);
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).length() == 4) {
                System.out.print(list.get(i).substring(0, 4) + " ");
            }
        }
        System.out.print(list.get(list.size() - 1).substring(0, 4));
    }
}
