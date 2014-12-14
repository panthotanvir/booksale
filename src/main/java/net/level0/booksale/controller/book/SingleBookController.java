package net.level0.booksale.controller.book;

import net.level0.booksale.domain.Book;
import net.level0.booksale.domain.Detail;
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created on 11/24/14 12:43 AM.
 *
 * @author: mithunshawon
 *
 **/
@WebServlet(name="SingleBookController", urlPatterns = "/singleBook")
public class SingleBookController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(SingleBookController.class);

    private UniService uniService;

    private List<University> uniList;
    private HashMap<University, List<University>> uniDeptList;

    public SingleBookController(){
        uniService = new UniServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer bookId = Integer.parseInt(req.getParameter("bookId"));
        log.debug("Single book controller called");

        BookService bookService = new BookServiceImp();

        Detail singleBook = bookService.getBook(bookId);

        log.info("User--------- : {}" ,singleBook.getUser().getUserName());
        log.info("dept Name in Single book : {} ",singleBook.getUniversity().getDeptName());

        Integer deptId = singleBook.getBook().getBookId();
        List<Book> recommendedBookList = bookService.getRecommenededBook(deptId,bookId);
        uniList = uniService.getAllUniversity();
        uniDeptList = new HashMap<University, List<University>>();
        for(University university: uniList){
            uniDeptList.put(university, uniService.getSpecificUniDept(university.getId()));
        }
        req.setAttribute("uniDeptList", uniDeptList);

        req.setAttribute("bookInfo",singleBook);
        req.setAttribute("recommendedBook",recommendedBookList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/book/single_book.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }

}
