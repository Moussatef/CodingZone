<%@ page import="com.zone.codezone.Models.Learner" %>
<%@ page import="com.zone.codezone.Dao.DaoFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zone.codezone.Models.Test" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Formatter" %><%--
  Created by IntelliJ IDEA.
  User: otman
  Date: 19/01/2022
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Candidate Test</title>
    <link href="../resources/dashboard.css" rel="stylesheet">


</head>
<body>
<aside class="card">
    <div class="logo">
        <img src="../resources/logo.png" alt="logo">
    </div>
    <div class="menu">
        <ul>
            <a href="dashboard">
                <li class="active"><img src="../resources/icons/category.svg" alt="icon"> Dashboard</li>
            </a>
            <a href="#">
                <li><img src="../resources/icons/note-2.svg" alt="icon">Quizzes</li>
            </a>
            <a href="#">
                <li><img src="../resources/icons/profile.svg" alt="icon">Users</li>
            </a>
            <a href="#">
                <li><img src="../resources/icons/sms.svg" alt="icon">Messages</li>
            </a>
        </ul>
    </div>
    <div class="logout">
        <a href="logout"> <img src="../resources/icons/log-out.svg" alt="icon">Sign out</a>
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
                <img src="../resources/profile.jpg" alt="avatar">
            </div>
            <div>
                <p>${username}</p>
                <p>Staff</p>
            </div>
            <button><img src="../resources/icons/settings.svg" alt="icon" class="settings"></button>
        </div>
    </header>
<h1 class="text-center my-5">Candidate Test</h1>
<%
    List<Learner> learnerList = DaoFactory.getDaoLearner().findAll();
    List<Test> testList = DaoFactory.getTestDao().findAll();
%>
<div class="container">
    <form action="" method="POST">
        <div class="input-group">
            <select class="form-select my-3" name="test">
                <option selected>Select test</option>
                <%
                    for (Test test : testList) {
                %>
                    <option value="<%=test.getId()%>"><%=  test.getTitle()  %></option>
                <%}%>
            </select>
        </div>
        <div class="input-group">
        <select class="form-control my-3" size="10" name="candidats" multiple>
            <%
                for (Learner learner : learnerList) {
            %>
            <option value="<%=learner.getId()%>">
                <%= "Name : " + learner.getFirstName() + " " + learner.getLastName() %>
            </option>
            <%}%>
        </select>
        </div>
        <div class="input-group">
            <input type="submit" value="Confirm identity"/>
        </div>
    </form>
</div>

</body>
</html>
