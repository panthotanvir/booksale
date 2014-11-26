package net.teamname.booksale.service;

import java.util.List;

import net.teamname.booksale.domain.Detail;
import net.teamname.booksale.domain.User;


/**
 * Created on 11/22/14 3:35 PM.
 *
 * @author: mithunshawon
 */
public interface UserService {

    public void addUser(User user);

    public User getUser(String userName, String password);

    public Detail getUserInfo(Integer userID);

    public List<User> getAllUser();

    public void updateUser(User user);

    public void deleteUser(Integer userId);
}
