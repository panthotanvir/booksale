package net.level0.booksale.util.validator;

import net.level0.booksale.domain.User;

/**
 * Created by mithunshawon on 11/28/14.
 */


public class UserValidator {

    public static boolean validateEmailAndPassword(String email, String password) {
        boolean isValidUser = true;
        if (email.isEmpty()) {
            return !isValidUser;
        } else if (password.isEmpty()) {
            return !isValidUser;
        }
        return isValidUser;
    }

    public static boolean validateUserRegistration(User user) {
        boolean isValid = true;
        String name = user.getUserName();
        String email = user.getEmail();
        String password = user.getPassword();
        String phone = user.getPhoneNo();
        String address = user.getAddress();
        String file = user.getPhoto();

        if (!(name.isEmpty()) && !(email.isEmpty()) && !(password.isEmpty()) && !(phone.isEmpty()) && !(address.isEmpty())
                && !(file.isEmpty())) {

            return isValid;

        } else {
            return !isValid;
        }

    }

}
