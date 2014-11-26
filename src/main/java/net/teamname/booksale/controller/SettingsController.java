package net.teamname.booksale.controller;

import net.teamname.booksale.domain.User;
import net.teamname.booksale.service.UserServiceImp;
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
 * Created by panthotanvir on 11/26/14.
 */
@WebServlet(name = "SettingsController", urlPatterns = "/settings")
public class SettingsController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(SettingsController.class);
    private User user;
    private UserServiceImp userService;

    public SettingsController() {
        userService = new UserServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Dashboard Controller is requested ");
        /*Integer userID = getUserId(req);
        Detail userInfo = userService.getUserInfo(userID);
        log.info("User--------- : {}" ,userInfo.getUserName());
        req.setAttribute("userInfo",userInfo);
        */
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/dashboard/settings.jsp");
        requestDispatcher.forward(req, resp);
    }

    private Integer getUserId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getUserId();
    }
}

