package net.level0.booksale.util.validator;

import net.level0.booksale.domain.Book;

/**
 * @author: mithunshawon
 * Date: 12/13/14
 * Time: 7:47 AM
 *
 */
public class BookValidator {

    public static boolean ValidateBookPost(Book book) {
        boolean isValid = true;
        if (book.getTitle().isEmpty()) {
            return !isValid;
        } else if (book.getType().isEmpty()) {
            return !isValid;
        } else if (book.getAuthor().isEmpty()) {
            return !isValid;
        } else if (book.getPublisher().isEmpty()) {
            return !isValid;
        } else if ((book.getPrice() > 10000 || book.getPrice() < 50)) {
            return !isValid;
        } else if (!(book.getPhoto().contains(".jpg"))) {
            return !isValid;
        } else if (book.getDescription().isEmpty()) {
            return !isValid;
        }else if(book.getEdition().isEmpty()){
            return !isValid;
        }

        return isValid;
    }
}
