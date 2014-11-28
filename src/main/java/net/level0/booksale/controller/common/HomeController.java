package net.level0.booksale.controller.common;

import net.level0.booksale.domain.University;
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
//        List<University> deptList = getSpecificDeptList(uniList);
        log.info("Book list size : {}" ,bookList.size() );
        log.info("University lis size : {}" ,uniList.size() );
        req.setAttribute("bookList",bookList);
        req.setAttribute("uniList",uniList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/book/all_book_show.jsp");
        requestDispatcher.forward(req, resp);
    }

//    private List<University> getSpecificDeptList(List<University> uniList) {
//        return new UniServiceImp().getSpecificUniDept(uniList);
//    }

    private List<University> getAllUniList()  { return new UniServiceImp().getAllUniversity();}

    private List<Book> getAllBookList()  {
       return new BookServiceImp().getAllBookPost();
   }


}