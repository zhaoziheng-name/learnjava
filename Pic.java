package java_0714;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Pic {
    static List<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int way = scanner.nextInt();
            int len = scanner.nextInt();
            if (way == 1) {
                list.add(len);
            }
            if (way == 2 && list.size() > 1) {
                list.remove(searchIndex(len));
            }
            judge();
        }
    }

    private static void judge() {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        sum = sum - max;
        if (sum > max) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static int searchIndex(int len) {
        int i = 0;
        for (; i < list.size(); i++) {
            if (len == list.get(i)) {
                break;
            }
        }
        return i;
    }
}
