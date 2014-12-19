package net.level0.booksale.dao;

import net.level0.booksale.domain.Book;
import net.level0.booksale.domain.Detail;
import net.level0.booksale.domain.University;
import net.level0.booksale.domain.User;
import net.level0.booksale.util.DatabaseTemplate;
import net.level0.booksale.util.ObjectRowMapper;
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
        String insertQuery = "INSERT INTO `booksale`.`book` (`user_id`, `dept_id`, `uni_id`, `title`, `author`, `publisher`" +
                ",`type`,`description`,`price`,`photo`, `division_id`, `edition`)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        log.debug("Query in BookDaoImp : {}",insertQuery);

        int userId = book.getUserId();
        int deptId = book.getDeptId();
        int uniId = book.getUniId();
        int divisionId = book.getDivisionId();
        String title = book.getTitle();
        String author = book.getAuthor();
        String publisher = book.getPublisher();
        String type = book.getType();
        String description = book.getDescription();
        Double price = book.getPrice();
        String photo = book.getPhoto();
        String edition = book.getEdition();

        DatabaseTemplate.executeInsertQuery(insertQuery, userId, deptId, uniId, title, author, publisher, type, description, price, photo, divisionId, edition);
        log.debug("book post inserted");
    }

    @Override
    public Detail getBook(int bookId) {
        log.debug("Detail getBook called");
        String query = "SELECT * FROM book,user,university,department WHERE book_id = ' " + bookId + " ' AND book.user_id = user.user_id AND " +
                "book.dept_id = department.dept_id AND user.uni_id = university.uni_id  ";
        log.debug("query :   {}", query);

        List<Detail> bookInfo = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Detail>() {
            @Override
            public Detail mapRowToObject(ResultSet resultSet) throws SQLException {
                log.debug("mapRowToObject called");
                return setSingleBook(resultSet);
            }
        });


        log.debug("bookInfo size: {}", bookInfo.size());
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
        List<Book> bookList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        log.info("book List Size : {} ", bookList.size());
        return bookList;
    }

    @Override
    public List<Book> getLatestBookPost() {
        log.info("GetAll Book Called ");

        String query = "SELECT * FROM `book` ORDER BY date desc LIMIT 8";
        List<Book> bookList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        log.info("book List Size : {} ", bookList.size());
        return bookList;
    }

    @Override
    public List<Book> getBookList(int userId) {
        String query = "SELECT * FROM book Where book.user_id = '" + userId + "' ";
        log.debug("query fro book list---> {}", query);
        List<Book> userBookList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        return userBookList;
    }



    @Override
    public List<Book> getDeptBook(Integer deptId) {
        String query = "SELECT * FROM book Where book.dept_id = '" + deptId + "' ";
        log.debug("query for dept book list---> {}", query);
        List<Book> deptBookList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        return deptBookList;
    }

    @Override
    public List<Book> getRecommenedBook(Integer deptId, Integer bookId) {
        String query = "SELECT * FROM book Where book.book_id != '" + bookId + "' AND book.dept_id = '" + deptId + "' ";
        log.debug("query for dept book list---> {}", query);
        List<Book> recommendBookList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        return recommendBookList;
    }

    @Override
    public List<Book> searchTitleBookList(String title) {
        String query = "SELECT * FROM book WHERE title like '" + title + "%'";
        log.info("like query in searchTitleBookList  : {}", query);

        List<Book> titleBookList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        return titleBookList;
    }

    @Override
    public List<Book> searchAuthorBookList(String authorName) {

        String query = "SELECT * FROM book WHERE author like '" + authorName + "%'";
        log.info("like query in searchAuthorBookList  : {}", query);

        List<Book> authorBookList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        return authorBookList;

    }

    @Override
    public List<Book> searchPublisherBookList(String publisherName) {
        String query = "SELECT * FROM book WHERE publisher like '" + publisherName + "%'";
        log.info("like query in searchPublisherBookList  : {}", query);

        List<Book> publisherBookList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        return publisherBookList;

    }

    @Override
    public List<Book> searchAllBookList(String name) {
        String query = "SELECT * FROM book WHERE author like '" + name + "%' OR " +
                "publisher like '"+name+"%' OR type like '"+name+"%' OR title like '"+name+"%' ";
        log.info("like query in searchAllBookList  : {}", query);

        List<Book> authorBookList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        return authorBookList;
    }

    @Override
    public List<Book> getRequestBook(Integer userId) {
        String query = "SELECT * FROM book,request Where request.user_id = '" + userId + "' AND request.user_id = book.user_id AND book.title = request.title";
        log.debug("query for dept book list---> {}", query);
        List<Book> requestBookResult = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        return requestBookResult;
    }

    @Override
    public List<Book> getAllRequest(Integer userId) {
        String query = "SELECT * FROM request Where user_id = '" + userId + "' ";
        log.debug("query for request book list---> {}", query);
        List<Book> requestBookList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setRequestBook(resultSet);
            }
        });

        return requestBookList;
    }

    @Override
    public List<Book> getUniDeptBookList(int uniId, int deptId) {
        String query = "SELECT * FROM book Where uni_id = '" + uniId + "' AND dept_id = '"+deptId+"' ";
        log.debug("query for getUniDeptBookList ---> {}", query);
        List<Book> uniDeptBookList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        return uniDeptBookList;
    }

    @Override
    public void requestBook(Book book) {
        String insertQuery = "INSERT INTO `booksale`.`request` (`user_id`, `dept_id`, `title`)" +
                " VALUES (?, ?, ? );";
        log.debug("insert query in requestBook : {}", insertQuery);
        Integer userId = book.getUserId();
        Integer deptId = book.getDeptId();
        String title = book.getTitle();
        DatabaseTemplate.executeInsertQuery(insertQuery, userId, deptId, title);
        log.debug("request book post  inserted");
    }

    @Override
    public void deleteBook(Book book) {
        String deleteQuery = "DELETE FROM book WHERE book_id = '"+book.getBookId()+"' AND user_id = '"+book.getUserId()+"' " ;

        log.debug("delete query in : {} ",deleteQuery);
        DatabaseTemplate.executeInsertQuery(deleteQuery);
        log.debug("book information deleted");
    }

    @Override
    public List<Book> getDivisionBook(Integer divisionId) {
        String query = "SELECT * FROM book,division Where book.division_id = division.division_id AND book.division_id = '" + divisionId + "' ";
        log.debug("query for division book list---> {}", query);
        List<Book> divisionBookList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        return divisionBookList;
    }


    @Override
    public void exchangeBook(Book book) {
        String insertQuery = "INSERT INTO `booksale`.`exchange` (`user_id`, `dept_id`, `exchange_to`,`exchange_with`, `detail` )" +
                " VALUES (?, ?, ?, ?, ? );";
        log.debug("insert query in exchangeBook : {}", insertQuery);
        Integer userId = book.getUserId();
        Integer deptId = book.getDeptId();
        String exchangeTo = book.getExchangeTo();
        String exchangeWith = book.getExchangeWith();
        String detail = book.getDetail();
        DatabaseTemplate.executeInsertQuery(insertQuery, userId, deptId, exchangeTo, exchangeWith, detail);
        log.debug("exchange book post  inserted");
    }

    @Override
    public List<Book> getExchangeList(Integer userId) {
        String query = "SELECT * FROM exchange Where user_id = '" + userId + "' ";
        log.debug("query for exchange book list---> {}", query);
        List<Book> exchangeBookList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setExchangeBook(resultSet);
            }
        });

        return exchangeBookList;
    }

    @Override
    public List<Book> getUniBookList(int uniType) {
        String query = "SELECT * from book,university WHERE book.uni_id = university.uni_id AND university.uni_type ='"+uniType+"' ";
        List<Book> uniBookList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setBook(resultSet);
            }
        });

        return uniBookList;
    }

    @Override
    public List<Detail> getExchangeList() {
        String query = "SELECT * FROM exchange,user WHERE exchange.user_id = user.user_id";
        List<Detail> exchangeList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Detail>() {
            @Override
            public Detail mapRowToObject(ResultSet resultSet) throws SQLException {
                return setExchangeBookList(resultSet);
            }
        });

        return exchangeList;
    }

    private Detail setExchangeBookList(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        Detail detail = new Detail();
        User user = new User();
        Integer exchangeId = Integer.parseInt(resultSet.getString("exchange_id"));
        Integer userId = Integer.parseInt(resultSet.getString("user_id"));

        book.setUserId(userId);
        book.setExchangeId(exchangeId);
        book.setExchangeTo(resultSet.getString("exchange_to"));
        book.setExchangeWith(resultSet.getString("exchange_with"));
        book.setDetail(resultSet.getString("detail"));
        book.setExchangeDate(resultSet.getString("exchange_date"));
        user.setUserName(resultSet.getString("user_name"));
        user.setPhoneNo(resultSet.getString("phone"));

        detail.setBook(book);
        detail.setUser(user);
        return detail;
    }

    @Override
    public void deleteExchange(Integer exchangeId) {
        String deleteQuery = "DELETE FROM exchange WHERE exchange_id = '" +exchangeId +"' " ;

        log.debug("delete query in : {} ",deleteQuery);
        DatabaseTemplate.executeInsertQuery(deleteQuery);
        log.debug("exchange information deleted");
    }

    @Override
    public void deleteRequest(Integer requestId) {
        String deleteQuery = "DELETE FROM request WHERE request_id = '" +requestId +"' " ;

        log.debug("delete query in : {} ",deleteQuery);
        DatabaseTemplate.executeInsertQuery(deleteQuery);
        log.debug("request information deleted");
    }

    @Override
    public List<Book> getRatedUserBook() {
        log.info("GetAll rated users Book Called ");

        String query = "\n" +
                "SELECT DISTINCT book.book_id,book.title,book.price,book.photo FROM book,rating WHERE book.user_id = rating.user_id AND rating.rate >= 4 ";
        List<Book> bookList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setRatedBook(resultSet);
            }
        });

        log.info("book List Size : {} ", bookList.size());
        return bookList;
    }
    private Book setRatedBook(ResultSet resultSet) throws SQLException{
        Book book = new Book();

        Integer bookId = Integer.parseInt(resultSet.getString("book_id"));

        Double price = Double.parseDouble(resultSet.getString("price"));

        book.setBookId(bookId);
        book.setTitle(resultSet.getString("title"));
        book.setPhoto(resultSet.getString("photo"));
        book.setPrice(price);
        return book;
    }
    private Book setExchangeBook(ResultSet resultSet) throws SQLException{
        Book book = new Book();
        Integer exchangeId = Integer.parseInt(resultSet.getString("exchange_id"));
        Integer userId = Integer.parseInt(resultSet.getString("user_id"));

        book.setUserId(userId);
        book.setExchangeId(exchangeId);
        book.setExchangeTo(resultSet.getString("exchange_to"));
        book.setExchangeWith(resultSet.getString("exchange_with"));
        book.setDetail(resultSet.getString("detail"));
        book.setExchangeDate(resultSet.getString("exchange_date"));

        return book;

    }

    private Detail setDivisionBook(ResultSet resultSet) throws SQLException{
        Detail sBook = new Detail();
        Book book = new Book();

        Integer bookId = Integer.parseInt(resultSet.getString("book_id"));
        Integer divisionId = Integer.parseInt(resultSet.getString("division_id"));
        Double price = Double.parseDouble(resultSet.getString("price"));

        book.setBookId(bookId);
        book.setType(resultSet.getString("type"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setPublisher(resultSet.getString("publisher"));
        book.setDescription(resultSet.getString("description"));
        book.setPhoto(resultSet.getString("photo"));
        book.setPrice(price);
        book.setDate(resultSet.getString("date"));
        sBook.setBook(book);
        sBook.setDivisionId(divisionId);
        sBook.setDivisionName(resultSet.getString("division_name"));

        return sBook;

    }
    private Book setRequestBook(ResultSet resultSet) throws SQLException{
        Integer count = resultSet.getRow();
        log.info("count value of : {}",count);
        Integer userId = Integer.parseInt(resultSet.getString("user_id"));
        Integer requestId = Integer.parseInt(resultSet.getString("request_id"));

        
        Book book = new Book();

        book.setUserId(userId);
        book.setRequestId(requestId);
        book.setTitle(resultSet.getString("title"));
        book.setDate(resultSet.getString("date"));
        book.setCountRequest(count);

        return book;
    }
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
        book.setPrice(price);
        book.setEdition(resultSet.getString("edition"));
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

        Integer count = resultSet.getRow();
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
        book.setEdition(resultSet.getString("edition"));
        book.setCountBook(count);

        return book;
    }
}
