package net.level0.booksale.controller.user;

import net.level0.booksale.domain.Book;
import net.level0.booksale.service.BookService;
import net.level0.booksale.service.BookServiceImp;
import net.level0.booksale.service.UserService;
import net.level0.booksale.service.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by panthotanvir on 12/13/14.
 */
@WebServlet(name = "ExchangeDeleteController", urlPatterns = "/deleteExchange")
public class ExchangeDeleteController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(RequestController.class);

    private BookService bookService;

    public ExchangeDeleteController() {

        bookService = new BookServiceImp();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer exchangeId = Integer.parseInt(req.getParameter("exchange_id"));
        bookService.deleteExchange(exchangeId);
        resp.sendRedirect(req.getContextPath() + "/exchange");
    }
}