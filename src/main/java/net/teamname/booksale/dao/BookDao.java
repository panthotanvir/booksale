package net.teamname.booksale.dao;

import net.teamname.booksale.domain.Book;

import java.util.List;

/**
 * Created by panthotanvir on 11/22/14.
 */
public interface BookDao {

    public void addBook(Book book);

    public  Book getBook(int bookId);

    public List<Book> getAllBookPost();
}
