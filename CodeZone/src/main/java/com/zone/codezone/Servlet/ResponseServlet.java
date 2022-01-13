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

@WebServlet(name = "ResponseServlet", value = "/Answer")
public class ResponseServlet extends HttpServlet {
    List<Question> questionList;
    Question question;
    Choice choice;
    List<Choice> choices;
    public void getQuestions(String id){
        questionList=new ArrayList<Question>();
        questionList= DaoFactory.getQuestions().findQuestionsByTest(id);
    }

    public List<Choice> getChoices(String id){
      return DaoFactory.getDaoChoice().getQuestionChoices(id);

    }

    @Override
    public void init() throws ServletException {
        super.init();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String test_id=(String)request.getSession().getAttribute("test_id");
        String question_id=(String)request.getSession().getAttribute("question_id");
        getQuestions(test_id);
        //question=questionList.get(0);
        List<Choice> choices=getChoices(question_id);
        request.setAttribute("question",question);
        request.setAttribute("choices",choices);
        request.getRequestDispatcher("/views/response.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
