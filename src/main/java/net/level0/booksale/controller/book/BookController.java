package net.level0.booksale.controller.book;

import net.level0.booksale.domain.Book;
import net.level0.booksale.domain.User;
import net.level0.booksale.service.BookService;
import net.level0.booksale.service.BookServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Created by panthotanvir on 11/22/14.
 */

@WebServlet(name = "BookAddController", urlPatterns = "/addbook")
@MultipartConfig(maxFileSize = 16177215)    // file size up to 16MB

public class BookController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);


    private Book book;
    private BookService bookService;

    public BookController() {
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
