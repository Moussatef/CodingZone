<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 13/01/2022
  Time: 20:10
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
    <script src="https://use.fontawesome.com/0b0cb3a831.js"></script>
    <title>Youcode</title>
    <style>
        .thanks{
            height: 900px;
            display:flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        .check{
            color:rgb(15, 83, 228);
            font-size:100px;
        }
    </style>

</head>
<body>

<div class="text-center thanks">
    <h1><i class="fa fa-check check" aria-hidden="true"></i></h1>
    <h1 class="display-3">Thank You!</h1>
    <p class="lead"><strong>Please check your email</strong> you will receive  your test report in 5 min</p>
    <hr>
    <p class="lead">
        <a href="<%=request.getContextPath()+"/LernerServlet"%>" role="button">homepage</a>
    </p>
</div>
</body>
</html>
