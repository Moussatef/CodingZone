package com.zone.codezone.Servlet;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Helpers.UuidHelper;
import com.zone.codezone.Models.Competence;
import com.zone.codezone.Models.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet(name = "TestServlet", urlPatterns = {"/add-test"})
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Competence> competences = DaoFactory.getCompetenceDao().findAll();
        request.setAttribute("competence", competences);

         if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("login");
         } else {
            request.getRequestDispatcher("test.jsp").forward(request, response);
         }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = UuidHelper.getUuiId();
        String title = request.getParameter("title");
        Date startDate = Date.valueOf(request.getParameter("start_date"));
        Date endDate = Date.valueOf(request.getParameter("end_date"));
        String comp = request.getParameter("competence");

        try {
            Competence competence = DaoFactory.getCompetenceDao().findById(comp);

            Test test = new Test(id,title,startDate,endDate,competence);
            DaoFactory.getTestDao().insert(test);

            request.getRequestDispatcher("dashboard.jsp").forward(request, response);


        } catch (Exception e) {
            request.setAttribute("error", "Something went wrong please try again.");
            e.printStackTrace();
            request.getRequestDispatcher("test.jsp").forward(request, response);

        }

    }
}
