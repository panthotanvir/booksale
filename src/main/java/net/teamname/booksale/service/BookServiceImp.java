package net.teamname.booksale.service;

import net.teamname.booksale.dao.BookDao;
import net.teamname.booksale.dao.BookDaoImp;
import net.teamname.booksale.domain.Book;
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
    public int getBook() {
        return 0;
    }

    @Override
    public List<Book> getAllBookPost() {
        return null;
    }

}
