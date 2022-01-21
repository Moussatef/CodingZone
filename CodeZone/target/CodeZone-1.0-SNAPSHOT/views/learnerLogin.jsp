<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 14/01/2022
  Time: 01:08
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

    <style>
        html,body,.code-container {
            height:100%;
        }
        .title{
            color: rgb(120, 17, 238);
        }

        .code-container {
            display:table;
            width: 100%;
            box-sizing: border-box;
        }
        .row {
            height: 100%;
            display: table-row;
        }
        .row .no-float {
            display: table-cell;
            float: none;
        }
        .code-zone{
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
    </style>
    <title>You-code</title>
</head>
<body>

<div class="container-fluid code-container m-0 p-0">
    <div class="row">
        <div class="col-6  no-float p-4">
            <div class="row code-zone">
                <h3 class="title text-start fw-bold ">Welcome onboard</h3>
                <span class="text-secondary">Please paste the code you received below
          to get started</span>
                <form method="post" action="LernerServlet">
                <input type="text" name="code" class="form-control mt-4" placeholder="Code">
                <div class="d-flex mt-4">
                    <button class="btn btn-primary px-4" type="submit">Start</button>
                </div>
                    <div class="d-flex mt-4">
                        <% if(request.getAttribute("error") != null){ %>
                            <label style="color: #FF3030"><%=request.getAttribute("error")%></label>
                        <% }%>
                    </div>
                </form>
            </div>

        </div>
        <div class="col-6  no-float" style="background-image: url('images/code.png');background-repeat: no-repeat; background-size: cover;"></div>
    </div>
</div>

</body>
</html>
