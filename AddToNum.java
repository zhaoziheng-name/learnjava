package java_0821;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        int abc = 0;
        int acc = 0;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                for (int c = 0; c < 10; c++) {
                    abc = a * 100 + b * 10 + c;
                    acc = a * 100 + c * 11;
                    if (a != b && b != c && a != c && abc + acc == n) {
                        count++;
                        list1.add(abc);
                        list2.add(acc);
                    }
                }
            }
        }
        if (count == 0) {
            System.out.println(count);
        } else {
            System.out.println(count);
            for (int i = 0; i < count; i++) {
                System.out.println(list1.get(i) + " " + list2.get(i));
            }
        }
    }
}
