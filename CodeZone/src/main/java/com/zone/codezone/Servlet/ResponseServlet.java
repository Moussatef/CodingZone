package com.zone.codezone.Servlet;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Models.Choice;
import com.zone.codezone.Models.Question;
import com.zone.codezone.Models.Test;
import com.zone.codezone.Models.TestResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ResponseServlet", value = "/Answer")
public class ResponseServlet extends HttpServlet {
   // List<Question> questionList;
    Question question;
    Choice choice;
    List<Choice> choices;


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
            request.getRequestDispatcher("/views/ThankYou.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choice_id = request.getParameter("choice");
        if(choice_id !=null){
            Choice choice =DaoFactory.getDaoChoice().findById(choice_id);
            Test test=DaoFactory.getTestDao().findById(((String) request.getSession().getAttribute("test_id")));
            DaoFactory.getDaoTestResponse().insert(new TestResponse("id",choice,2,test,));
        }
        else {

        }
        System.out.println(choice_id);
        doGet(request,response);
    }
}
