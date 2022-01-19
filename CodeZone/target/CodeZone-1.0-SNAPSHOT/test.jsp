<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 07/01/2022
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Formatter" %>
<html>
<head>
    <title>Create Test</title>
    <link href="resources/dashboard.css" rel="stylesheet">
</head>
<body>

<aside class="card">
    <div class="logo">
        <img src="resources/logo.png" alt="logo">
    </div>
    <div class="menu">
        <ul>
            <a href="dashboard">
                <li class="active"><img src="resources/icons/category.svg" alt="icon"> Dashboard</li>
            </a>
            <a href="#">
                <li><img src="resources/icons/note-2.svg" alt="icon">Quizzes</li>
            </a>
            <a href="#">
                <li><img src="resources/icons/profile.svg" alt="icon">Users</li>
            </a>
            <a href="#">
                <li><img src="resources/icons/sms.svg" alt="icon">Messages</li>
            </a>
        </ul>
    </div>
    <div class="logout">
        <a href="logout"> <img src="resources/icons/log-out.svg" alt="icon">Sign out</a>
    </div>
</aside>
<main>
    <header class="card">
        <div class="content">
            <%
                Calendar cal = Calendar.getInstance();
                Formatter fmt = new Formatter();
                fmt.format("%td %tB %tY", cal, cal, cal);

            %>
            <p><%= fmt %>
            </p>
            <h1>Good Morning ${username}</h1>
        </div>
        <div class="user">
            <div class="avatar">
                <img src="resources/profile.jpg" alt="avatar">
            </div>
            <div>
                <p>${username}</p>
                <p>Staff</p>
            </div>
            <a href="#"><img src="resources/icons/settings.svg" alt="icon" class="settings"></a>

        </div>
    </header>
    <div class="card add-form">
            <h2>Create Test</h2>

            <form method="post" action="${pageContext.request.contextPath}/add-test">
                <div class="input-group">
                    <label for="title">Test Title</label>
                    <input type="text" name="title" id="title" placeholder="Title" required/>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <label for="start_date">Start Date</label>
                        <input type="date" name="start_date" id="start_date" placeholder="Start Date" required/>
                    </div>
                    <div class="input-group">
                        <label for="end_date">End Date</label>
                        <input type="date" name="end_date" id="end_date" placeholder="End Date" required/>
                    </div>
                </div>

                <div class="input-group">
                    <label for="competence">Competences</label>
                    <select name="competence" id="competence" required> <!-- get all competence then loop on it -->

                        <option>Select Competence</option>
                        <c:forEach items="${competence}" var="comp">
                            <option value="${comp.getId()}">${comp.getCompetence_name()}</option>
                        </c:forEach>
                    </select>
                </div>
                <c:if test="${error != null}">
                    <div class="error">
                        <p>${error}</p>
                    </div>
                </c:if>
                <input type="submit" value="Submit"/>
            </form>
        </div>
</main>
</body>
</html>
