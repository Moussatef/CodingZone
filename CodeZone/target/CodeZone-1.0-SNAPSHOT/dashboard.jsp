<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Formatter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: hamza
  Date: 1/9/2022
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
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
            <button><img src="resources/icons/settings.svg" alt="icon" class="settings"></button>
        </div>
    </header>
    <a href="add-test">
        <div class="card square new-quiz">
            <img src="resources/icons/add-square.svg" alt="add quiz">
            <h4>Add new quiz</h4>
            <p>click here to add a new quiz! </p>
        </div>
    </a>
    <a href="test/question">
        <div class="card square new-quiz">
            <img src="resources/icons/add-square.svg" alt="add quiz">
            <h4>Add new question</h4>
            <p>click here to add a new Question for test! </p>
        </div>
    </a>
</main>

</body>
</html>
