package com.zone.codezone.Servlet;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Models.Competence;
import com.zone.codezone.Models.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "QuestionServlet", urlPatterns = {"/test/question"})
public class QuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("/CodeZone/login");
        } else {
            ArrayList<Test> tests = DaoFactory.getTestDao().findAll();
            System.out.println(tests);
            request.setAttribute("tests", tests);
            request.getRequestDispatcher("/question.jsp").forward(request, response);
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
