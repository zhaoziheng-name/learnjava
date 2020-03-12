package java_0310book.user;

import java_0310book.action.IAction;
import java_0310book.book.BookList;

// User 不需要创建实例, 需要创建的是 NormalUser 和 Admin
abstract public class User {
    protected String name;
    // 当前用户都支持哪些操作
    protected IAction[] actions;

    public User(String name) {
        this.name = name;
    }

    // 打印一个命令行的菜单
    // 用于普通用户和管理员支持的操作不同,交互的菜单也存在差异
    // 就需要在普通用户和管理员中分别实现各自的菜单方法
    abstract public int menu();

    // 还需要一个公共的每种用户都需要要的方法
    public void doAction(int choice, BookList bookList) {
        // choice 就是用户通过命令行菜单来输入的选项
        // 根据输入的选项, 在数组中选择合适的对象来进行操作
        actions[choice].work(bookList);
    }
}
