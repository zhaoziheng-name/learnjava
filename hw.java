package java_0214;

import java.util.Scanner;

public class hw {
    public static void main(String[] args) {
        // 出错
        String s;
        System.out.println("s = " + s);
        System.out.println("\\\"hello\\\"");
        short a = 128;
        byte b = (byte) a;
        System.out.println(a);
        System.out.println(b);
        double x = 2.0;
        int y = 4;
        x /= ++y;
        System.out.println(x);
        byte b1 = 10;
        byte b2 = 12;
        b2 = b1 + b2; // 报错
        b2 += b1;     // 不报错
        Scanner in = new Scanner(System.in);
        System.out.println("请输入您想查询的年龄: ");
        int age = in.nextInt();
        if(age <= 18) {
            System.out.println("少年");
        } else if(age > 18 && age <= 28) {
            System.out.println("青年");
        } else if(age > 28 && age <= 55 ) {
            System.out.println("中年");
        } else {
            System.out.println("老年");
        }
        System.out.println(new Test());
    }
}
class Test{
    // 输出 aaabbb
    public String toString() {
        System.out.print("aaa");
        return "bbb";
    }
}
