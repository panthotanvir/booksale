package net.level0.booksale.service;

import net.level0.booksale.dao.BookDao;
import net.level0.booksale.dao.BookDaoImp;
import net.level0.booksale.domain.Book;
import net.level0.booksale.domain.Detail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by panthotanvir on 11/22/14.
 */
public class BookServiceImp implements BookService {
    private static final Logger log = LoggerFactory.getLogger(BookServiceImp.class);

    private BookDao bookDao = null;

    public BookServiceImp(){
        this.bookDao = new BookDaoImp();
    }

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
        log.debug("addbook called in BookserviceImp");
    }

    @Override
    public Detail getBook(int bookId) {
        return bookDao.getBook(bookId);
    }

    @Override
    public List<Book> getAllBookPost(){

        return  bookDao.getAllBookPost();
    }

    @Override
    public List<Book> getBookList(int userId) {
        return  bookDao.getBookList(userId);
    }

    @Override
    public List<Book> searchTitleBookList(String title) {
        return bookDao.searchTitleBookList(title);
    }


    public List<Book> getDeptBook(Integer deptId) {
        return  bookDao.getDeptBook(deptId);
    }

    @Override
    public List<Book> getRecommenededBook(Integer deptId, Integer bookId) { return bookDao.getRecommenedBook(deptId,bookId);}

    @Override
    public List<Book> searchAuthorBookList(String authorName) {
        return bookDao.searchAuthorBookList(authorName);
    }

    @Override
    public List<Book> searchAllBookList(String name) {
        return bookDao.searchAllBookList(name);
    }

    @Override
    public List<Book> searchPublisherBookList(String publisherName) {
        return bookDao.searchPublisherBookList(publisherName);
    }

    @Override
    public List<Book> getRequestBook(Integer userID) {
        return bookDao.getRequestBook(userID);
    }

    @Override
    public List<Book> getAllRequest(Integer userId) {
        return bookDao.getAllRequest(userId);
    }

    @Override
    public List<Book> getUniDeptBookList(int uniId, int deptId) {
        return bookDao.getUniDeptBookList(uniId, deptId);
    }

    @Override
    public void requestBook(Book book) {
         bookDao.requestBook(book);
    }

    @Override
    public void deleteBook(Book book, String flag) {
        if(flag.equals("4")){
            log.debug("Deletebook in BookServiceImp flag 4");
            bookDao.deleteBook(book);
        }
    }

    @Override
    public List<Book> getDivisionBook(Integer divisionId) {return bookDao.getDivisionBook(divisionId);}

    @Override
    public void exchangeBook(Book book) {
        bookDao.exchangeBook(book);
    }

    @Override
    public List<Book> getExchangeBook(Integer userId) {
        return bookDao.getExchangeList(userId);
    }

    @Override
    public void deleteExchange(Integer exchangeId) {
        bookDao.deleteExchange(exchangeId);
    }

    @Override
    public void deleteRequest(Integer requestId) {
        bookDao.deleteRequest(requestId);
    }

    @Override
    public List<Book> getUniBookList(int uniType) {
        return bookDao.getUniBookList(uniType);
    }

}
