package net.teamname.booksale.controller;

import net.teamname.booksale.domain.University;
import net.teamname.booksale.service.UniServiceImp;
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
        List<University>  uniList = getAllUniList();
        log.info("University lis size : {}" ,uniList.size() );
        req.setAttribute("uniList",uniList);
//        resp.setContentType("text/html");
//        PrintWriter pw = resp.getWriter();
//        pw.println("<html>");
//        pw.println("<body>");
//        pw.print(uniList.size());
//        pw.println("</body></html>");
       RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/user/home.jsp");
       requestDispatcher.forward(req, resp);
    }

    private List<University> getAllUniList()  {
        return new UniServiceImp().getAllUniversity();
    }
}