package com.zone.codezone.Servlet;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Helpers.MailHelper;
import com.zone.codezone.Helpers.UuidHelper;
import com.zone.codezone.Models.Choice;
import com.zone.codezone.Models.Question;
import com.zone.codezone.Models.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuestionAndChoisServlet", urlPatterns = {"/test/question-chois"})
public class QuestionAndChoisServlet extends HttpServlet {
    Question question = null;
    Choice choice = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String content = request.getParameter("content");
        int time  = Integer.parseInt(request.getParameter("time"));
        double score = Double.parseDouble(request.getParameter("score"));
        String test_id = request.getParameter("test_id");
        Test test = DaoFactory.getTestDao().findById(test_id);
        String radioBtn = request.getParameter("flexRadioDefault");
        String question_id = UuidHelper.getUuiId();

        String chose_one = request.getParameter("chose_one");
        String chose_tow = request.getParameter("chose_tow");
        String chose_three = request.getParameter("chose_three");
        String chose_four = request.getParameter("chose_four");

        System.out.println(content);

        question = DaoFactory.getQuestions().create(new Question(question_id,content,time,score,test));
        if(question != null) {

            Choice choice1 =  DaoFactory.getDaoChoice().insert(new Choice(UuidHelper.getUuiId(), chose_one, radioBtn.equals("chose_one"), question));
            Choice choice2 =  DaoFactory.getDaoChoice().insert(new Choice(UuidHelper.getUuiId(), chose_tow, radioBtn.equals("chose_tow"), question));
            Choice choice3 =  DaoFactory.getDaoChoice().insert(new Choice(UuidHelper.getUuiId(), chose_three, radioBtn.equals("chose_three"), question));
            Choice choice4 =  DaoFactory.getDaoChoice().insert(new Choice(UuidHelper.getUuiId(), chose_four, radioBtn.equals("chose_four"), question));
            if (choice1 != null && choice2 != null && choice3 != null && choice4 != null ){
                HttpSession session = request.getSession();
                session.setAttribute("messageSuccess", "Question save with success ! ");


                response.sendRedirect(request.getContextPath()+"/dashboard");
            }
        }

        System.out.println(question.getContent());

    }
}
