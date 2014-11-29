package net.level0.booksale.controller.user;


import net.level0.booksale.domain.Book;
import net.level0.booksale.domain.Detail;
import net.level0.booksale.domain.User;
import net.level0.booksale.service.BookService;
import net.level0.booksale.service.BookServiceImp;
import net.level0.booksale.service.UserService;
import net.level0.booksale.service.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created on 11/25/14 3:25 PM.
 *
 * @author: mithunshawon
 */
@WebServlet(name = "DashboardController", urlPatterns = "/dashboard")
public class DashboardController extends HttpServlet{
    private static final Logger log = LoggerFactory.getLogger(DashboardController.class);
    private User user;
    private UserService userService;
    private BookService bookService;

    public DashboardController() {
        userService = new UserServiceImp();
        bookService = new BookServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Dashboard Controller is requested ");
        Integer userId = getUserId(req);

        List<Book> requestBook = bookService.getRequestBook(userId);
        List<Book> userBookList = bookService.getBookList(userId);
       // List<Book> userRequestBook = bookService.getAllRequest(userId);


        req.setAttribute("userBook",userBookList);
        req.setAttribute("countBook",userBookList.size());
        req.setAttribute("requestResult",requestBook);
        req.setAttribute("countRequest",requestBook.size());
       // req.setAttribute("requestedBook",userRequestBook);

        log.debug("List Size in DashboardController:  {}",userBookList.size());
        log.debug("Count in DashboardController:   {}",userBookList.get(0).getCountBook());
        log.debug("Count in DashboardController:   {}",userBookList.get(3).getCountBook());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/dashboard/profile_overview.jsp");
        requestDispatcher.forward(req, resp);
    }

    private Integer getUserId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getUserId();
    }

}
