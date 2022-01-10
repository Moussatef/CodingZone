package com.zone.codezone.Servlet;

import com.zone.codezone.Dao.DaoFactory;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private  String test;

    public void init() {
        test = "lll";
        message = "iiii World!";

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2> 3aaafak </h2>");
        out.println("<h2>"+DaoFactory.getAllQuestions()+"</h2>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}