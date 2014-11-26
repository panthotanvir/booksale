package net.teamname.booksale.dao;

import net.teamname.booksale.domain.Detail;
import net.teamname.booksale.domain.User;

import net.teamname.booksale.util.DatabaseTemplate;
import net.teamname.booksale.util.ObjectRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public Detail getUserInfo(Integer userId) {
        String query = "SELECT * FROM user,university,department WHERE user_id= '" + userId + "' AND user.dept_id = department.dept_id AND user.uni_id = university.uni_id ";

        log.debug("query---> {}", query);
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
    public List<Detail> getUserDept(Integer userId, Integer uniId, Integer deptId) {
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

    public Detail setUserInfo(ResultSet resultSet) throws SQLException{
        Integer userId = Integer.parseInt(resultSet.getString("user_id"));
        Detail userInfo = new Detail();

        userInfo.setUserName(resultSet.getString("user_name"));
        userInfo.setUserId(userId);
        userInfo.setEmail(resultSet.getString("email"));
        userInfo.setAddress(resultSet.getString("address"));
        userInfo.setDeptName(resultSet.getString("dept_name"));
        userInfo.setUniName(resultSet.getString("uni_name"));
        userInfo.setPassword(resultSet.getString("password"));
        userInfo.setPhoneNo(resultSet.getString("phone"));

        return userInfo;
    }


    public Detail setDeptUser(ResultSet resultSet) throws SQLException{
        Integer userId = Integer.parseInt(resultSet.getString("user_id"));
        Detail userDept = new Detail();
        userDept.setUserName(resultSet.getString("user_name"));
        userDept.setUserId(userId);
        userDept.setEmail(resultSet.getString("email"));
        userDept.setAddress(resultSet.getString("address"));

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

}
