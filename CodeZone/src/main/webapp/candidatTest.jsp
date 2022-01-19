<%@ page import="com.zone.codezone.Models.Learner" %>
<%@ page import="com.zone.codezone.Dao.DaoFactory" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: otman
  Date: 19/01/2022
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <title>Candidate Test</title>


</head>
<body>
<h1 class="text-center">Candidate Test</h1>
<div class="container">


    <%
        List<Learner> learnerList = DaoFactory.getDaoLearner().findAll();
        for (Learner learner : learnerList) { %>
    <div class="card my-3">
        <div class="d-flex justify-content-between">
            <div class="card-body">
                <div>
                    Name : <%= learner.getFirstName() + " " + learner.getLastName()%>
                </div>
                <div>
                    Email : <%= learner.getEmail()%>
                </div>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="flexCheckIndeterminate">
            </div>
        </div>
    </div>
    <% } %>
</div>
</body>
</html>
