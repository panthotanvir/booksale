package net.teamname.booksale.controller;

import net.teamname.booksale.domain.University;
import net.teamname.booksale.domain.User;
import net.teamname.booksale.service.UniServiceImp;
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
import java.sql.Timestamp;
import java.util.List;

/**
 * Created on 11/22/14 2:59 PM.
 *
 * @author: mithunshawon
 */

@WebServlet(name = "UserAddController", urlPatterns = "/adduser")
public class UserAddController extends HttpServlet{
    private static final Logger log = LoggerFactory.getLogger(UserAddController.class);
    private User user;
    private UserServiceImp userService;

    public UserAddController() {
        userService = new UserServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("User Registration Controller is requested ");
        List<University> uniList = getAllUniList();
        List<University> deptList = getAllDeptList();

        log.info("Uni List Size in UserAddController : {} " , uniList.size());
        log.info("Dept List Size in UserAddController : {} " , deptList.size());
        log.info("Dept List Size in UserAddController : {} " , deptList.get(0).getDeptId());
        req.setAttribute("uniList",uniList);
        req.setAttribute("deptList",deptList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/user/user_registration.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createUserFromRequest(req);
        userService.addUser(user);

        log.debug("User is added");
        resp.sendRedirect(req.getContextPath() + "/home");
    }

    private void createUserFromRequest(HttpServletRequest req) {
        user = new User();
        Integer uniId = Integer.parseInt(req.getParameter("uni_id"));
        Integer deptId = Integer.parseInt(req.getParameter("dept_id"));

        user.setUserName(req.getParameter("user_name"));
        user.setUniId(uniId);
        user.setDeptId(deptId);
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setAddress(req.getParameter("address"));
        user.setPhoneNo(req.getParameter("phone"));
    }

    private List<University> getAllUniList() {
        return new UniServiceImp().getAllUniversity();
    }
    private List<University> getAllDeptList() {
        return new UniServiceImp().getAllDept();
    }

}
