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
 * Created on 11/25/14 3:25 PM.
 *
 * @author: mithunshawon
 */
@WebServlet(name = "DashboardController", urlPatterns = "/dashboard")
public class DashboardController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DashboardController.class);
    private User user;
    private UserService userService;
    private BookService bookService;
    private UniService uniService;
    private List<University> uniList;
    private HashMap<University, List<University>> uniDeptList;

    public DashboardController() {
        userService = new UserServiceImp();
        bookService = new BookServiceImp();
        uniService = new UniServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Dashboard Controller is requested ");

        int userId = getUserId(req);
        log.info("Dashboard Controller is requested and UserID is: {} ",userId);
        Detail userInfo = userService.getUserInfo(userId);

        log.info("User--------- : {}", userInfo.getUser().getUserName());
        req.setAttribute("userInfo", userInfo);

        List<Book> requestBook = bookService.getRequestBook(userId);
        List<Book> userBookList = bookService.getBookList(userId);
        uniList = uniService.getAllUniversity();
        uniDeptList = new HashMap<University, List<University>>();
        for(University university: uniList){
            uniDeptList.put(university, uniService.getSpecificUniDept(university.getId()));
        }
        req.setAttribute("uniDeptList", uniDeptList);
        req.setAttribute("userBook", userBookList);
        req.setAttribute("countBook", userBookList.size());
        req.setAttribute("requestResult", requestBook);
        req.setAttribute("countRequest", requestBook.size());

        log.debug("List Size in DashboardController:  {}", userBookList.size());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/dashboard/profile_overview.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }

    private Integer getUserId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getUserId();
    }
}
