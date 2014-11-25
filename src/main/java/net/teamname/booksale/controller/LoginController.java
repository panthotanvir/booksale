package net.teamname.booksale.controller;

import net.teamname.booksale.domain.User;
import net.teamname.booksale.service.UserService;
import net.teamname.booksale.service.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by devil on 11/15/14.
 */
@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.debug("BLogin Controller is requested ");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/user/user_login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("userEmail");
        String password = req.getParameter("userPassword");

        log.debug("email {}, password {}",email,password);

        if (isUserVerified(email, password)) {
            setUpSession(req);
            log.debug("Home controller redirected ");
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            resp.sendRedirect(req.getContextPath());
        }
    }

    private boolean isUserVerified(String email, String password) {
        UserService userService = new UserServiceImp();
        user = userService.getUser(email, password);
        return user != null;
    }

    private void setUpSession(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        session.setAttribute("authenticatedUser", true);
        log.info("isUser {}", user.isUser());
        session.setAttribute("isUser", user.isUser());
        log.debug("Session is set");
    }
}

