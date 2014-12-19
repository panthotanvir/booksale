package net.level0.booksale.dao;

import net.level0.booksale.domain.Book;
import net.level0.booksale.domain.Detail;

import java.util.List;

/**
 * Created by panthotanvir on 11/22/14.
 */
public interface BookDao {

    public void addBook(Book book);

    public Detail getBook(int bookId);

    public List<Book> getAllBookPost();

    public List<Book> getLatestBookPost();

    public List<Book> getBookList( int userId);

    public List<Book> getDeptBook( Integer deptId);

    public List<Book> getRecommenedBook(Integer deptId,Integer bookId);

    public List<Book> searchTitleBookList( String title );

    public List<Book> searchAuthorBookList( String authorName );

    public List<Book> searchPublisherBookList( String publisherName );

    public List<Book> searchAllBookList( String name );

    public List<Book> getRequestBook(Integer userID);

    public List<Book> getAllRequest(Integer userId);

    public List<Book> getUniDeptBookList(int uniId, int deptId);

    public  void requestBook(Book book);

    public void deleteBook(Book book);

    public List<Book> getDivisionBook(Integer divisionId);

    public void exchangeBook(Book book);

    public List<Book> getExchangeList(Integer userId);

    public List<Book> getUniBookList(int uniType);

    public List<Detail> getExchangeList();

    public void deleteExchange(Integer exchangeId);

    public  void deleteRequest(Integer requestId);

    public List<Book> getRatedUserBook();
}
