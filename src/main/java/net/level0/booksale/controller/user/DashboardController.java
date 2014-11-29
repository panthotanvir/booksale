package net.level0.booksale.controller.user;


import net.level0.booksale.domain.Detail;
import net.level0.booksale.domain.User;
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
 * Created on 11/25/14 3:25 PM.
 *
 * @author: mithunshawon
 */
@WebServlet(name = "DashboardController", urlPatterns = "/dashboard")
public class DashboardController extends HttpServlet{
    private static final Logger log = LoggerFactory.getLogger(DashboardController.class);
    private User user;
    private UserServiceImp userService;

    public DashboardController() {
        userService = new UserServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Dashboard Controller is requested ");
        int userID = getUserId(req);
        Detail userInfo = userService.getUserInfo(userID);
        log.info("User--------- : {}" ,userInfo.getUser().getUserName());
        log.info("User Photo--------- : {}" ,userInfo.getUser().getUserName());
        req.setAttribute("userInfo",userInfo);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/dashboard/profile_overview.jsp");
        requestDispatcher.forward(req, resp);
    }

    private Integer getUserId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getUserId();
    }
}
