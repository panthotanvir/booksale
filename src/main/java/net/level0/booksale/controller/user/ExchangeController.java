package net.level0.booksale.controller.user;

import net.level0.booksale.domain.Book;
import net.level0.booksale.domain.Detail;
import net.level0.booksale.domain.University;
import net.level0.booksale.domain.User;
import net.level0.booksale.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by panthotanvir on 12/12/14.
 */
@WebServlet(name = "ExchangeController", urlPatterns = "/exchange")
public class ExchangeController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(RequestController.class);

    private Book book;
    private BookService bookService;
    private UserService userService;
    private List<University> uniList;
    private HashMap<University, List<University>> uniDeptList;
    private UniService uniService;

    public ExchangeController() {
        bookService = new BookServiceImp();
        userService = new UserServiceImp();
        uniService = new UniServiceImp();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = getUserId(req);
        Detail userInfo = userService.getUserInfo(userId);
        log.info("Exchange controller called");
        List<Book> exchangeList = bookService.getExchangeBook(userInfo.getUser().getUserId());

        log.info("User--------- : {}", userInfo.getUser().getUserName());
        log.info("exchange book list size : {}",exchangeList.size());
        uniList = uniService.getAllUniversity();
        uniDeptList = new HashMap<University, List<University>>();
        for(University university: uniList){
            uniDeptList.put(university, uniService.getSpecificUniDept(university.getId()));
        }
        req.setAttribute("uniDeptList", uniDeptList);
        req.setAttribute("userInfo", userInfo);
        req.setAttribute("exchangeList",exchangeList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/dashboard/exchange_book.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("exchange posted ");
        createExchangeForm(req);
        bookService.exchangeBook(book);

        resp.sendRedirect(req.getContextPath() + "/exchange");

    }
    private void createExchangeForm(HttpServletRequest req) throws IOException, ServletException{

        book = new Book();
        log.debug("create Exchange is called ");

        book.setUserId(getUserId(req));
        book.setDeptId(getDeptId(req));
        book.setExchangeTo(req.getParameter("exchange_to"));
        book.setExchangeWith(req.getParameter("exchange_with"));
        book.setDetail(req.getParameter("detail"));
    }

    private Integer getUserId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getUserId();
    }
    private Integer getDeptId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getDeptId();
    }
}
