package net.teamname.booksale.controller;

import net.teamname.booksale.domain.Book;
import net.teamname.booksale.domain.University;
import net.teamname.booksale.domain.User;
import net.teamname.booksale.service.BookServiceImp;
import net.teamname.booksale.service.UniServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by panthotanvir on 11/27/14.
 */

@WebServlet(name = "UserHomeController", urlPatterns = "/userhome")
public class UserHomeController extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserHomeController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("User Home Controller is requested ");

        Integer deptId = getDeptId(req);
        List<Book> deptBookList = getDeptBookList(deptId);
        //List<University> uniList = getAllUniList();
//        List<University> deptList = getSpecificDeptList(uniList);
        log.info("Dept Book list size : {}" ,deptBookList.size() );
     //   log.info("University lis size : {}" ,uniList.size() );
        req.setAttribute("bookList",deptBookList);
      //  req.setAttribute("uniList",uniList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/book/dept_book_show.jsp");
        requestDispatcher.forward(req, resp);
    }

//    private List<University> getSpecificDeptList(List<University> uniList) {
//        return new UniServiceImp().getSpecificUniDept(uniList);
//    }

  // private List<University> getAllUniList()  { return new UniServiceImp().getAllUniversity();}

    private List<Book> getDeptBookList(Integer deptId)  {
        return new BookServiceImp().getDeptBook(deptId);
    }

    private Integer getDeptId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getUserId();
    }


}