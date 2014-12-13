package net.level0.booksale.controller.user;

import net.level0.booksale.domain.Book;
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


/**
 * @author panthotanvir
 * @since 11/28/14.
 */

@WebServlet(name = "UpdateUserController", urlPatterns = "/updateuser")
public class UpdateUserController extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(UserAddController.class);
    private User user;
    private Book book;
    private UserService userService;
    private BookService bookService;

    public UpdateUserController() {
        userService = new UserServiceImp();
        bookService = new BookServiceImp();
        user = new User();
        book = new Book();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        updateUserFromRequest(req);
        log.debug("User is updated in UpdateUserController ======== :{}",req.getRemoteUser());
        userService.updateUser(user,req.getParameter("flag"));
        bookService.deleteBook(book,req.getParameter("flag"));

        req.setAttribute("message","Your information is updated");

        resp.sendRedirect(req.getContextPath() + "/dashboard");
    }

    private void updateUserFromRequest(HttpServletRequest req) throws IOException, ServletException {

        int userId = getUserId(req);
        book.setUserId(userId);
        user.setUserId(userId);
        log.debug("Flag variable in UpdateUserController:  {}", req.getParameter("flag"));

        if(req.getParameter("flag").equals("1")){
            log.debug("in flag 1");
            Integer uniId = Integer.parseInt(req.getParameter("uni_id"));
            Integer deptId = Integer.parseInt(req.getParameter("dept_id"));
            user.setUniId(uniId);
            user.setDeptId(deptId);
            user.setUserName(req.getParameter("user_name"));
        }
        else if(req.getParameter("flag").equals("2")){
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));

        }
        else if(req.getParameter("flag").equals("3")){
            user.setPhoneNo(req.getParameter("phone"));
            user.setAddress(req.getParameter("address"));
        }
        else if(req.getParameter("flag").equals("4")){
            Integer bookId = Integer.parseInt(req.getParameter("book_id"));
            book.setBookId(bookId);

        }

    }
    private int getUserId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getUserId();
    }
}
