package java_0310book.action;

import java_0310book.book.Book;
import java_0310book.book.BookList;

import java.util.Scanner;

public class BorrowAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("执行借书操作");
        System.out.println("请输入你要借书的书名");
        Scanner scanner = new Scanner(System.in);
        String name =  scanner.next();
        // 找到书,把书的状态改成 "借出" 即可
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                if (book.isBorrowed()) {
                    continue;
                } else {
                    book.setBorrowed(true);
                    System.out.println("借书成功");
                    return;
                }
            }
        }
        // 书名不存在 / 书存在,但是被借走了
        System.out.println("借书失败,没有匹配的书籍!");
    }
}
