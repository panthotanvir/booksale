package net.level0.booksale.controller.common;

import net.level0.booksale.domain.University;
import net.level0.booksale.domain.User;
import net.level0.booksale.service.UniServiceImp;
import net.level0.booksale.domain.Book;
import net.level0.booksale.service.BookServiceImp;
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

@WebServlet(name = "HomeController", urlPatterns = "/home")
public class HomeController extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Home Controller is requested ");

        List<Book> bookList = getAllBookList();
        List<University> uniList = getAllUniList();

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

    private List<University> getAllUniList() {
        return new UniServiceImp().getAllUniversity();
    }

    private List<Book> getAllBookList() {
        return new BookServiceImp().getAllBookPost();
    }


}