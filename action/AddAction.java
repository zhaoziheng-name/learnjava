package java_0310book.action;

import java_0310book.book.Book;
import java_0310book.book.BookList;

import java.util.Scanner;

public class AddAction implements IAction {
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("新增图书");
        System.out.println("请输入书名:");
        String name = scanner.next();
        System.out.println("请输入作者:");
        String author = scanner.next();
        System.out.println("请输入价格:");
        int price = scanner.nextInt();
        System.out.println("请输入书的类型:");
        String type = scanner.next();
        System.out.println("新增图书成功!");
        // 借出状态默认为未借出
        Book book = new Book(name, author, price, type, false);
        // 把这个 book 对象尾插到 bookList 中即可
        int size = bookList.getSize();
        bookList.setBook(size, book);
        bookList.setSize(size + 1);
    }
}
