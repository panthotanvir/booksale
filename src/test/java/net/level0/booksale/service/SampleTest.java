package net.level0.booksale.service;

import net.level0.booksale.domain.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by panthotanvir on 11/28/14.
 */


public class SampleTest {

    @Test
    public void userAddTest() {
        User user = new User();
        user.setEmail("mithunshawon@yahoo.com");
        user.setPassword("123");

        UserServiceImp userServiceImp = new UserServiceImp();
        User userFromDb = userServiceImp.getUser("mithunshawon@yahoo.com", user.getPassword());
        Assert.assertEquals(user.getEmail(),userFromDb.getEmail());
    }

    public void userRegTest(){
        User user = new User();

        user.setUserName("pantho");
        user.setEmail("pantho@yahoo.com");

    }
}
