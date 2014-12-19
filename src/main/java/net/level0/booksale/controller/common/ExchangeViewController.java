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
 * Time: 9:56 PM
 */
@WebServlet(name = "ExchangeViewController", urlPatterns = "/exchangeview")
public class ExchangeViewController extends HttpServlet{

    private static final Logger log = LoggerFactory.getLogger(ExchangeViewController.class);

    private UserService userService;
    private UniService uniService;
    private BookService bookService;
    private HashMap<University, List<University>> uniDeptList;
    private List<University> uniList;
    List<Detail> divisionList;
    List<Book> bookList;

    public ExchangeViewController() {
        userService = new UserServiceImp();
        uniService = new UniServiceImp();
        bookService = new BookServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Detail> exchangeList = bookService.getExchangeList();
        log.info("exchangeList list size : {}", exchangeList.size());
        req.setAttribute("exchangeList", exchangeList);

//        divisionList = userService.getAllDivision();
//        log.info("division size : {}",divisionList.size());

        bookList = bookService.getAllBookPost();
        log.info("Book list size : {}", bookList.size());

        uniList = uniService.getAllUniversity();
        uniDeptList = new HashMap<University, List<University>>();
        for(University university: uniList){
            uniDeptList.put(university, uniService.getSpecificUniDept(university.getId()));
        }
        req.setAttribute("uniDeptList", uniDeptList);
//        req.setAttribute("divisionList",divisionList);
        req.setAttribute("bookList", bookList);
        req.setAttribute("uniList", uniList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/book/exchange_book.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }

}
