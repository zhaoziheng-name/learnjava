package java_0719;

import java.util.Scanner;

public class TheDayOfYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            // 输入年月日
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            // 调用方法
            System.out.println(iConverDateToDay(year, month, day));
        }
    }

    public static int iConverDateToDay(int year, int month, int day) {
        if (month < 1 || month > 12) {
            return -1;
        }
        if (day < 1 || day > 31) {
            return -1;
        }
        int days = 0;
        // 把除了这个月的天数都加起来
        for (int m = 1; m < month; m++) {
            days += getMonthDays(year, m);
        }
        // 再把这个月的天数加起来
        days += day;
        return days;
    }

    public static int getMonthDays(int year, int month) {
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            // 判断闰年还是平年
            case 2:
                if (LeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
        }
        return -1;
    }

    public static boolean LeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }
}