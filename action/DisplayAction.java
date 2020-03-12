package java_0310book.action;

import java_0310book.book.Book;
import java_0310book.book.BookList;

public class DisplayAction implements IAction {
    @Override
    public void work(BookList bookList) {
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
    }
}
