package net.level0.booksale.controller.common;

import net.level0.booksale.domain.Book;
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

    public UniDeptBookController() {
        bookService = new BookServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int uniId = Integer.parseInt(req.getParameter("uniId"));
        int deptId = Integer.parseInt(req.getParameter("deptId"));
        log.debug("uniID in University   {}",uniId);
        log.debug("deptID in University   {}",deptId);
        List<Book> bookList = bookService.getUniDeptBookList(uniId, deptId);

        req.setAttribute("bookList",bookList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/book/all_book_show.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect(req.getContextPath());
    }
}
