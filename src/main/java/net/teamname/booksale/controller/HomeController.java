package net.teamname.booksale.controller;

import net.teamname.booksale.domain.University;
import net.teamname.booksale.service.UniServiceImp;
import net.teamname.booksale.domain.Book;
import net.teamname.booksale.service.BookServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns = "/home")
public class HomeController extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Home Controller is requested ");

        List<Book>  bookList = getAllBookList();

        log.info("Book list size : {}" ,bookList.size() );
         req.setAttribute("bookList",bookList);
        //List<University>  uniList = getAllUniList();
       // log.info("University lis size : {}" ,uniList.size() );
       // req.setAttribute("uniList",uniList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/book/all_book_show.jsp");
        requestDispatcher.forward(req, resp);
    }

   /*private List<University> getAllUniList()  {
       return new UniServiceImp().getAllUniversity();
    }*/
   private List<Book> getAllBookList()  {
       return new BookServiceImp().getAllBookPost();
   }
}