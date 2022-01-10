<%--
  Created by IntelliJ IDEA.
  User: otman
  Date: 10/01/2022
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <title>Title</title>
</head>
<body>
<div class="container text-center">
<form action="question.jsp" method="post">
    <h1>TEST Question</h1>



    <table>
        <tr>
            <td>
                <div class="form-floating mb-3">
                    <input type="text" name="content" class="form-control" id="content" placeholder="example">
                    <label for="content">Content :</label>
                </div>

            </td>

        </tr>
        <tr>
            <td>
                <div class="form-floating mb-3">
                    <input type="text" name="time" class="form-control" id="time" placeholder="example">
                    <label for="time">Question Time (S) :</label>
                </div>

            </td>

        </tr>
        <tr>
            <td>
                <div class="form-floating mb-3">
                    <input type="text" name="score" class="form-control" id="score" placeholder="example">
                    <label for="score">Question Score :</label>
                </div>

            </td>

        </tr>
        <tr>
            <td>
                <div class="form-floating mb-3">
                    <input type="text" name="test_id" class="form-control" id="test_id" placeholder="example">
                    <label for="test_id">For Test</label>
                </div>

            </td>
        </tr>

    </table>
    <button type="submit" class="btn btn-secondary">Save</button>
</form>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</body>
</html>
