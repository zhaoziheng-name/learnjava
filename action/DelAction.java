package java_0310book.action;

import java_0310book.book.Book;
import java_0310book.book.BookList;

import java.util.Scanner;

public class DelAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的书名:");
        String name = scanner.next();
        // 先找到对应书名的位置
        int i  =0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                break;
            }
        }
        if (i >= bookList.getSize()) {
            System.out.println("删除失败! 没有匹配的书名");
            return;
        }
        // 循环结束, i 对应的值就是要删除图书的下标
        int size = bookList.getSize();
        bookList.setBook(i, bookList.getBook(size - 1));
        bookList.setSize(size - 1);
    }
}
