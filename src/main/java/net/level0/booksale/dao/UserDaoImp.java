package net.level0.booksale.dao;

import net.level0.booksale.domain.Book;
import net.level0.booksale.domain.Detail;
import net.level0.booksale.domain.University;
import net.level0.booksale.domain.User;

import net.level0.booksale.util.DatabaseTemplate;
import net.level0.booksale.util.ObjectRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created on 11/22/14 3:45 PM.
 *
 * @author: mithunshawon
 */
public class UserDaoImp implements UserDao {
    private static final Logger log = LoggerFactory.getLogger(UserDaoImp.class);

    public static Logger getLog() {
        return log;
    }

    @Override
    public User getUser(String email, String password) {
        String query = "SELECT * FROM user WHERE email= '" + email + "' AND password = '" + password+ "' ";

        log.debug("query---> {}", query);
        List<User> userList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<User>() {
            @Override
            public User mapRowToObject(ResultSet resultSet) throws SQLException {
                return setUser(resultSet);
            }
        });

        if (userList.size() != 0) {
            log.debug("USER returned");
            return userList.get(0);
        }
        return null;
    }

    @Override
    public void updateUserName(User user) {
        String updateQuery = "UPDATE user SET user_name = '"+ user.getUserName()+"', " +
                "uni_id ='"+user.getUniId()+"',dept_id='"+user.getDeptId()+"' WHERE user_id='"+user.getUserId()+"' " ;

        log.debug("update query in updateUserName: {} ",updateQuery);
        DatabaseTemplate.executeInsertQuery(updateQuery);
        log.debug("User information updated");
    }

    @Override
    public void updateUserPassword(User user) {
        String updateQuery = "UPDATE user SET email = '"+ user.getEmail()+"', " +
                "password ='"+user.getPassword()+"' WHERE user_id='"+user.getUserId()+"' " ;

        log.debug("update query in updateUserPassword: {} ",updateQuery);
        DatabaseTemplate.executeInsertQuery(updateQuery);
        log.debug("User information updated");
    }

    @Override
    public void updateUserContact(User user) {
        String updateQuery = "UPDATE user SET phone = '"+ user.getPhoneNo()+"', " +
                "address ='"+user.getAddress()+"' WHERE user_id='"+user.getUserId()+"' " ;

        log.debug("update query in updateUserContact: {} ",updateQuery);
        DatabaseTemplate.executeInsertQuery(updateQuery);
        log.debug("User information updated");
    }

    @Override
    public void deleteUser(int userId) {

    }

    @Override
    public Detail getUserInfo(int userId) {
        String query = "SELECT * FROM user,university,department WHERE user_id= '" + userId + "' AND user.dept_id = department.dept_id AND user.uni_id = university.uni_id ";

        log.debug("query at getUserInfo in UserDaoImp ---> {}", query);
        List<Detail> userInfoList = DatabaseTemplate.queryForObject(query, new ObjectRowMapper<Detail>() {
            @Override
            public Detail mapRowToObject(ResultSet resultSet) throws SQLException {
                return setUserInfo(resultSet);
            }
        });

        if (userInfoList.size() != 0) {
            log.debug("USER info returned");
            return userInfoList.get(0);
        }
        return null;
    }

    @Override
    public List<Detail> getUserDept(int userId, Integer uniId, Integer deptId) {
        String query = "SELECT * FROM user,university,department Where user.user_id != '" + userId + "' AND user.uni_id= '" + uniId + "' AND user.dept_id= '" + deptId + "' AND user.uni_id = university.uni_id AND user.dept_id = department.dept_id";
        log.debug("query fro DeptUser---> {}", query);
        List<Detail> userDeptList = DatabaseTemplate.queryForObject(query,new ObjectRowMapper<Detail>() {
            @Override
            public Detail mapRowToObject(ResultSet resultSet) throws SQLException {
                return setDeptUser(resultSet);
            }
        });
        if (userDeptList.size() != 0) {
            log.debug("All dept user list returned : {}" , userDeptList.size());
            return userDeptList;
        }
        return null;


    }

    @Override
    public List<Detail> getAllDivision() {
        String query = "SELECT * FROM division";
        List<Detail> divisionList = DatabaseTemplate.queryForObject(query,new ObjectRowMapper<Detail>() {
            @Override
            public Detail mapRowToObject(ResultSet resultSet) throws SQLException {
                return setDivisionList(resultSet);
            }
        });

        log.debug("All division list returned");
        return divisionList;
    }

    @Override
    public List<Book> getUserRequest(int userId) {
        String query = "SELECT * FROM request Where user_id = '" + userId + "'";
        List<Book> requestList = DatabaseTemplate.queryForObject(query,new ObjectRowMapper<Book>() {
            @Override
            public Book mapRowToObject(ResultSet resultSet) throws SQLException {
                return setRequestList(resultSet);
            }
        });

        log.debug("All request list returned");
        return requestList;
    }
    public Book setRequestList(ResultSet resultSet) throws SQLException{
        int requestId = Integer.parseInt(resultSet.getString("request_id"));
        int userId = Integer.parseInt(resultSet.getString("user_id"));


        Book book = new Book();
        book.setRequestId(requestId);
        book.setUserId(userId);
        book.setTitle(resultSet.getString("title"));
        book.setDate(resultSet.getString("date"));


        return book;

    }
    public Detail setDivisionList(ResultSet resultSet) throws SQLException{
        int divisionId = Integer.parseInt(resultSet.getString("division_id"));
        Detail detail = new Detail();
        detail.setDivisionId(divisionId);
        detail.setDivisionName(resultSet.getString("division_name"));
        log.info("Division NAme : {}",resultSet.getString("division_name"));
        return detail;
    }

    public Detail setUserInfo(ResultSet resultSet) throws SQLException{
        int userId = Integer.parseInt(resultSet.getString("user_id"));
        int deptId = Integer.parseInt(resultSet.getString("dept_id"));

        Detail userInfo = new Detail();
        User user = new User();
        University uni = new University();


        user.setUserId(userId);
        user.setUserName(resultSet.getString("user_name"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setAddress(resultSet.getString("address"));
        user.setPhoneNo(resultSet.getString("phone"));
        user.setPhoto(resultSet.getString("user_photo"));

        uni.setUniName(resultSet.getString("uni_name"));
        uni.setDeptName(resultSet.getString("dept_name"));
        uni.setDeptId(deptId);

        userInfo.setUser(user);
        userInfo.setUniversity(uni);

        return userInfo;
    }


    public Detail setDeptUser(ResultSet resultSet) throws SQLException{
        Integer userId = Integer.parseInt(resultSet.getString("user_id"));
        Detail userDept = new Detail();
        User user = new User();
        user.setUserName(resultSet.getString("user_name"));
        user.setUserId(userId);
        user.setEmail(resultSet.getString("email"));
        user.setPhoto(resultSet.getString("user_photo"));
        user.setAddress(resultSet.getString("address"));

        userDept.setUser(user);

        return userDept;
    }


    @Override
    public List<User> getAllUser() {
        String query = "SELECT * FROM user";
        List<User> userList = DatabaseTemplate.queryForObject(query,new ObjectRowMapper<User>() {
            @Override
            public User mapRowToObject(ResultSet resultSet) throws SQLException {
                return setUser(resultSet);
            }
        });

        log.debug("All user list returned");
        return userList;
    }
    public User setUser(ResultSet resultSet) throws SQLException{
        Integer userId = Integer.parseInt(resultSet.getString("user_id"));
        Integer uniId = Integer.parseInt(resultSet.getString("uni_id"));
        Integer deptId = Integer.parseInt(resultSet.getString("dept_id"));
        User user = new User();
        user.setUserName(resultSet.getString("user_name"));
        user.setUserId(userId);
        user.setEmail(resultSet.getString("email"));
        user.setUniId(uniId);
        user.setDeptId(deptId);
        user.setPhoneNo(resultSet.getString("phone"));
        user.setAddress(resultSet.getString("address"));


        return user;
    }
    @Override
    public void addUser(User user) {
        String insertQuery = "INSERT INTO `booksale`.`user` (`user_name`, `uni_id`, `dept_id`, `email`, `password`,`phone`,`address`,`user_photo`)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        String userName = user.getUserName();
        int uniId = user.getUniId();
        int deptId = user.getDeptId();
        String email = user.getEmail();
        String password = user.getPassword();
        String phoneNo = user.getPhoneNo();
        String address = user.getAddress();
        String photo = user.getPhoto();
        log.debug("photo---> {}", photo);
        log.debug("name---> {}", userName);
        log.debug("name---> {}", uniId);
        log.debug("name---> {}", deptId);
        log.debug("name---> {}", email);
        log.debug("name---> {}", userName);
        log.debug("name---> {}", password);
        log.debug("name---> {}", phoneNo);
        DatabaseTemplate.executeInsertQuery(insertQuery, userName,uniId, deptId, email, password, phoneNo, address, photo);
        log.debug("User inserted");

    }

    @Override
    public void rateUser(User user) {
        String insertQuery = "INSERT INTO `booksale`.`rating` (`rate`, `user_id`, `viewer_id`)" +
                " VALUES (?, ?, ?);";
        log.info("insertQuery value: {},insert query");
        int rate = user.getRate();
        int userId = user.getUserId();
        int viewerId = user.getViewerId();

       /* log.debug("photo---> {}", photo);
        log.debug("name---> {}", userName);
        log.debug("name---> {}", uniId);
        log.debug("name---> {}", deptId);
        log.debug("name---> {}", email);
        log.debug("name---> {}", userName);
        log.debug("name---> {}", password);
        log.debug("name---> {}", phoneNo);

        */
        DatabaseTemplate.executeInsertQuery(insertQuery, rate,userId,viewerId);
        log.debug("rate inserted");

    }

}