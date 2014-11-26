package net.teamname.booksale.controller;

import net.teamname.booksale.domain.Detail;
import net.teamname.booksale.service.BookService;
import net.teamname.booksale.service.BookServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 11/24/14 12:43 AM.
 *
 * @author: mithunshawon
 *
 **/
@WebServlet(name="SingleBookController", urlPatterns = "/singleBook")
public class SingleBookController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(SingleBookController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer bookId = Integer.parseInt(req.getParameter("bookId"));
        log.debug("Single book controller called");

        BookService bookService = new BookServiceImp();
        Detail singleBook = bookService.getBook(bookId);

        log.info("Book--------- : {}" ,singleBook.getUserName());
        req.setAttribute("bookInfo",singleBook);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/book/single_book.jsp");
        requestDispatcher.forward(req, resp);

    }
}
