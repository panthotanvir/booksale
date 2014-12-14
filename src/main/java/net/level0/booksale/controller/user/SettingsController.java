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
 * Created by panthotanvir on 11/26/14.
 */
@WebServlet(name = "SettingsController", urlPatterns = "/settings")
public class SettingsController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(SettingsController.class);
    private final UniService uniService;
    private User user;
    private UserService userService;
    private BookService bookService;
    private HashMap<University, List<University>> uniDeptList;

    public SettingsController() {
        userService = new UserServiceImp();
        bookService = new BookServiceImp();
        uniService = new UniServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Settings Controller is requested ");
        int userId = getUserId(req);
        Detail userInfo = userService.getUserInfo(userId);
        req.setAttribute("userInfo",userInfo);

        List<University> uniList = getAllUniList();
        List<University> deptList = getAllDeptList();

        log.info("Uni List Size in UserAddController : {} " , uniList.size());
        log.info("Dept List Size in UserAddController : {} " , deptList.size());

        req.setAttribute("uniList", uniList);
        req.setAttribute("deptList",deptList);

        Detail settingInfo = userService.getUserInfo(userId);
        log.info("Setting info size : {}",settingInfo.getUser().getUserName());
        req.setAttribute("settingInfo",settingInfo);

        List<Book> bookList = bookService.getBookList(userId);
        log.info("Booklist in SettingController :{}", bookList.size());
        req.setAttribute("bookList",bookList);

        uniDeptList = new HashMap<University, List<University>>();
        for(University university: uniList){
            uniDeptList.put(university, uniService.getSpecificUniDept(university.getId()));
        }
        req.setAttribute("uniDeptList", uniDeptList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/dashboard/settings.jsp");
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
    private List<University> getAllUniList() {
        return new UniServiceImp().getAllUniversity();
    }
    private List<University> getAllDeptList() {
        return new UniServiceImp().getAllDept();
    }
}

