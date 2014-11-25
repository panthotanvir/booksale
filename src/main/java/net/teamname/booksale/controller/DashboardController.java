package net.teamname.booksale.controller;


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
 * Created on 11/25/14 3:25 PM.
 *
 * @author: mithunshawon
 */
@WebServlet(name = "DashboardController", urlPatterns = "/dashboard")
public class DashboardController extends HttpServlet{
    private static final Logger log = LoggerFactory.getLogger(DashboardController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Dashboard Controller is requested ");


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/dashboard/profile.jsp");
        requestDispatcher.forward(req, resp);
    }
}
