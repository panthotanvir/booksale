package net.level0.booksale.controller.common;

import net.level0.booksale.domain.Book;
import net.level0.booksale.domain.University;
import net.level0.booksale.service.BookService;
import net.level0.booksale.service.BookServiceImp;
import net.level0.booksale.service.UniService;
import net.level0.booksale.service.UniServiceImp;
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
 * Created by panthotanvir on 12/1/14.
 */

@WebServlet(name = "SidebarController", urlPatterns = "/sidebar")
public class SidebarController extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(SidebarController.class);

    private UniService uniService;
    private BookService bookService;

    public SidebarController() {
        uniService = new UniServiceImp();
        bookService = new BookServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Sidebar Controller is requested ");

        List<Book> bookList = bookService.getAllBookPost();
        List<University> uniList = uniService.getAllUniversity();

        log.info("Book list size : {}", bookList.size());
        log.info("University lis size : {}", uniList.size());
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