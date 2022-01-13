<%@ page import="com.zone.codezone.Models.Choice" %>
<%@ page import="com.zone.codezone.Models.Question" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 12/01/2022
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Youcode</title>
</head>
<body>
.<%
    Question question = (Question) request.getAttribute("question");
    List<Choice> choices  = ( List<Choice>) request.getAttribute("choices");

%>
    <form>
        <div>
            <p><%=question.getContent()%></p>
        </div>

        <div>
            <% for (Choice choice:choices){ %>
                <div>
                    <input type="radio" name="choice" value="<%= choice.getId()%>"> <%= choice.getContent()%>
                </div>
            <% }%>

        </div>
        <div>
            <input type="button" name="validate" value="next">
        </div>
    </form>
</body>
</html>
