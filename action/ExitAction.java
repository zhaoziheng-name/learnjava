package java_0310book.action;

import java_0310book.book.BookList;

public class ExitAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("goodbye!");
        System.exit(0);
    }
}
