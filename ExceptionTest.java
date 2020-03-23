package java_0322;

import com.sun.deploy.security.SandboxSecurity;

import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {
//        try {
//            String str = null;
//            System.out.println(str.length());
//            System.out.println("执行完 str.length()");
//        } catch(NullPointerException e) {
//            // 常用的异常处理方式,打印出现异常代码的调用栈
//            e.printStackTrace();
//            try {
//                String str2 = null;
//                System.out.println(str2.length());
//            } catch(NullPointerException e1) {
//                System.out.println("再次触发空指针异常");
//            }
//        }
//        System.out.println("我是一行日志");

//        try {
//            func1();
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }

//        try {
//            int[] arr = {1, 2, 3};
//            //System.out.println(arr[100]);
//
//            String str = null;
//            System.out.println(str.length());
//        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
//            System.out.println("捕捉到异常啦");
//        } finally {
//            System.out.println("这是 finally 中的语句");
//        }
//        System.out.println("我是一行日志");

        //System.out.println(func3());

        // 这个代码中当 try catch 执行完的时候,就会自动执行 try ( ) 中对象的close
        // try ( ) 中的对象, 必须要实现 closeable 接口
        try (Scanner scanner = new Scanner(System.in)) {
            int num = scanner.nextInt();
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void func1() {
        func2();
    }

    public static void func2() {
        String str = null;
        System.out.println(str.length());
    }

    public static int func3() {
        try {
            return  1;
        } catch (NullPointerException e) {
            return 2;
        } finally {
            return 3;
        }
    }
}
