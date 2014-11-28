package net.level0.booksale.controller.user;

import net.level0.booksale.domain.User;
import net.level0.booksale.service.UserService;
import net.level0.booksale.service.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author panthotanvir
 * @since 11/28/14.
 */

@WebServlet(name = "UpdateUserController", urlPatterns = "/updateuser")
public class UpdateUserController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserAddController.class);

    public static final String UPDATE_URL = "updatepass";

    private User user;
    private UserService userService;

    public UpdateUserController() {
        userService = new UserServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestedURI = req.getRequestURI();
        if (requestedURI.contains(UPDATE_URL)) {

        }
    }

/*
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("data post ");
        updateUserFromRequest(req);
        userService.updateUser(user);

        log.debug("User is added");
        resp.sendRedirect(req.getContextPath() + "/home");
    }

    private void updateUserFromRequest(HttpServletRequest req) throws IOException, ServletException {


        Integer uniId = Integer.parseInt(req.getParameter("uni_id"));
        Integer deptId = Integer.parseInt(req.getParameter("dept_id"));
        Integer userId = Integer.parseInt(req.getParameter("user_id"));
        user = new User();
        user.setUserId(userId);
        user.setUserName(req.getParameter("user_name"));
        user.setUniId(uniId);
        user.setDeptId(deptId);

    }

*/

}
