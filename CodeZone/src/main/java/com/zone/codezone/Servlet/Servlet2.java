package com.zone.codezone.Servlet;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Helpers.UuidHelper;
import com.zone.codezone.Models.Competence;
import com.zone.codezone.Models.Question;
import com.zone.codezone.Models.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet2", value = "/Servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("ly.jsp").forward(request, response);
/*
        List<Question>  questionList = DaoFactory.getQuestions().findAll();
        Competence competence = new Competence("UU","DATABASE");
        Test test = new Test("vyyyuytg","Test", Date.valueOf("2002-10-10"),Date.valueOf("2010-10-10"),competence);
        Question questionUp = new Question(UuidHelper.getUuiId(),"Teste question",200,10,test);
        String id_update = DaoFactory.getQuestions().update(questionUp);
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for (Question question:questionList)
            out.println("<h2>"+ question.getContent()+"</h2>");


        out.println("<h2> 3aaafak </h2>");
        out.println("</body></html>");*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
