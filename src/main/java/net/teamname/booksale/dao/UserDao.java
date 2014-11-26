package net.teamname.booksale.dao;

import java.util.List;

import net.teamname.booksale.domain.Detail;
import net.teamname.booksale.domain.User;


/**
 * Created on 11/22/14 3:45 PM.
 *
 * @author: mithunshawon
 */
public interface UserDao {
    public void addUser(User user);

    public User getUser(String email, String password);

    public List<User> getAllUser();

    public void updateUser(User user);

    public void deleteUser(Integer userId);

    public Detail getUserInfo(Integer userId);

    public List<Detail> getUserDept(Integer userId,Integer uniId , Integer deptId);
}
