package net.teamname.booksale.dao;

import net.teamname.booksale.domain.Book;
import net.teamname.booksale.util.DatabaseTemplate;
import net.teamname.booksale.util.ObjectRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by panthotanvir on 11/22/14.
 */
public class BookDaoImp implements BookDao {
    private static final Logger log = LoggerFactory.getLogger(BookDaoImp.class);
    @Override
    public void addBook(Book book) {
        String insertQuery = "INSERT INTO `booksale`.`book` (`user_id`, `dept_id`, `title`, `author`, `publisher`," +
                "`tag`,`type`,`description`,`price`,`photo`,`contact_no`,`contact_address`)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        Integer userId = book.getUser_id();
        Integer deptId = book.getDept_id();
        String title = book.getTitle();
        String author = book.getAuthor();
        String publisher = book.getPublisher();
        String tag = book.getTag();
        String type = book.getType();
        String description = book.getDescription();
        Double price = book.getPrice();
        String photo = book.getPhoto();
        String contact_no = book.getContact_no();
        String contact_address = book.getContact_address();

        DatabaseTemplate.executeInsertQuery(insertQuery, userId, deptId, title, author, publisher, tag, type, description, price, photo,contact_no, contact_address);
        log.debug("book post  inserted");
    }

    @Override
    public int getBook() {
        return 0;
    }

    @Override
    public List<Book> getAllBookPost() {
        log.info("GetAll Book Called ");

        String query = "SELECT * FROM book";
        List<Book> bookList = DatabaseTemplate.queryForObject(query,new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        log.info("book List Size : {} " , bookList.size());
        return bookList;
    }


    private Book setBook(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        Double price = Double.parseDouble(resultSet.getString("price"));
        Integer bookId = Integer.parseInt(resultSet.getString("book_id"));

        book.setBook_id(bookId);
        book.setType(resultSet.getString("type"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setPrice(price);


        return book;
    }
}
