package net.level0.booksale.controller.user;

import net.level0.booksale.domain.Book;
import net.level0.booksale.domain.Detail;
import net.level0.booksale.domain.User;
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
 * Created by panthotanvir on 11/26/14.
 */
@WebServlet(name = "LibraryController", urlPatterns = "/library")
public class LibraryController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LibraryController.class);
    private User user;
    private BookServiceImp bookService;
    private UserService userService;

    public LibraryController() {

        bookService = new BookServiceImp();
        userService = new UserServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Library Controller is requested ");
        int userID = getUserId(req);
        Detail userInfo = userService.getUserInfo(userID);
        req.setAttribute("userInfo",userInfo);
        List<Book> libraryBook = bookService.getBookList(userID);

        req.setAttribute("libraryBook",libraryBook);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/dashboard/my_library.jsp");
        requestDispatcher.forward(req, resp);
    }

    private Integer getUserId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getUserId();
    }
}
