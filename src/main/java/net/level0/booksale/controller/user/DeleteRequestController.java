package net.level0.booksale.controller.user;

import net.level0.booksale.service.BookService;
import net.level0.booksale.service.BookServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by panthotanvir on 12/13/14.
 */
@WebServlet(name = "DeleteRequestController", urlPatterns = "/deleteRequest")
public class DeleteRequestController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(RequestController.class);

    private BookService bookService;

    public DeleteRequestController() {

        bookService = new BookServiceImp();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("request Delete Controller is called");
        Integer requestId = Integer.parseInt(req.getParameter("request_id"));
        bookService.deleteRequest(requestId);
        resp.sendRedirect(req.getContextPath() + "/request");
    }
}
