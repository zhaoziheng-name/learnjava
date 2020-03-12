package java_0310book;

import java_0310book.book.BookList;
import java_0310book.user.Admin;
import java_0310book.user.NormalUser;
import java_0310book.user.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. 先把数据准备好
        BookList bookList = new BookList();
        // 2. 创建用户并进行登陆
        User user = login();
        // 3. 进入主循环
        while (true) {
            // 4. 在循环内部先调用 Menu 方法来显示用户菜单
            int choice = user.menu();
            // 5. 根据用户输入的选项来决定执行哪个 IAction 完成操作
            user.doAction(choice, bookList);
        }
    }

    public static User login() {
        // 提示用户进行登陆
        Scanner scanner = new Scanner(System.in);
        System.out.println("请登陆系统!");
        System.out.println("请输入您的姓名: ");
        String name = scanner.next();
        System.out.println("请输入您的身份: 1 表示管理员, 2 表示普通用户");
        //System.out.println("欢迎" + name + );
        int who = scanner.nextInt();
        if (who == 1) {
            return new Admin(name);
        }
        return new NormalUser(name);
    }
}
