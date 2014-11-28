package net.teamname.booksale.dao;

import net.teamname.booksale.domain.Book;
import net.teamname.booksale.domain.Detail;
import net.teamname.booksale.domain.University;
import net.teamname.booksale.domain.User;
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

        Integer userId = book.getUserId();
        Integer deptId = book.getDeptId();
        String title = book.getTitle();
        String author = book.getAuthor();
        String publisher = book.getPublisher();
        String tag = book.getTag();
        String type = book.getType();
        String description = book.getDescription();
        Double price = book.getPrice();
        String photo = book.getPhoto();
        String contactNo = book.getContactNo();
        String contactAddress = book.getContactAddress();

        DatabaseTemplate.executeInsertQuery(insertQuery, userId, deptId, title, author, publisher, tag, type, description, price, photo,contactNo, contactAddress);
        log.debug("book post  inserted");
    }

    @Override
    public Detail getBook(int bookId) {
        log.debug("Detail getBook called");
        String query = "SELECT * FROM book,user,university,department WHERE book_id = ' " +bookId+ " ' AND book.user_id = user.user_id AND " +
                "book.dept_id = department.dept_id AND user.uni_id = university.uni_id  " ;
        log.debug("query :   {}",query);

        List<Detail> bookInfo = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Detail>() {
            @Override
            public Detail mapRowToObject(ResultSet resultSet) throws SQLException {
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

    @Override
    public List<Book> getBookList(Integer userId) {
        String query = "SELECT * FROM book Where book.user_id = '" + userId + "' ";
        log.debug("query fro book list---> {}", query);
        List<Book> userBookList = DatabaseTemplate.queryForObject(query,new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        return userBookList;
    }

    @Override
    public List<Book> getBookList(String authorName) {
        String query = "SELECT * FROM book WHERE author = '"+authorName +"' ";
        return null;
    }

    @Override
    public List<Book> getDeptBook(Integer deptId) {
        String query = "SELECT * FROM book Where book.dept_id = '" + deptId + "' ";
        log.debug("query for dept book list---> {}", query);
        List<Book> deptBookList = DatabaseTemplate.queryForObject(query,new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        return deptBookList;
    }

    @Override
    public List<Book> searchTitleBookList(String title) {
        String query = "SELECT * FROM book WHERE title like '"+title+"%'";
        log.info("like query in searchTitleBookList  : {}",query);

        List<Book> titleBookList = DatabaseTemplate.queryForObject(query,new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        return titleBookList;
    }

    /*private Book setUserBookList(ResultSet resultSet) throws SQLException {


        Double price = Double.parseDouble(resultSet.getString("price"));
        Integer bookId = Integer.parseInt(resultSet.getString("book_id"));
        Integer userId = Integer.parseInt(resultSet.getString("user_id"));

        Book userBookList = new Book();

        userBookList.setBookId(bookId);
        userBookList.setUserId(userId);
        userBookList.setType(resultSet.getString("type"));
        userBookList.setTitle(resultSet.getString("title"));
        userBookList.setAuthor(resultSet.getString("author"));
        userBookList.setPublisher(resultSet.getString("publisher"));
        userBookList.setDescription(resultSet.getString("description"));
        userBookList.setPhoto(resultSet.getString("photo"));
        userBookList.setPrice(price);

        return userBookList;
    }
*/

    private Detail setSingleBook(ResultSet resultSet) throws SQLException {
        Detail sBook = new Detail();
        Book book = new Book();
        User user = new User();
        University uni = new University();
        Double price = Double.parseDouble(resultSet.getString("price"));
        Integer bookId = Integer.parseInt(resultSet.getString("book_id"));
        Integer userId = Integer.parseInt(resultSet.getString("user_id"));
        Integer deptId = Integer.parseInt(resultSet.getString("dept_id"));

        log.debug("book_id : {}", bookId);

        book.setBookId(bookId);
        book.setType(resultSet.getString("type"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setPublisher(resultSet.getString("publisher"));
        book.setDescription(resultSet.getString("description"));
        book.setPhoto(resultSet.getString("photo"));
        book.setContactAddress(resultSet.getString("contact_address"));
        book.setContactNo(resultSet.getString("contact_no"));
        book.setTag(resultSet.getString("tag"));
        book.setPrice(price);
        book.setDate(resultSet.getString("date"));
        user.setUserName(resultSet.getString("user_name"));
        user.setEmail(resultSet.getString("email"));
        user.setAddress(resultSet.getString("address"));
        user.setPhoneNo(resultSet.getString("phone"));
        user.setUserId(userId);
        uni.setUniName(resultSet.getString("uni_name"));
        uni.setDeptName(resultSet.getString("dept_name"));
        uni.setDeptId(deptId);

        sBook.setBook(book);
        sBook.setUser(user);
        sBook.setUniversity(uni);

        return sBook;
    }
    private Book setBook(ResultSet resultSet) throws SQLException {

        Double price = Double.parseDouble(resultSet.getString("price"));
        Integer bookId = Integer.parseInt(resultSet.getString("book_id"));
        Integer userId = Integer.parseInt(resultSet.getString("user_id"));
        Book book = new Book();

        book.setBookId(bookId);
        book.setUserId(userId);
        book.setType(resultSet.getString("type"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setPublisher(resultSet.getString("publisher"));
        book.setDescription(resultSet.getString("description"));
        book.setPhoto(resultSet.getString("photo"));
        book.setPrice(price);
        book.setDate(resultSet.getString("date"));

        return book;
    }
}
