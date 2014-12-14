package net.level0.booksale.service;

import net.level0.booksale.domain.Book;
import net.level0.booksale.domain.Detail;
import net.level0.booksale.domain.User;

import java.util.List;

/**
 * Created by panthotanvir on 11/22/14.
 */
public interface BookService {

    public void addBook(Book book);

    public Detail getBook(int bookId);

    public List<Book> getAllBookPost();

    public List<Book> getLatestBookPost();

    public List<Book> getBookList(int userId);

    public List<Book> searchTitleBookList(String title);

    public List<Book> getDeptBook(Integer deptId);

    public List<Book> getRecommenededBook(Integer deptId,Integer bookId);

    public List<Book> searchAuthorBookList(String authorName);

    public List<Book> searchAllBookList(String name);

    public List<Book> searchPublisherBookList(String publisherName);

    public  List<Book> getRequestBook(Integer userID);

    public List<Book> getAllRequest(Integer userId);

    public List<Book> getUniDeptBookList(int uniId, int deptId);

    public void requestBook(Book book);

    public void deleteBook(Book book, String flag);

    public List<Book> getDivisionBook(Integer divisionId);

    public void exchangeBook(Book book);

    public List<Book> getExchangeBook(Integer userId);

    public void deleteExchange(Integer exchangeId);

    public void deleteRequest(Integer requestId);

    public List<Book> getUniBookList(int uniType);

    public List<Detail> getExchangeList();

}
