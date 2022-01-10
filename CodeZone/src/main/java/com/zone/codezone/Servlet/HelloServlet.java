package com.zone.codezone.Servlet;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Models.Learner;
import com.zone.codezone.config.Config;
import java.io.*;
import java.sql.Connection;
import java.util.Arrays;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static java.lang.System.out;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private  String test;

    public void init() {
        test = "lll";
        message = "iiii World!";


        test = "Mousstaef";
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
      //  Learner learner=new Learner(5,"name","LastNAme","email2",1);
     //   DaoFactory.getDaoLearner().insert(learner);
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        out.println("<h2> 3aaafak </h2>");
        out.println("<h2>"+DaoFactory.getQuestions().findAll()+"</h2>");

        out.println("<h1>" + message + "</h1>");
        out.println( DaoFactory.getDaoLearner().findAll());
        System.out.println("String " + DaoFactory.getDaoLearner().findAll() );
        out.println("<h1>" + Config.getInstance() + "</h1>");
        out.println("<h1>" + test + "</h1>");
        out.println("</body></html>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        out.println("<h1>" + name + "</h1>");
        out.println("<h1>" + password + "</h1>");
        out.println("</body></html>");
        // redirect to
    }

    public void destroy() {
    }
}