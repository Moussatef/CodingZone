package com.zone.codezone.Servlet;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Models.Choice;
import com.zone.codezone.Models.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LernerServlet", value = "/LernerServlet")
public class LernerServlet extends HttpServlet {

    List<Question> questionList;
    Question question;
    Choice choice;
    List<Choice> choices;


    public List<Question> getQuestions(String id){

        return  DaoFactory.getQuestions().findQuestionsByTest(id);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        questionList=getQuestions("1");
        HttpSession session = request.getSession();
        session.setAttribute("test_id", "1");
        session.setAttribute("currentIndex", -1);
        session.setAttribute("questions",questionList);
        //questionList= getQuestions("1");
        request.setAttribute("questions",questionList);
        session.setAttribute("lastIndex", questionList.size()-1);
        response.sendRedirect("Answer");
       // request.getRequestDispatcher("Answer").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
