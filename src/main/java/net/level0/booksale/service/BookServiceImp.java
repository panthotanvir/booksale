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
        log.debug("addbook called in BookserviceImp");
        bookDao.addBook(book);

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
    public List<Book> getBookList(Integer userId) {
        return  bookDao.getBookList(userId);
    }

    @Override
    public List<Book> searchTitleBookList(String title) {
        return bookDao.searchTitleBookList(title);
    }

    @Override

    public List<Book> getBookList(String authorName) {
        return bookDao.getBookList(authorName);
    }

    public List<Book> getDeptBook(Integer deptId) {
        return  bookDao.getDeptBook(deptId);
    }

}
