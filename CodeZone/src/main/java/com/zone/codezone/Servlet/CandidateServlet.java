package com.zone.codezone.Servlet;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Helpers.MailHelper;
import com.zone.codezone.Helpers.UuidHelper;
import com.zone.codezone.Models.Learner;
import com.zone.codezone.Models.Staff;
import com.zone.codezone.Models.Test;
import com.zone.codezone.Models.TestCandidat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CandidateServlet", urlPatterns = {"/test/candidate-test"})
public class CandidateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("login");
        } else {
            request.getRequestDispatcher("/candidatTest.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String test_id = request.getParameter("test");
        String[] items = request.getParameterValues("candidats");
        Test test = DaoFactory.getTestDao().findById(test_id);
        for(int i = 0; i<items.length; i++){
            System.out.print(items[i] + "\n");
            String code_test = UuidHelper.getUuiId();
            Learner learner = DaoFactory.getDaoLearner().findById(items[i]) ;
           TestCandidat testCandidat =  DaoFactory.getTestCandidateDao().insert(new TestCandidat(UuidHelper.getUuiId(),code_test,test,learner,false));
            //System.out.println(testCandidat.getCandidat_code());
            MailHelper.codeMail(code_test,test.getTitle(),learner.getEmail(),(String)request.getSession().getAttribute("username"),test.getStart_date(),test.getEnd_date());
        }
        response.sendRedirect(request.getContextPath()+"/dashboard");
    }
}
