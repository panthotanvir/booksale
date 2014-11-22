package net.teamname.booksale.dao;

import net.teamname.booksale.domain.User;
import net.teamname.booksale.util.DatabaseTemplate;
import net.teamname.booksale.util.ObjectRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created on 11/22/14 3:45 PM.
 *
 * @author: mithunshawon
 */
public class UserDaoImp implements UserDao {
    private static final Logger log = LoggerFactory.getLogger(UserDaoImp.class);
    @Override
    public User getUser(String userName, String password) {
        return null;
    }


    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Integer userId) {

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

    @Override
    public void addUser(User user) {
        String insertQuery = "INSERT INTO `booksale`.`user` (`user_name`, `uni_id`, `dept_id`, `email`, `password`,`phone`,`address`)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?);";

        String userName = user.getUserName();
        Integer uniId = user.getUniId();
        Integer deptId = user.getDeptId();
        String email = user.getEmail();
        String password = user.getPassword();
        String phoneNo = user.getPhoneNo();
        String address = user.getAddress();
        DatabaseTemplate.executeInsertQuery(insertQuery, userName,uniId, deptId, email, password, phoneNo, address);
        log.debug("User inserted");

    }
    public User setUser(ResultSet resultSet) throws SQLException{
        User user = new User();
        user.setUserName(resultSet.getString("user_name"));

        return user;
    }

}
