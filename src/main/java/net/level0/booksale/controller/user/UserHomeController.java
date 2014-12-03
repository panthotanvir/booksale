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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by panthotanvir on 11/27/14.
 */

@WebServlet(name = "UserHomeController", urlPatterns = "/userhome")
public class UserHomeController extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserHomeController.class);

    private BookService bookService;
    private UserService userService;

    public UserHomeController() {
        bookService = new BookServiceImp();
        userService = new UserServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("User Home Controller is requested ");
        int userId = getUserId(req);
        Detail userInfo = userService.getUserInfo(userId);
        log.info("User in ProfileController--------- : {}" ,userInfo.getUser().getPhoto());
        req.setAttribute("userInfo",userInfo);

        Integer deptId = getDeptId(req);
        List<Book> bookList = bookService.getDeptBook(deptId);
        log.info("Dept Book list size : {}", bookList.size());
        req.setAttribute("bookList",bookList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/book/dept_book_show.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }

    private Integer getDeptId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        log.info("is user : {}",user.isUser());
        return user.getDeptId();
    }
    private Integer getUserId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getUserId();
    }

}