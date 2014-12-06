package net.level0.booksale.util.validator;

import net.level0.booksale.domain.User;

/**
 * Created by mithunshawon on 11/28/14.
 */


public class UserValidator {

    public static boolean validateEmailAndPassword(String email, String password) {
        boolean isValidUser = true;
        if(email.isEmpty()){
            return !isValidUser;
        }else if(password.isEmpty()) {
            return !isValidUser;
        }
        return isValidUser;
    }

}
