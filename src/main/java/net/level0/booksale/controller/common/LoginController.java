package net.level0.booksale.controller.common;

import net.level0.booksale.domain.University;
import net.level0.booksale.domain.User;
import net.level0.booksale.service.UniService;
import net.level0.booksale.service.UniServiceImp;
import net.level0.booksale.service.UserService;
import net.level0.booksale.service.UserServiceImp;
import net.level0.booksale.util.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mithunshawon on 11/15/14.
 */
@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    private User user;
    private UniService uniService;
    private List<University> uniList;
    private HashMap<University, List<University>> uniDeptList;

    public LoginController(){
        uniService = new UniServiceImp();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        uniList = uniService.getAllUniversity();
        uniDeptList = new HashMap<University, List<University>>();
        for(University university: uniList){
            uniDeptList.put(university, uniService.getSpecificUniDept(university.getId()));
        }
        req.setAttribute("uniDeptList", uniDeptList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/user/user_login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("userPassword");

        log.debug("email {}, password {}",email,password);

        boolean isUserValid = UserValidator.validateEmailAndPassword(email,password);

            if (isUserValid) {
                if (isUserVerified(email, password)) {
                    setUpSession(req);
                    log.debug("Home controller redirected ");
                    resp.sendRedirect(req.getContextPath() + "/home");
                } else {
                    req.setAttribute("message", "Invalid User, try again");
                    log.debug("Invalid User in Login Controller");
                    req.setAttribute("uniDeptList", uniDeptList);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/user/user_login.jsp");
                    requestDispatcher.forward(req, resp);
                }
            } else {
                req.setAttribute("message","Some fields are empty");
                log.debug("------------------",isUserValid);
                req.setAttribute("uniDeptList", uniDeptList);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/user/user_login.jsp");
                requestDispatcher.forward(req, resp);
            }
    }

    private boolean isUserVerified(String email, String password) {
        UserService userService = new UserServiceImp();
        user = userService.getUser(email, password);
        if(user != null) {
            return true;
        }
        return false;
    }

    private void setUpSession(HttpServletRequest req) {
        HttpSession session = req.getSession();

        session.setAttribute("user", user);
        session.setAttribute("authenticatedUser", true);
        log.info("isUser before {}", user.isUser());
        session.setAttribute("isUser", user.isUser());
        log.info("isUser {}", user.isUser());
        session.setAttribute("userId",user.getUserId());
        log.info("session user ID : {}",user.getUserId());
        session.setAttribute("uniId", user.getUniId());
        log.info("Uni Id after set : {}", user.getUniId());
        session.setAttribute("deptId", user.getDeptId());
        log.debug("Session is set");
    }
}

