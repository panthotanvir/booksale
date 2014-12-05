package net.level0.booksale.dao;

import java.util.List;

import net.level0.booksale.domain.Detail;
import net.level0.booksale.domain.User;


/**
 * Created on 11/22/14 3:45 PM.
 *
 * @author: mithunshawon
 */
public interface UserDao {
    public void addUser(User user);

    public User getUser(String email, String password);

    public List<User> getAllUser();

    public void updateUserName(User user);

    public void updateUserPassword(User user);

    public void updateUserContact(User user);

    public void deleteUser(int userId);

    public Detail getUserInfo(int userId);

    public List<Detail> getUserDept(int userId,Integer uniId , Integer deptId);

    public List<Detail> getAllDivision();
}
