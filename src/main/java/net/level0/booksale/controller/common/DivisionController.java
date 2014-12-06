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
 * Created by panthotanvir on 12/5/14.
 */
@WebServlet(name = "DivisionController", urlPatterns = "/division")
public class DivisionController extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(SidebarController.class);

    private UniService uniService;
    private BookService bookService;
    private UserService userService;

    public DivisionController() {
        uniService = new UniServiceImp();
        bookService = new BookServiceImp();
        userService = new UserServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("division Controller is requested ");

        Integer divisionId = Integer.parseInt(req.getParameter("divisionId"));

        List<Book> divisionBookList = bookService.getDivisionBook(divisionId);

        List<Detail> divisionList = userService.getAllDivision();
        log.info("division size : {}",divisionList.size());

        log.info("Division Book list size : {}", divisionBookList.size());

        req.setAttribute("divisionBook", divisionBookList);
        req.setAttribute("divisionList",divisionList);;


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/book/division_book.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }


}
