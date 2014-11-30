package net.level0.booksale.controller.book;

import net.level0.booksale.domain.Book;
import net.level0.booksale.service.BookService;
import net.level0.booksale.service.BookServiceImp;
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
 * Created on 11/28/14 12:36 PM.
 *
 * @author: mithunshawon
 */

@WebServlet(name = "SearchController", urlPatterns = "/search")
public class SearchController extends HttpServlet{
    private static final Logger log = LoggerFactory.getLogger(SearchController.class);

    BookService bookService = null;

    public SearchController() {
        bookService = new BookServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("SearchController requested");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/search/search.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyWord = req.getParameter("search_key");
        String searchKey = req.getParameter("key");
        log.debug("Search key  :  {}",searchKey);

        List<Book>bookList = FindSearchList(keyWord,searchKey);
        log.info("Book list size : {}" ,bookList.size() );
        req.setAttribute("bookList",bookList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/search/search.jsp");
        requestDispatcher.forward(req, resp);

    }

    private List<Book> FindSearchList(String keyWord, String key) {

        if(keyWord.equals("title")){
            return bookService.searchTitleBookList(key);
        }
        else if(keyWord.equals("author")){
            return bookService.searchAuthorBookList(key);
        }
        else if(keyWord.equals("publisher")){
            return bookService.searchPublisherBookList(key);
        }
        return  null;
    }
}
