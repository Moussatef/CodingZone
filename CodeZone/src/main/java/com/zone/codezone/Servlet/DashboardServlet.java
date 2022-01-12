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

@WebServlet(name = "DashboardServlet", urlPatterns = {"/Dashboard", "/Dashboard/*"})
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
        // it should be direct
        String id = this.randomId();
        String title = request.getParameter("title");
        Date startDate = Date.valueOf(request.getParameter("start_date"));
        Date endDate = Date.valueOf(request.getParameter("end_date"));
        String comp = request.getParameter("competence");

        Competence competence = new Competence("RFSNN1GEPM", comp);

        Test test = new Test(id,title,startDate,endDate,competence);
        System.out.println(DaoFactory.getTest().insert(test));

    }

    // put this in Helpers
    public String randomId() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString().toUpperCase(Locale.ROOT);

        return generatedString;
    }
}
