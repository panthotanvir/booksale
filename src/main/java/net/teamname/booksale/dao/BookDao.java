package net.teamname.booksale.dao;

import net.teamname.booksale.domain.Book;
import net.teamname.booksale.domain.SingleBook;

import java.util.List;

/**
 * Created by panthotanvir on 11/22/14.
 */
public interface BookDao {

    public void addBook(Book book);

    public SingleBook getBook(int bookId);

    public List<Book> getAllBookPost();
}
