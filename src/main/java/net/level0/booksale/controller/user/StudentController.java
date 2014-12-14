package net.level0.booksale.controller.user;

import net.level0.booksale.domain.Detail;
import net.level0.booksale.domain.University;
import net.level0.booksale.domain.User;
import net.level0.booksale.service.UniService;
import net.level0.booksale.service.UniServiceImp;
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
import java.util.HashMap;
import java.util.List;

/**
 * Created by panthotanvir on 11/26/14.
 */
@WebServlet(name = "FellowStudentController", urlPatterns = "/fellow")
public class StudentController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    private User user;
    private UserServiceImp userService;
    private HashMap<University, List<University>> uniDeptList;
    private List<University> uniList;
    private UniService uniService;

    public StudentController() {
        userService = new UserServiceImp();
        uniService = new UniServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Fellow Controller is requested ");
        int userID = getUserId(req);
        Integer uniId = getUniId(req);
        Integer deptId = getDeptId(req);
        List<Detail> userDept = userService.getUserDept(userID, uniId, deptId);
        req.setAttribute("userDept",userDept);

        Detail userInfo = userService.getUserInfo(userID);
        uniList = uniService.getAllUniversity();
        uniDeptList = new HashMap<University, List<University>>();
        for(University university: uniList){
            uniDeptList.put(university, uniService.getSpecificUniDept(university.getId()));
        }
        req.setAttribute("uniDeptList", uniDeptList);
        req.setAttribute("userInfo",userInfo);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/dashboard/fellow_students.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }

    private Integer getUniId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getUniId();
    }
    private Integer getDeptId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getDeptId();
    }
    private Integer getUserId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getUserId();
    }

}

