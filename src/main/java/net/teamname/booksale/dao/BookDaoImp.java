package net.teamname.booksale.dao;

import net.teamname.booksale.domain.Book;
import net.teamname.booksale.domain.Department;
import net.teamname.booksale.domain.SingleBook;
import net.teamname.booksale.domain.User;
import net.teamname.booksale.util.DatabaseTemplate;
import net.teamname.booksale.util.ObjectRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public SingleBook getBook(int bookId) {
        log.debug("SingleBook getBook called");
        String query = "SELECT * FROM book,user,university,department WHERE book_id = ' " +bookId+ " ' AND book.user_id = user.user_id AND " +
                "book.dept_id = department.dept_id AND user.uni_id = university.uni_id  " ;
        log.debug("query :   {}",query);

        List<SingleBook> bookInfo = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<SingleBook>() {
            @Override
            public SingleBook mapRowToObject(ResultSet resultSet) throws SQLException {
                log.debug("mapRowToObject called");
                return setSingleBook(resultSet);
            }
        });


        log.debug("bookInfo size: {}" ,bookInfo.size());
//        log.debug("content: {}" ,bookInfo.get(0));
        if (bookInfo.size() != 0) {
            log.debug("Book information returned");
            return bookInfo.get(0);
        }
        return null;
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


    private SingleBook setSingleBook(ResultSet resultSet) throws SQLException {
        SingleBook sBook = new SingleBook();
        Double price = Double.parseDouble(resultSet.getString("price"));
        Integer bookId = Integer.parseInt(resultSet.getString("book_id"));
        Integer userId = Integer.parseInt(resultSet.getString("user_id"));

        log.debug("book_id : {}", bookId);
        sBook.setBookId(bookId);
        sBook.setType(resultSet.getString("type"));
        sBook.setTitle(resultSet.getString("title"));
        sBook.setAuthor(resultSet.getString("author"));
        sBook.setPublisher(resultSet.getString("publisher"));
        sBook.setDescription(resultSet.getString("description"));
        sBook.setPhoto(resultSet.getString("photo"));
        sBook.setContactAddress(resultSet.getString("contact_address"));
        sBook.setContactNo(resultSet.getString("contact_no"));
        sBook.setPrice(price);
        sBook.setUserName(resultSet.getString("user_name"));
        sBook.setEmail(resultSet.getString("email"));
        sBook.setAddress(resultSet.getString("address"));
        sBook.setPhoneNo(resultSet.getString("phone"));
        sBook.setUniName(resultSet.getString("uni_name"));
        sBook.setDeptName(resultSet.getString("dept_name"));
        sBook.setDate(resultSet.getString("date"));

        return sBook;
    }
    private Book setBook(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        Double price = Double.parseDouble(resultSet.getString("price"));
        Integer bookId = Integer.parseInt(resultSet.getString("book_id"));


        book.setBook_id(bookId);
        book.setType(resultSet.getString("type"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setPublisher(resultSet.getString("publisher"));
        book.setDescription(resultSet.getString("description"));
        book.setPhoto(resultSet.getString("photo"));
        book.setPrice(price);


        return book;
    }
}
