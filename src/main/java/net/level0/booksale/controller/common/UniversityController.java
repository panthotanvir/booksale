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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by panthotanvir on 12/4/14.
 */
@WebServlet(name = "UniversityController", urlPatterns = "/university")
public class UniversityController extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(SidebarController.class);

    private UniService uniService;
    private BookService bookService;
    private UserService userService;

    public UniversityController() {
        uniService = new UniServiceImp();
        bookService = new BookServiceImp();
        userService = new UserServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("University Controller is requested ");

        Integer uniType = Integer.parseInt(req.getParameter("uniType"));
        log.info("university type no : {}",uniType);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }


}