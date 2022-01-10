package com.zone.codezone.Servlet;

import com.zone.codezone.Dao.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletLogin", value = "/servlet-login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // login and redirect to index.jsp
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (DaoFactory.getDaoStaff().login(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("dashboard.jsp");

        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
