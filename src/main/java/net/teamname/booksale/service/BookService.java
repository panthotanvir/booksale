package net.teamname.booksale.service;

import net.teamname.booksale.domain.Book;
import net.teamname.booksale.domain.Detail;

import java.util.List;

/**
 * Created by panthotanvir on 11/22/14.
 */
public interface BookService {

    public void addBook(Book book);

    public Detail getBook(int bookId);

    public List<Book> getAllBookPost();

    public List<Book>  getBookList(Integer userId);

    public List<Book> getBookList(String authorName);
}
