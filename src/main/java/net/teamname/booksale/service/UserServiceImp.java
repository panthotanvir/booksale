package net.teamname.booksale.service;

import net.teamname.booksale.dao.UserDao;
import net.teamname.booksale.dao.UserDaoImp;
import net.teamname.booksale.domain.Detail;
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
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }



    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Integer userId) {

    }
    @Override
    public User getUser(String email, String password) {
        return userDao.getUser(email, password);
    }

    @Override
    public Detail getUserInfo(Integer userId) {
        return userDao.getUserInfo(userId);
    }


    @Override
    public List<Detail> getUserDept(Integer userId, Integer uniId, Integer deptId) {
        return userDao.getUserDept(userId, uniId, deptId);
    }

}
