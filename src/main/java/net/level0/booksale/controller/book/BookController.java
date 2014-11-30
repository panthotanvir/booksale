package net.level0.booksale.controller.book;

import net.level0.booksale.domain.Book;
import net.level0.booksale.domain.University;
import net.level0.booksale.domain.User;
import net.level0.booksale.service.BookService;
import net.level0.booksale.service.BookServiceImp;
import net.level0.booksale.service.UniService;
import net.level0.booksale.service.UniServiceImp;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by panthotanvir on 11/22/14.
 */

@WebServlet(name = "BookAddController", urlPatterns = "/addbook")

public class BookController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    private final String UPLOAD_DIRECTORY = "/home/devil/therap/booksale/web/uploads/books";

    private Book book;
    private UniService uniService;
    private BookService bookService;


    public BookController() {

        bookService = new BookServiceImp();
        uniService = new UniServiceImp();
        book = new Book();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Book Add Controller is requested ");

        List<University> deptList = uniService.getAllDept();

        req.setAttribute("deptList", deptList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/book/add_book.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            createAddFromRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        log.debug("Book Description : ---> {}",book.getDescription());
        log.debug("Book photo : ---> {}",book.getPhoto());
        bookService.addBook(book);

        log.debug("New book posted ");
        resp.sendRedirect(req.getContextPath() + "/home");
    }

    private void createAddFromRequest(HttpServletRequest req) throws IOException, ServletException, FileUploadException {

        String fieldName = "";
        String value = "";
        String fileName = "";

        int userId = getUserId(req);
        book.setUserId(userId);

        log.debug("file request : {}", ServletFileUpload.isMultipartContent(req));
        FileItemFactory factory = new DiskFileItemFactory();

        ServletFileUpload upload = new ServletFileUpload(factory);

        List<FileItem> uploadItems = upload.parseRequest(req);

        for (FileItem uploadItem : uploadItems) {
            if (uploadItem.isFormField()) {
                fieldName = uploadItem.getFieldName();
                value = uploadItem.getString();
                log.debug("inside file uploader--->> {}:{}", fieldName, value);
                setProperty(fieldName, value);
            } else if (!uploadItem.isFormField()) {
                fieldName = uploadItem.getFieldName();
                value = new File(uploadItem.getName()).getName();
                log.debug("File Name in BookAddController--->> {}", value);

                try {
                    double tmp = Math.random();
                    fileName = tmp + value;
                    log.debug("file name final BookAddController: {}", fileName);
                    log.debug("file path final BookAddController: {}", UPLOAD_DIRECTORY + File.separator + fieldName);
                    uploadItem.write(new File(UPLOAD_DIRECTORY + File.separator + fileName));
                    setProperty(fieldName, fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }


    private Book setProperty(String fieldName, String value) {
        if (fieldName.equals("dept_id")) {
            int deptId = Integer.parseInt(value);
            book.setDeptId(deptId);
        } else if (fieldName.equals("title")) {
            book.setTitle(value);
        } else if (fieldName.equals("author")) {
            book.setAuthor(value);
        } else if (fieldName.equals("publisher")) {
            book.setPublisher(value);
        } else if (fieldName.equals("type")) {
            book.setType(value);
        } else if (fieldName.equals("tag")) {
            book.setTag(value);
        } else if (fieldName.equals("description")) {
            book.setDescription(value);
        } else if (fieldName.equals("price")) {
            double price = Double.parseDouble(value);
            book.setPrice(price);
        } else if (fieldName.equals("photo")) {
            book.setPhoto(value);
        } else if (fieldName.equals("contact_no")) {
            book.setContactNo(value);
        } else if (fieldName.equals("contact_address")) {
            book.setContactAddress(value);
        }

        return book;
    }

    private Integer getUserId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        log.debug("User Id from Session in bookController: {}", user.getUserId());
        return user.getUserId();
    }

}
