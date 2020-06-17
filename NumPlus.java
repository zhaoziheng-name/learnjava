package java_0617;

import java.util.Scanner;

public class NumPlus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int ret = n * n * n;
            int mid = n * n;
            StringBuffer stringBuffer = new StringBuffer();
            int beg = mid + 1 - n;
            int end = mid - 1 + n;
            for (; beg <= end; beg += 2) {
                if (beg == end) {
                    stringBuffer.append(beg);
                    break;
                }
                stringBuffer.append(beg + "+");
            }
            System.out.println(stringBuffer.toString());
        }
    }
}
