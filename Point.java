package java_0701;

import java.util.Scanner;

public class Point {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] course = new int[n];
        int[] mark = new int[n];
        for (int i = 0; i < n; i++) {
            course[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            mark[i] = scanner.nextInt();
        }
        System.out.printf("%.2f", GPA(course, mark));
    }

    // 判断绩点
    public static double point(int mark) {
        double point = 0;
        if (mark >= 90 && mark <= 100) {
            point = 4.0;
        } else if (mark >= 85 && mark <= 89) {
            point = 3.7;
        } else if (mark >= 82 && mark <= 84) {
            point = 3.3;
        } else if (mark >= 78 && mark <= 81) {
            point = 3.0;
        } else if (mark >= 75 && mark <= 77) {
            point = 2.7;
        } else if (mark >= 72 && mark <= 74) {
            point = 2.3;
        } else if (mark >= 68 && mark <= 71) {
            point = 2.0;
        } else if (mark >= 64 && mark <= 67) {
            point = 1.5;
        } else if (mark >= 60 && mark <= 63) {
            point = 1.0;
        } else if (mark < 60) {
            point = 0;
        }
        return point;
    }

    public static double GPA(int[] course, int[] mark) { // 学分,每科分数
        // 所有学科绩点之和
        double total = 0;
        // 所有学科学分之和
        double sum = 0;
        for (int i = 0; i < course.length; i++) {
            total += point(mark[i]) * course[i];
            sum += course[i];
        }
        return total / sum;
    }
}
