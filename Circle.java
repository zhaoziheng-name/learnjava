package java_0710;

import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] s = str.split(" ");
            double[] d = new double[6];
            for (int i = 0; i < 6; i++) {
                d[i] = Double.parseDouble(s[i]);
            }
            double r = Math.pow(Math.pow(d[3] - d[0], 2) + Math.pow(d[4] - d[1], 2) + Math.pow(d[5] - d[2], 2), 0.5);
            double v = 4 * Math.acos(-1) * Math.pow(r, 3) / 3;
//            System.out.print("%.3f %.3f\n", r, v);
        }
    }
}
