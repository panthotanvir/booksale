package net.level0.booksale.controller.user;

import net.level0.booksale.domain.User;
import net.level0.booksale.service.BookServiceImp;
import net.level0.booksale.service.UserService;
import net.level0.booksale.service.UserServiceImp;
import net.level0.booksale.util.validator.UserValidator;
import org.apache.commons.fileupload.FileUploadException;
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
 * Created by panthotanvir on 12/9/14.
 */
@WebServlet(name = "RatingController", urlPatterns = "/rating")
public class RatingController extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(RatingController.class);

    private User user;
    private UserService userService;

    public RatingController() {

        userService = new UserServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            createUserRating(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        userService.rateUser(user);
        resp.sendRedirect(req.getContextPath() + "/home");

    }

    private void createUserRating(HttpServletRequest req) throws IOException, ServletException, FileUploadException {

        Integer rating = Integer.parseInt(req.getParameter("rate"));
        Integer userId = Integer.parseInt(req.getParameter("userId"));
        Integer viewerId = getUserId(req);

        log.info("rating : {}",rating);
        log.info("userId : {}",userId);
        log.info("viewerId : {}",viewerId);
        user = new User();
        user.setUserId(userId);
        user.setViewerId(viewerId);
        user.setRate(rating);

    }

    private int getUserId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getUserId();
    }
}

