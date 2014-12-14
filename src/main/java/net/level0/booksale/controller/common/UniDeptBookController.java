package net.level0.booksale.controller.common;

import net.level0.booksale.domain.Book;
import net.level0.booksale.domain.Detail;
import net.level0.booksale.domain.University;
import net.level0.booksale.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author: mithunshawon
 * Date: 12/13/14
 * Time: 7:40 PM
 */
@WebServlet(name = "UniDeptBookController", urlPatterns = "/unidept")
public class UniDeptBookController extends HttpServlet{
    private static final Logger log = LoggerFactory.getLogger(UniDeptBookController.class);


    private BookService bookService;
    private UserService userService;
    private UniService uniService;
    private List<University> uniList;
    private HashMap<University, List<University>> uniDeptList;

    public UniDeptBookController() {
        bookService = new BookServiceImp();
        uniService = new UniServiceImp();
        userService = new UserServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int uniId = Integer.parseInt(req.getParameter("uniId"));
        int deptId = Integer.parseInt(req.getParameter("deptId"));
        log.debug("uniID in University   {}",uniId);
        log.debug("deptID in University   {}",deptId);
        List<Detail> divisionList = userService.getAllDivision();
        log.debug("divisionList size",divisionList.size());
        List<Book> bookList = bookService.getUniDeptBookList(uniId, deptId);
        uniList = uniService.getAllUniversity();
        uniDeptList = new HashMap<University, List<University>>();
        for(University university: uniList){
            uniDeptList.put(university, uniService.getSpecificUniDept(university.getId()));
        }
        req.setAttribute("uniDeptList", uniDeptList);

        req.setAttribute("bookList",bookList);
        req.setAttribute("divisionList",divisionList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/book/all_book_show.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect(req.getContextPath());
    }
}
