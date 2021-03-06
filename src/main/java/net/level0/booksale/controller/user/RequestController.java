package net.level0.booksale.controller.user;

import net.level0.booksale.domain.Book;
import net.level0.booksale.domain.Detail;
import net.level0.booksale.domain.University;
import net.level0.booksale.domain.User;
import net.level0.booksale.service.*;
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
import java.util.HashMap;
import java.util.List;

/**
 * Created by panthotanvir on 11/29/14.
 */
@WebServlet(name = "RequestController", urlPatterns = "/request")
public class RequestController extends  HttpServlet{
    private static final Logger log = LoggerFactory.getLogger(RequestController.class);

    private Book book;
    private BookService bookService;
    private UserService userService;
    private List<University> uniList;
    private HashMap<University, List<University>> uniDeptList;
    private UniService uniService;

    public RequestController() {
        bookService = new BookServiceImp();
        userService = new UserServiceImp();
        uniService = new UniServiceImp();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("request Controller is Called");
        int userId = getUserId(req);
        Detail userInfo = userService.getUserInfo(userId);
        List<Book> requestInfo = userService.getUserRequest(userId);

        log.info("User--------- : {}", userInfo.getUser().getUserName());
        log.info("reuqest Info : {}",requestInfo.size());
        req.setAttribute("userInfo", userInfo);
        req.setAttribute("requestInfo",requestInfo);
        uniList = uniService.getAllUniversity();
        uniDeptList = new HashMap<University, List<University>>();
        for(University university: uniList){
            uniDeptList.put(university, uniService.getSpecificUniDept(university.getId()));
        }
        req.setAttribute("uniDeptList", uniDeptList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/dashboard/request_book.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("New book request posted ");
        createRequestForm(req);
        log.debug("Request: {}",book.getTitle());
        bookService.requestBook(book);

        resp.sendRedirect(req.getContextPath() + "/request");
    }

    private void createRequestForm(HttpServletRequest req) throws IOException, ServletException {
        book = new Book();
        log.debug("create Request is called ");

        book.setUserId(getUserId(req));
        book.setDeptId(getDeptId(req));
        book.setTitle(req.getParameter("title"));
        log.debug("Request book set updated");
    }

    private Integer getUserId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getUserId();
    }
    private Integer getDeptId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getDeptId();
    }
}
