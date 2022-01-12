<%@ page import="com.zone.codezone.Dao.DaoFactory" %>
<%@ page import="com.zone.codezone.DaoImpl.CompetanceDao" %>
<%@ page import="com.zone.codezone.Models.Competence" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 07/01/2022
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello request.getSession().getAttribute("username")</title>
</head>
<body>
<h1>test page</h1>
<!-- is login -->
<h2>Create Test</h2>
<form method="post" action="${pageContext.request.contextPath}/Dashboard">
    <input type="text" name="title" placeholder="Title"/>
    <input type="date" name="start_date" placeholder="Start Date"/>
    <input type="date" name="end_date" placeholder="End Date"/>
    <c:forEach items="${competence}" var="comp">
    <select name="competence"> <!-- get all competence then loop on it -->
            <option value="0">Select Competence</option>
            <option value="general">${comp}</option>
            <option value="laravel">${comp}</option>
    </select>
    </c:forEach>

    <input type="submit" value="Submit"/>
</form>
</body>
</html>
