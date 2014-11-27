package net.teamname.booksale.controller;

import net.teamname.booksale.domain.Book;
import net.teamname.booksale.domain.User;
import net.teamname.booksale.service.BookServiceImp;
import net.teamname.booksale.service.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by panthotanvir on 11/22/14.
 */

@WebServlet(name = "BookAddController", urlPatterns = "/addbook")
@MultipartConfig(maxFileSize = 16177215)    // file size up to 16MB

public class BookAddController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(BookAddController.class);
    private Book book;
    private BookServiceImp bookService;

    public BookAddController() {
       bookService = new BookServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Book Add Controller is requested ");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/book/add_book.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createAddFromRequest(req);
        bookService.addBook(book);

        log.debug("New book posted ");
        resp.sendRedirect(req.getContextPath() + "/home");
    }

    private void createAddFromRequest(HttpServletRequest req) throws IOException, ServletException {
        book = new Book();
        log.debug("createAddFromRequest is called ");
//        InputStream inputStream = null;
//
//        Part filePart = req.getPart("photo") ;
//        inputStream = filePart.getInputStream();
//        if (filePart != null) {
//            log.debug("file name:  {}",filePart.getName());
//            log.debug("file size:  {}",filePart.getSize());
//            log.debug("file type:  {}",filePart.getContentType());
//        }
//        Integer userId = Integer.parseInt(req.getParameter("user_id"));
        Integer deptId = Integer.parseInt(req.getParameter("dept_id"));
        Double price = Double.parseDouble(req.getParameter("price"));

        book.setUserId(getUserId(req));
        book.setDeptId(deptId);
        book.setTitle(req.getParameter("title"));
        book.setAuthor(req.getParameter("author"));
        book.setPublisher(req.getParameter("publisher"));
        book.setType(req.getParameter("type"));
        book.setTag(req.getParameter("tag"));
        book.setDescription(req.getParameter("description"));
        book.setPrice(price);
//        book.setPhoto(inputStream);
        book.setPhoto(req.getParameter("photo"));
        book.setContactNo(req.getParameter("contact_no"));
        book.setContactAddress(req.getParameter("contact_address"));

        log.debug("book set updated");


    }

    private Integer getUserId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        log.debug("User Id from Session in bookController: {}",user.getUserId());
        return user.getUserId();
    }

}
