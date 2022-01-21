<%@ page import="com.zone.codezone.Models.Test" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zone.codezone.Dao.DaoFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Formatter" %>
<%--
  Created by IntelliJ IDEA.
  User: otman
  Date: 10/01/2022
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Test> testList = DaoFactory.getTestDao().findAll(); %>
<html>
<head>
    <link href="../resources/dashboard.css" rel="stylesheet">
    <title>Create Question</title>

</head>
<body>
<div class="container text-center">
    <form action="question-chois" method="post">




        <select class="form-select my-2" name="test_id" aria-label="Default select example">
            <option selected>Open this select menu</option>
            <% for (Test test : testList) {%>
            <option value="<%= test.getId()  %>"><%= test.getTitle().toUpperCase() %>
            </option>
            <% }%>
        </select>
        <h1> Question Chois </h1>
        <div class="input-group mt-5 mb-3">
            <div class="input-group-text">
                <span class="">is correct </span>
                <input class="form-check-input mt-0 mx-3" type="radio" name="flexRadioDefault" value="chose_one"
                       aria-label="radio for following text input">
            </div>
            <div class="form-floating w-100">
                <input type="text" name="chose_one" class="form-control " id="chose_one" placeholder="example">
                <label for="chose_one">Chose One :</label>
            </div>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-text">
                <span class="">is correct </span>
                <input class="form-radio-input mt-0 mx-3" type="radio" name="flexRadioDefault" value="chose_tow"
                       aria-label="radio for following text input">
            </div>
            <div class="form-floating w-100">
                <input type="text" name="chose_tow" class="form-control" id="chose_tow" placeholder="example">
                <label for="chose_tow">Chose tow :</label>
            </div>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-text">
                <span class="">is correct </span>
                <input class="form-radio-input mt-0 mx-3" type="radio" name="flexRadioDefault" value="chose_three"
                       aria-label="radio for following text input">
            </div>
            <div class="form-floating w-100">
                <input type="text" name="chose_three" class="form-control" id="chose_three" placeholder="example">
                <label for="chose_three">Chose three :</label>
            </div>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-text">
                <span class="">is correct </span>
                <input class="form-radio-input mt-0 mx-3" type="radio" name="flexRadioDefault" value="chose_four"
                       aria-label="radio for following text input">
            </div>
            <div class="form-floating w-100">
                <input type="text" name="chose_four" class="form-control" id="chose_four" placeholder="example">
                <label for="chose_four">Chose four :</label>
            </div>
        </div>
        <button type="submit" class="btn btn-secondary w-50 mt-5">Save</button>
    </form>
</div>










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
        <h2>Create Question</h2>

        <form method="post" action="${pageContext.request.contextPath}/question-chois">
            <div class="input-group">
                <label for="content">Question Content </label>
                <input type="text" name="content" id="content" placeholder="content" required/>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <label for="time">Question Time</label>
                    <input type="text" name="time" id="time" placeholder="question time " required/>
                </div>
                <div class="input-group">
                    <label for="score">Question Score :</label>
                    <input type="text" name="score" id="score" placeholder="Question Score" required/>
                </div>
            </div>

            <div class="input-group">
                <label for="test_id">Select Test</label>
                <select name="test_id" id="test_id" required> <!-- get all Test then loop on it -->

                    <option>Select Competence</option>
                    <% for (Test test : testList) {%>
                        <option value="<%= test.getId()  %>"><%= test.getTitle().toUpperCase() %></option>
                    <% }%>
                </select>
            </div>
            <h2>Question Choses</h2>

            <div class="card">
                <div class="card-body">
                    <div class="input-group-text">
                        <span class="">is correct </span>
                        <input class="form-check-input mt-0 mx-3" type="radio" name="flexRadioDefault" value="chose_one"
                               aria-label="radio for following text input">
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    This is some text within a card body.
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    This is some text within a card body.
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    This is some text within a card body.
                </div>
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

