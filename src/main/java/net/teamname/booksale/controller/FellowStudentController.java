package net.teamname.booksale.controller;

import net.teamname.booksale.domain.Book;
import net.teamname.booksale.domain.Detail;
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
import java.util.List;

/**
 * Created by panthotanvir on 11/26/14.
 */
@WebServlet(name = "FellowStudentController", urlPatterns = "/fellow")
public class FellowStudentController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(FellowStudentController.class);
    private User user;
    private UserServiceImp userService;

    public FellowStudentController() {
        userService = new UserServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Fellow Controller is requested ");
        Integer uniId = getUniId(req);
        Integer deptId = getDeptId(req);
        List<Detail> userDept = userService.getUserDept(uniId, deptId);
        req.setAttribute("userDept",userDept);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/dashboard/fellow_students.jsp");
        requestDispatcher.forward(req, resp);
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
}

