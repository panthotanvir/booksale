package net.level0.booksale.service;

import net.level0.booksale.domain.Detail;
import net.level0.booksale.domain.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by panthotanvir on 11/28/14.
 *
 */


public class UserServiceTest {

    @Test
   public void getUserTest() {
        User user = new User();
        user.setEmail("mithunshawon@yahoo.com");
        user.setPassword("123");

        UserService userService = new UserServiceImp();
        User userFromDb = userService.getUser("mithunshawon@yahoo.com", user.getPassword());
        Assert.assertEquals(user.getEmail(),userFromDb.getEmail());
    }

    public void getUserInfoTest(){
        User user = new User();
        Detail info = new Detail();

        Integer userId = 54;
        user.setUserId(userId);
        info.setUser(user);

        UserService userService = new UserServiceImp();
        Detail infoFromDb = userService.getUserInfo(5);
        Assert.assertEquals(info.getUser().getAddress(),infoFromDb.getUser().getAddress());


    }
}
