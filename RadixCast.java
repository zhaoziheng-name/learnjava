package java_0712;

import java.util.Scanner;

public class RadixCast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next().substring(2);
            int n = Integer.parseInt(s,16);
            System.out.println(n);
        }
    }
}
