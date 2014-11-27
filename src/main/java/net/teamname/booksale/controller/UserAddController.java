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
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
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

        req.setAttribute("uniList", uniList);
        req.setAttribute("deptList",deptList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/user/user_registration.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("data post ");
        createUserFromRequest(req);
        userService.addUser(user);

        log.debug("User is added");
        resp.sendRedirect(req.getContextPath() + "/home");
    }

    private void createUserFromRequest(HttpServletRequest req) throws IOException, ServletException {
        user = new User();
        Integer uniId = Integer.parseInt(req.getParameter("uni_id"));
        Integer deptId = Integer.parseInt(req.getParameter("dept_id"));
//        Integer userId = Integer.parseInt(req.getParameter("user_id"));

        InputStream inputStream = null;

        Part filePart = req.getPart("photo");
        log.debug("file:  {}",filePart);

        if (filePart == null) {
            log.debug("file name:  {}",filePart.getName());
            log.debug("file size:  {}",filePart.getSize());
            log.debug("file type:  {}",filePart.getContentType());
        }
        inputStream = filePart.getInputStream();
        log.debug("inputStream   :  {}",inputStream);

        user.setUserName(req.getParameter("user_name"));
        user.setUniId(uniId);
        user.setDeptId(deptId);
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setAddress(req.getParameter("address"));
        user.setPhoneNo(req.getParameter("phone"));
        user.setPhoto(inputStream);
    }

    private List<University> getAllUniList() {
        return new UniServiceImp().getAllUniversity();
    }
    private List<University> getAllDeptList() {
        return new UniServiceImp().getAllDept();
    }

}
