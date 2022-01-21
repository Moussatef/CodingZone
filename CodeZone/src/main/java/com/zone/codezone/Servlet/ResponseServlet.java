package com.zone.codezone.Servlet;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Helpers.MailHelper;
import com.zone.codezone.Models.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ResponseServlet", value = "/Answer")
public class ResponseServlet extends HttpServlet {
   // List<Question> questionList;
    Question question;
    Choice choice;
    List<Choice> choices;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public List<Choice> getChoices(String id){
      return DaoFactory.getDaoChoice().getQuestionChoices(id);

    }

    @Override
    public void init() throws ServletException {
        super.init();

    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("im in response ");
        System.out.println(request.getSession().getAttribute("questions"));
        if((List<Question>)request.getSession().getAttribute("questions") !=null)
        if( ((List<Question>)request.getSession().getAttribute("questions")).size()>0 && ((int)request.getSession().getAttribute("currentIndex")) <=((List<Question>)request.getSession().getAttribute("questions")).size()-2){
            int index=(int)request.getSession().getAttribute("currentIndex")+1;
            request.getSession().setAttribute("currentIndex",index);
            question=((List<Question>)request.getSession().getAttribute("questions")).get(index);
            List<Choice> choices=getChoices(question.getId());
            request.setAttribute("question",question);
            request.setAttribute("choices",choices);
            request.getRequestDispatcher("/views/response.jsp").forward(request,response);

        }else if(((int)request.getSession().getAttribute("currentIndex")) >((List<Question>)request.getSession().getAttribute("questions")).size()-2){
            double score=DaoFactory.getDaoTestResponse().getLearnerScore((String)(request.getSession().getAttribute("code")));
            double total=DaoFactory.getTestDao().getTestTotalScore((String)request.getSession().getAttribute("test_id"));
            double learnerPer=(score/total)*100;
            System.out.println(score+"ff "+total+" k "+learnerPer);
            MailHelper.scoreMail(DaoFactory.getDaoLearner().findEmailByCode((String)(request.getSession().getAttribute("code"))),DaoFactory.getTestDao().findById((String)request.getSession().getAttribute("test_id")).getTitle(),df.format(learnerPer)+" % ");
            request.getRequestDispatcher("/views/ThankYou.jsp").forward(request,response);
        }else{
            response.sendRedirect("LernerServlet");
        }
        else {
            response.sendRedirect("LernerServlet");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //change timer-response
        String choice_id = request.getParameter("choice");
        int time = Integer.parseInt(request.getParameter("time"));
        TestCandidat testCandidat=(TestCandidat)request.getSession().getAttribute("test_details");
       // Test test=DaoFactory.getTestDao().findById(((String) request.getSession().getAttribute("test_id")));
        if(choice_id !=null){
            Choice choice =DaoFactory.getDaoChoice().findById(choice_id);
            DaoFactory.getDaoTestResponse().insert(new TestResponse(null,question,choice,time,testCandidat));
        }
        else {
            DaoFactory.getDaoTestResponse().insert(new TestResponse(null,question,null,time,testCandidat));
        }
        System.out.println(choice_id);
        doGet(request,response);
    }
}
