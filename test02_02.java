import java.util.Scanner;
public class test02_02 {
    public static void main(String[] args) {
//        int num = 10;
//        if(num % 2 == 0) {
//            System.out.println("偶数");
//        } else {
//            System.out.println("奇数");
//        }
//        int year = 1900;
//        if(year % 100 == 0) {
//            if (year % 400 == 0) {
//                System.out.println("闰年");
//            } else {
//                System.out.println("平年");
//            }
//        } else {
//            if(year % 4 == 0) {
//                System.out.println("闰年");
//            } else {
//                System.out.println("平年");
//            }
//        }
//        int day = 1;
//        switch (day) {
//            case 1:
//                System.out.println("monday");
//                break;
//            case 2:
//                System.out.println("tuesday");
//                break;
//            case 3:
//                System.out.println("wednesday");
//                break;
//            case 4:
//                System.out.println("thursday");
//                break;
//            case 5:
//                System.out.println("friday");
//                break;
//            case 6:
//                System.out.println("saturday");
//                break;
//            case 7:
//                System.out.println("sunday");
//                break;
//            default:
//                System.out.println("输入有误");
//                break;
//        }
//        int num = 1;
//        int result = 0;
//        while(num <= 100) {
//            result += num;
//            num++;
//        }
//        System.out.println(result);
//        int num = 1;
//        int result = 1;
//        int sum = 0;
//        while(num <= 5) {
//            result *= num;
//            num++;
//            sum += result;
//        }
//        System.out.println(sum);
//        int num = 100;
//        while (num <= 200) {
//            if (num % 3 != 0) {
//                num++;
//                continue;
//            }
//            System.out.println(num);
//            num++;
//        }
//        int sum = 0;
//        for (int i = 1; i <= 5; i++) {
//            int tmp = 1;
//            for (int j = 1; j <= i; j++) {
//                tmp *= j;
//            }
//            sum += tmp;
//        }
//        System.out.println(sum);
//        int num = 1;
//        do {
//            System.out.println(num);
//            num++;
//        } while (num <= 10);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的名字: ");
        String name = sc.nextLine();
        System.out.println("请输入你的年龄: ");
        int age = sc.nextInt();
        System.out.println("请输入你的工资: ");
        float salary = sc.nextFloat();
        System.out.println("你的信息如下: ");
        System.out.println("姓名: " + name + "\n" + "年龄: " + age + "\n" + "工资: " + salary + "\n");
        sc.close();
    }
}
