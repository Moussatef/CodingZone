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
</head>
<body>
<h2>Create Test</h2>
<h1>${competence[0].getCompetence_name()}</h1>
<form method="post" action="${pageContext.request.contextPath}/Dashboard">
    <input type="text" name="title" placeholder="Title"/>
    <input type="date" name="start_date" placeholder="Start Date"/>
    <input type="date" name="end_date" placeholder="End Date"/>
    <select name="competence"> <!-- get all competence then loop on it -->

        <option>Select Competence</option>
        <c:forEach items="${competence}" var="comp">
            <option value="${comp.getId()}">${comp.getCompetence_name()}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
