package java_0310book.user;

import java_0310book.action.*;

import java.util.Scanner;

public class Admin extends User {
    public Admin(String name) {
        super(name);
        actions = new IAction[] {
                new ExitAction(),
                new SearchAction(),
                new AddAction(),
                new DelAction(),
                new DisplayAction(),
        };
    }

    @Override
    public int menu() {
        System.out.println("=========================");
        System.out.println("欢迎" + this.name + "使用图书馆管理系统, 您是管理员");
        System.out.println("1. 查找图书");
        System.out.println("2. 新增图书");
        System.out.println("3. 删除图书");
        System.out.println("4. 显示所有图书");
        System.out.println("0. 退出");
        System.out.println("=========================");
        System.out.println("请输入您的选择: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
