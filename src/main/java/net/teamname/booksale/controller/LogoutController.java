package net.teamname.booksale.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by panthotanvir on 11/25/14.
 */
@WebServlet(name = "LogoutController", urlPatterns = "/logout")
public class LogoutController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LogoutController.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        log.info("logout controller called");

      //  session.removeAttribute("isUser");
        log.info("before removing : {} ",session.getAttribute("user"));
        session.removeAttribute("user");
        session.removeAttribute("isUser");
        log.info("after removing : {} ",session.getAttribute("user"));
        log.info("after removing : {} ",session.getAttribute("isUser"));
        session.invalidate();
        response.sendRedirect(request.getContextPath());
    }
}
