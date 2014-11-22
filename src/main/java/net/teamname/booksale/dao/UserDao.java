package net.teamname.booksale.dao;

import java.util.List;
import net.teamname.booksale.domain.User;

/**
 * Created on 11/22/14 3:45 PM.
 *
 * @author: mithunshawon
 */
public interface UserDao {
    public void addUser(User user);

    public User getUser(String userName, String password);

    public List<User> getAllUser();

    public void updateUser(User user);

    public void deleteUser(Integer userId);
}
