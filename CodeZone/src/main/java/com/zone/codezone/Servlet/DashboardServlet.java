package com.zone.codezone.Servlet;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Models.Competence;
import com.zone.codezone.Models.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

@WebServlet(name = "DashboardServlet", urlPatterns = {"/dashboard"})
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Competence> competences = DaoFactory.getCompetenceDao().findAll();
        request.setAttribute("competence", competences);

         if (request.getSession().getAttribute("username") == null) {
           response.sendRedirect("login");
         } else {
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
         }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
