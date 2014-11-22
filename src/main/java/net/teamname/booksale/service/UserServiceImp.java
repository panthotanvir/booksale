package net.teamname.booksale.service;

import net.teamname.booksale.dao.UserDao;
import net.teamname.booksale.dao.UserDaoImp;
import net.teamname.booksale.domain.User;

import java.util.List;

/**
 * Created on 11/22/14 3:35 PM.
 *
 * @author: mithunshawon
 */
public class UserServiceImp implements UserService{
    private UserDao userDao = null;

    public UserServiceImp(){
        this.userDao = new UserDaoImp();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> getAllUserOfWeek() {
        return userDao.getAllUser();
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Integer userId) {

    }
    @Override
    public User getUser(String userName, String password) {
        return userDao.getUser(userName, password);
    }

}
