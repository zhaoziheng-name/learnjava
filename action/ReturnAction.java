package java_0310book.action;

import java_0310book.book.Book;
import java_0310book.book.BookList;

import java.util.Scanner;

public class ReturnAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("执行还书操作");
        System.out.println("请输入你要还的书名:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                if (book.isBorrowed()) {
                    // 已经借出的书就可以还了
                    book.setBorrowed(false);
                    System.out.println("还书成功!");
                    return;
                }
            }
        }
        System.out.println("还书失败!");
    }
}
