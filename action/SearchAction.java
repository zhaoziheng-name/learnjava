package java_0310book.action;

import java_0310book.book.Book;
import java_0310book.book.BookList;

import java.util.Scanner;

public class SearchAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("执行查找图书操作");
        // 根据名字来查找对应的书籍信息
        System.out.println("请输入要查找的书的名字");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
            for (int i = 0; i < bookList.getSize(); i++) {
                Book book = bookList.getBook(i);
                if (book.getName().equals(name)) {
                    System.out.println(book);
                }
            }
    }
}
