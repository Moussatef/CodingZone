package com.zone.codezone.Servlet;

import com.zone.codezone.Dao.DaoFactory;
import com.zone.codezone.Models.Learner;
import com.zone.codezone.config.Config;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static java.lang.System.out;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private  String test;


    public void init() {
        test = "Mousstaef";
        message = "Hello World!";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Learner learner=new Learner("djjd","name","LastNAme","email2",1);
        DaoFactory.getDaoLearner().insert(learner);
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println( DaoFactory.getDaoLearner().findAll());
        out.println("<h1>" + Config.getInstance() + "</h1>");
        out.println("<h1>" + test + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}