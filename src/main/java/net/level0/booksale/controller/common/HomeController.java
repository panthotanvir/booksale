package net.level0.booksale.controller.common;

import net.level0.booksale.domain.Detail;
import net.level0.booksale.domain.University;
import net.level0.booksale.domain.User;
import net.level0.booksale.service.*;
import net.level0.booksale.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "HomeController", urlPatterns = "/home")
public class HomeController extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    private UserService userService;
    private UniService uniService;
    private BookService bookService;

    public HomeController() {
        userService = new UserServiceImp();
        uniService = new UniServiceImp();
        bookService = new BookServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Home Controller is requested ");


        List<Detail> divisionList = userService.getAllDivision();
        log.info("division size : {}",divisionList.size());

        List<Book> bookList = bookService.getAllBookPost();
        log.info("Book list size : {}", bookList.size());

        List<Book> latestBookList = bookService.getLatestBookPost();
        req.setAttribute("latestBookList",latestBookList);

        List<University> uniList = uniService.getAllUniversity();
        HashMap<University, List<University>> uniDeptList = new HashMap<University, List<University>>();
        for(University university: uniList){
            uniDeptList.put(university, uniService.getSpecificUniDept(university.getId()));
        }
        req.setAttribute("uniDeptList", uniDeptList);
        req.setAttribute("divisionList",divisionList);
        req.setAttribute("bookList", bookList);
        req.setAttribute("uniList", uniList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/book/welcome_page.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }

}