<%@ page import="com.zone.codezone.Models.Choice" %>
<%@ page import="com.zone.codezone.Models.Question" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 12/01/2022
  Time: 12:16
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
    <title>Youcode</title>
    <style>
        div {
            display: inline-block;
            position: relative;
        }

        label {
            width: 100%;
            padding: 17px 25px 16px 2.5em;
            border: 1px solid #E9ECEF;
            border-radius: 10px;
        }

        input {
            position: absolute;
        }

        input[type="radio"]:checked+label {
            border: 3px solid #0e78e2;

        }

        .inputGroup {
            padding: 0;
            margin-bottom: 20px;
        }

        .radiochoice {
            display: none !important;
        }
    </style>
</head>
<body>
.<%
    Question question = (Question) request.getAttribute("question");
    List<Choice> choices  = ( List<Choice>) request.getAttribute("choices");
    int max =((int)request.getSession().getAttribute("lastIndex"))+1;
    int value =((int)request.getSession().getAttribute("currentIndex"))+1;

%>

        <div class="container-fluid">
            <div class="p-5 row">

                <div class="mt-5 p-5 col-8 mx-auto">
                    <div class="row justify-content-end">
                        <button class="btn btn-light" style="width: 70px;" id="timer"></button>
                    </div>
                    <div class="row">
                        <progress id="file" max="<%=max%>" value="<%=value%>"> </progress>
                    </div>

                    <br>
                    <br>

                    <p class="text-start fw-bold "><%=question.getContent()%></p>
                </div>
                <br>
                <form action="Answer" method="post" class="col-8 mx-auto" id="formAnswer">
                    <% for (Choice choice:choices){ %>
                    <div class="inputGroup bg-white d-flex ">
                        <input id="<%=choice.getId()%>" class="radiochoice" type="radio" name="choice" value="<%= choice.getId()%>">
                        <label for="<%=choice.getId()%>" class="radio"><%= choice.getContent()%></label>
                    </div>

                    <% }%>
                    <input type="text" name="time" value="" id="timeQ" hidden/>
                    <div class="d-flex justify-content-end">
                        <button class="btn" type="submit">Skip</button>
                        &nbsp;
                        <button class="btn btn-primary" id="btnsub" type="submit">Next</button>
                    </div>

                </form>

            </div>
        </div>

</body>
<script>
    document.getElementById("btnsub").onclick = function() { clearInterval(x);};
    let i = <%=question.getTime()%>;
    const x = setInterval(function () {
        i--;
        document.getElementById("timer").innerHTML = i + "s ";
        document.getElementById("timeQ").value=i;

        if (i ===0) {

            document.getElementById("btnsub").disabled = true;
            clearInterval(x);
            document.getElementById("formAnswer").submit();
        }
    }, 1000);
</script>
<script type = "text/javascript" >
    function preventBack() { window.history.forward(); }
    setTimeout("preventBack()", 0);
    window.onunload = function () { null };
</script>

</html>
