<%@ tag body-content="scriptless" %>
<%@ attribute name="pageTitle" required="true" type="java.lang.String" %>
<%@ tag import="java.util.Calendar" %>
<%@ tag import="java.util.Formatter" %>


<%--
  Created by IntelliJ IDEA.
  User: hamza
  Date: 1/9/2022
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>${pageTitle}</title>
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
        <div class="settings">
            <button><img src="resources/icons/settings.svg" alt="icon" class="settings"></button>
            <div class="menu">
                <ul>
                    <a href="#">
                        <li><img src="resources/icons/profile-circle.svg" alt="icon">Profile</li>
                    </a>
                    <a href="#">
                        <li><img src="resources/icons/setting-2.svg" alt="icon">Settings</li>
                    </a>
                    <a href="#">
                        <li><img src="resources/icons/logout.svg" alt="icon">Log out</li>
                    </a>
                </ul>
            </div>
            </div>
        </div>
</header>
<main>
    <jsp:doBody/>
</main>
<script src="resources/js/app.js"></script>
</body>
</html>
