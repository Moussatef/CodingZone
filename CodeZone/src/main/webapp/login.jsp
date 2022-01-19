<%--
  Created by IntelliJ IDEA.
  User: hamza
  Date: 1/12/2022
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="resources/main.css">
    </head>
<body>
<div class="container">
    <div class="column">
        <img src="resources/login.png" alt="login image">
    </div>
    <div class="column">
        <div class="content">
            <h1>Hello There,</h1>
            <p>Please type your email & password below to connect</p>
        </div>

        <form action="login" method="post">
            <input type="text" name="username" placeholder="Username" required/>
            <input type="password" name="password" placeholder="Password" required/>
            <input type="submit" value="Login"/>
        </form>
    </div>
</div>

</body>
</html>
