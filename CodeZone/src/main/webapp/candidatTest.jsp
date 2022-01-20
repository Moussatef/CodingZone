<%@ page import="com.zone.codezone.Models.Learner" %>
<%@ page import="com.zone.codezone.Dao.DaoFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zone.codezone.Models.Test" %><%--
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
<h1 class="text-center my-5">Candidate Test</h1>
<%
    List<Learner> learnerList = DaoFactory.getDaoLearner().findAll();
    List<Test> testList = DaoFactory.getTestDao().findAll();
%>
<div class="container">
    <form action="" method="POST">
        <select class="form-select my-3" name="test">
            <option selected>Select test</option>
            <%
                for (Test test : testList) {
            %>
                <option value="<%=test.getId()%>"><%=  test.getTitle()  %></option>
            <%}%>
        </select>
        <select class="form-control my-3" size="10" name="candidats" multiple>
            <%
                for (Learner learner : learnerList) {
            %>
            <option value="<%=learner.getId()%>">
                <%= "Name : " + learner.getFirstName() + " " + learner.getLastName() %>
            </option>
            <%}%>
        </select>
        <div class="col-auto">
            <button type="submit" class="btn btn-primary mb-3">Confirm identity</button>
        </div>
    </form>
</div>
</body>
</html>
