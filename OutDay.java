package java_0720;

import java.util.Scanner;

public class OutDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            int Day = outDay(year, month, day);
            System.out.println(Day);
        }
    }

    private static int outDay(int year, int month, int day) {
        int[] Day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year <= 0 || month <= 0 || month > 12 || day <= 0 || day > Day[month - 1]) {
            return -1;
        }
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            Day[1] = 29;
        }
        int sum = 0;
        for (int i = 0; i < month - 1; i++) {
            sum += Day[i];
        }
        return sum + day;
    }
}
