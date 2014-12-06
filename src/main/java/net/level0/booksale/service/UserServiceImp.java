package net.level0.booksale.service;


import net.level0.booksale.dao.UserDao;
import net.level0.booksale.dao.UserDaoImp;
import net.level0.booksale.domain.Detail;
import net.level0.booksale.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

/**
 * Created on 11/22/14 3:35 PM.
 *
 * @author: mithunshawon
 */
public class UserServiceImp implements UserService{
    private static final Logger log = LoggerFactory.getLogger(UserServiceImp.class);
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
    public void updateUser(User user, String flag) {
        if(flag.equals("1")){
            log.debug("in updateUser in UserServiceImp flag 1");
            userDao.updateUserName(user);
        }
        else if(flag.equals("2")){
            log.debug("in updateUser in UserServiceImp flag 2");
            userDao.updateUserPassword(user);
        }
        else if(flag.equals("3")){
            log.debug("in updateUser in UserServiceImp flag 3");
            userDao.updateUserContact(user);
        }
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public List<Detail> getAllDivision() { return userDao.getAllDivision();}

    @Override
    public User getUser(String email, String password) {
        log.debug("IN UserServiceImp-----  {}",userDao.getUser(email,password));
        return userDao.getUser(email, password);
    }

    @Override
    public Detail getUserInfo(Integer userId) {
        return userDao.getUserInfo(userId);
    }


    @Override
    public List<Detail> getUserDept(int userId, Integer uniId, Integer deptId) {
        return userDao.getUserDept(userId, uniId, deptId);
    }

}
