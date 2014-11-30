package net.level0.booksale.service;

import net.level0.booksale.domain.Book;
import net.level0.booksale.domain.Detail;

import java.util.List;

/**
 * Created by panthotanvir on 11/22/14.
 */
public interface BookService {

    public void addBook(Book book);

    public Detail getBook(int bookId);

    public List<Book> getAllBookPost();

    public List<Book> getBookList(int userId);

    public List<Book> searchTitleBookList(String title);

    public List<Book> getDeptBook(Integer deptId);

    public List<Book> searchAuthorBookList(String authorName);

    public List<Book> searchPublisherBookList(String publisherName);

    public  List<Book> getRequestBook(Integer userID);

    public List<Book> getAllRequest(Integer userId);


}
